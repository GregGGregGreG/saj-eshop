package com.hermes.saj.eshop;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import java.util.Set;

public class ShoppingCart {
    private Set<Item> items = Sets.newHashSet();

    synchronized public void add(Product product) {
        Item item = findProductItemOrCreateNewOne(product);
        item.incrementQuantity();
    }

    synchronized public Iterable<Item> getItems() {
        return ImmutableList.copyOf(items);
    }

    private Item findProductItemOrCreateNewOne(Product product) {
        final Optional<Item> optionalItem = findProductItem(product);
        if (optionalItem.isPresent())
            return optionalItem.get();
        else
            return createItemAndAddItToItems(product);
    }

    private Item createItemAndAddItToItems(Product product) {
        final Item item = new Item(product);
        items.add(item);
        return item;
    }

    private Optional<Item> findProductItem(Product product) {
        for (Item item : items) {
            if (item.isFor(product)) {
                return Optional.of(item);
            }
        }
        return Optional.absent();
    }
}
