package com.hermes.saj.eshop;

import com.google.common.collect.Iterables;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {

    @Test
    public void addingANewProductSetsQuantityTo1() {
        // given
        final ShoppingCart myCart = new ShoppingCart();
        final Product karmeliet = ProductMother.karmeliet();

        // when
        myCart.add(karmeliet);

        // then
        final Iterable<Item> items = myCart.getItems();
        assertThat(Iterables.size(items), is(equalTo(1)));
        final Item onlyItem = Iterables.getOnlyElement(items);
        assertThat(onlyItem.getProduct(), is(equalTo(karmeliet)));
        assertThat(onlyItem.getQuantity(), is(equalTo(1)));
    }

    @Test
    public void addingAProductAlreadyPresentIncrementsQuantity() {
        // given
        final ShoppingCart myCart = new ShoppingCart();
        final Product karmeliet = ProductMother.karmeliet();
        myCart.add(karmeliet);

        // then
        addProductToCartAndCheckQuantity(karmeliet, myCart, 2);
        addProductToCartAndCheckQuantity(karmeliet, myCart, 3);
        addProductToCartAndCheckQuantity(karmeliet, myCart, 4);
    }

    private void addProductToCartAndCheckQuantity(Product product, ShoppingCart cart, int expectedQuantity) {
        // when
        cart.add(product);

        // then
        final Iterable<Item> items = cart.getItems();
        final Item onlyItem = Iterables.getOnlyElement(items);
        assertThat(onlyItem.getQuantity(), is(equalTo(expectedQuantity)));
    }

    @Test
    public void cartWith2KarmelietAnd3WestmalleHas5ItemsInTotal() {
        // given
        final ShoppingCart cart = new ShoppingCart();
        final Product karmeliet = ProductMother.karmeliet();
        final Product westmalle = ProductMother.westmalle();

        // when
        cart.add(karmeliet);
        cart.add(karmeliet);

        cart.add(westmalle);
        cart.add(westmalle);
        cart.add(westmalle);

        // then
        assertThat(cart.getItemTotal(), is(equalTo(5)));
    }

    @Test
    public void itemsAreSortedAccordingToProductName() {
        // given
        final ShoppingCart cart = new ShoppingCart();
        final Product karmeliet = ProductMother.karmeliet();
        cart.add(karmeliet);
        final Product westmalle = ProductMother.westmalle();
        cart.add(westmalle);
        final Product kasteel = ProductMother.kasteel();
        cart.add(kasteel);
        final Product tripleVillers = ProductMother.tripleVillers();
        cart.add(tripleVillers);

        // when
        final Iterable<Item> items = cart.getItems();

        // then
        final Iterator<Item> itemIterator = items.iterator();
        assertThat(nextProduct(itemIterator), is(equalTo(karmeliet)));
        assertThat(nextProduct(itemIterator), is(equalTo(kasteel)));
        assertThat(nextProduct(itemIterator), is(equalTo(tripleVillers)));
        assertThat(nextProduct(itemIterator), is(equalTo(westmalle)));
    }

    private Product nextProduct(Iterator<Item> itemIterator) {
        final Item item = itemIterator.next();
        return item.getProduct();
    }
}
