package com.hermes.saj.eshop;

import com.google.common.collect.Sets;

import java.util.Set;

public class ShopBuilder {
    private Set<Product> products = Sets.newHashSet();

    public void withProduct(String productName) {
        Product product = new Product(productName);
        products.add(product);
    }

    public Shop build() {
        return new Shop(products);
    }
}
