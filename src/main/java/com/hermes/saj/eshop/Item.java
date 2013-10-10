package com.hermes.saj.eshop;

public class Item {
    private final Product product;
    private int quantity = 1;

    public Item(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
