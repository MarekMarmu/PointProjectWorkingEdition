package com.point.app.search;

import com.point.app.moneytransactions.product.Product;
import com.point.app.moneytransactions.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
public class SearchController {
    private final ProductRepository productRepository;


    @GetMapping("/search")
    public ResponseEntity<List<Product>> getSearchedItems(@RequestParam("query") String givenString) {
        if (!givenString.isBlank()) {
            List<Product> productsBySubstring = productRepository.findUniqueProductsByName(givenString);
            productsBySubstring.stream().map(Product::getName).forEach(System.out::println);
            return new ResponseEntity<>(productsBySubstring, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    }

