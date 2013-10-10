package com.hermes.saj.eshop;

import com.google.common.base.Objects;

public class Product {
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
}
