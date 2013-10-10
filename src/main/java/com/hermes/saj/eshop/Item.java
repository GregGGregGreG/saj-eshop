package com.hermes.saj.eshop;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Item implements Comparable<Item> {
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

    void incrementQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("product", product.getName()).add("qty", quantity).toString();
    }

    @Override
    public int compareTo(Item that) {
        return ComparisonChain.start().compare(this.product, that.product).result();
    }
}
