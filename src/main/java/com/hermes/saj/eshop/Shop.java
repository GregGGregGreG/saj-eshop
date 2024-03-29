package com.hermes.saj.eshop;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSortedSet;

import java.util.Collection;

public class Shop {
    private final Collection<Product> products;

    public Shop(Collection<Product> products) {
        this.products = ImmutableSortedSet.copyOf(products);
    }

    public Optional<Product> findProductByName(String productName) {
        for (Product product : products) {
            if (product.hasName(productName)) {
                return Optional.of(product);
            }
        }
        return Optional.absent();
    }

    public Iterable<Product> getProducts() {
        return products;
    }
}
