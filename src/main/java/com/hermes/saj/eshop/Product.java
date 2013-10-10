package com.hermes.saj.eshop;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Product implements Comparable<Product> {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!obj.getClass().equals(getClass())) return false;

        Product rhs = (Product) obj;

        return Objects.equal(name, rhs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("name", name).toString();
    }

    @Override
    public int compareTo(Product that) {
        return ComparisonChain.start().compare(this.name, that.name).result();
    }
}
