package com.point.app.moneytransactions.product;


import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;

@Component
public class ShoppingCart implements Iterable{
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void addItem(Product... product) {
        items.addAll(Arrays.asList(product));
    }
    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }


    @Override
    public Iterator<Product> iterator() {
        return items.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        items.forEach(action);
    }

}