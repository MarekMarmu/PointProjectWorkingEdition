package com.point.app.moneytransactions.product;

import com.point.app.exceptions.ProductDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(ProductDoesNotExistException::new);
    }

    public List<Product> getProductById(Long... productsId) {
        List<Product> products = new ArrayList<>();
        Arrays.stream(productsId).forEach(productId ->
                products.add(productRepository.findProductById(productId).orElseThrow(ProductDoesNotExistException::new))
        );
        return products;
    }

}