package com.point.app.moneytransactions.product;


import com.point.app.exceptions.NotMatchingPriceException;
import com.point.app.images.Color;
import com.point.app.images.ImageRepository;
import com.point.app.moneytransactions.product.company.Company;
import com.point.app.moneytransactions.product.company.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Slf4j
@Controller
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    private final ProductService productService;

    private final ImageRepository imageRepository;

    private final CompanyRepository companyRepository;
    
    @GetMapping("{productName}")
    public String getItem(@PathVariable String productName,  Model model) throws NotMatchingPriceException {
        Company company1 = new Company("penys");
        companyRepository.save(company1);
        Product product2 = new Product(
                imageRepository.findById(4L).orElseThrow(NullPointerException::new),
                new ArrayList<>(Arrays.asList(
                        imageRepository.findById(5L).orElseThrow(NullPointerException::new),
                        imageRepository.findById(2L).orElseThrow(NullPointerException::new)
                )),
                "Product2", Color.GREEN, Size.XXXL,
                1.0, company1,5
        );

        Product product1 = new Product(
                imageRepository.findById(5L).orElseThrow(NullPointerException::new),
                new ArrayList<>(Arrays.asList(
                        imageRepository.findById(2L).orElseThrow(NullPointerException::new),
                        imageRepository.findById(3L).orElseThrow(NullPointerException::new)
                )),
                "Product2", Color.BLUE, Size.XL,
                1.0, company1, 5
        );

//        Faker faker = new Faker();

      /*  for (var i = 0; i <= 100; i++) {
            Company company = new Company(faker.company().name());
            companyRepository.save(company);
            productRepository.save( new  Product(
                    imageRepository.findById((long) faker.number().numberBetween(1, 5)).orElseThrow(NullPointerException::new),
                    new ArrayList<>(Arrays.asList(
                            imageRepository.findById((long) faker.number().numberBetween(1, 5)).orElseThrow(NullPointerException::new),
                            imageRepository.findById((long) faker.number().numberBetween(1, 5)).orElseThrow(NullPointerException::new)
                    )),
                    faker.rickAndMorty().character(), Color.BLUE, Size.XL,
                    faker.number().randomDouble(1,10,5666565), company,  faker.number().numberBetween(1,654)
        ));*/

        List<Product> products = productRepository.getProductsByName(productName);

        if (!products.isEmpty()) {
            model.addAttribute("products", products);
            products.stream().map(Product::getName).forEach(System.out::println);
            Company first = products.stream().findFirst().map(Product::getCompany)
                    .orElseThrow(NoSuchElementException::new);

            List<Product> productsOfCompany = productRepository.findAll().stream()
                    .filter(product -> product.getCompany().getName().equals(first.getName()))
                    .limit(5)
                    .toList();

            model.addAttribute("paddingProducts", productsOfCompany);

            return "Item";
        }
       return "redirect:/?err=true";

    }
}