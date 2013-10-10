package com.hermes.saj.eshop;

import com.google.common.collect.Iterables;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {

    @Test
    public void addingANewProductSetsQuantityTo1() {
        // given
        Product karmeliet = ProductMother.karmeliet();
        ShoppingCart myCart = new ShoppingCart();

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
        Product karmeliet = ProductMother.karmeliet();
        ShoppingCart myCart = new ShoppingCart();
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

}
