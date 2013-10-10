package com.hermes.saj.eshop;

import com.google.common.base.Objects;

public class Item {
    private final Product product;
    private int quantity = 0;

    public Item(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    boolean isFor(Product product) {
        return Objects.equal(this.product, product);
    }

    public void incrementQuantity() {
        quantity++;
    }
}
