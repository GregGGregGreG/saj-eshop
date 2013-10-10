package com.hermes.saj.eshop;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;

public class ShoppingCart {
    private Collection<Item> items = Lists.newLinkedList();

    synchronized public void add(Product product) {
        Item item = new Item(product);
        items.add(item);
    }

    synchronized public Iterable<Item> getItems() {
        return ImmutableList.copyOf(items);
    }
}
