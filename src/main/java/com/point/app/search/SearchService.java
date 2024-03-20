package com.point.app.search;

import com.point.app.moneytransactions.product.Product;
import com.point.app.moneytransactions.product.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;

    private ResponseEntity<List<Product>> getProductsByUsername(String givenString) {
        List<Product> productsBySubstring = productRepository.findUniqueProductsByName(givenString);
        productsBySubstring.stream().map(Product::getName).forEach(System.out::println);
        return new ResponseEntity<>(productsBySubstring, HttpStatus.OK);
    }

}
