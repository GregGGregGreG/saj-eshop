package com.hermes.saj.eshop;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ProductTest {
    @Test
    public void equivalentProductsAreEqual() {
        // given
        Product karmeliet1 = ProductMother.karmeliet();
        Product karmeliet2 = ProductMother.karmeliet();

        // then
        assertThat(karmeliet1, is(equalTo(karmeliet2)));
    }

    @Test
    public void equivalentProductsHaveSameHashCode() {
        // given
        Product karmeliet1 = ProductMother.karmeliet();
        Product karmeliet2 = ProductMother.karmeliet();

        // then
        assertThat(karmeliet1.hashCode(), is(equalTo(karmeliet2.hashCode())));
    }

    @Test
    public void productNaturalOrderingIsBasedOnName() {
        // given
        Product karmeliet = ProductMother.karmeliet();
        Product westmalle = ProductMother.westmalle();

        // then
        assertThat(karmeliet.compareTo(karmeliet), is(equalTo(0)));
        assertThat(karmeliet.compareTo(westmalle), is(lessThan(0)));
        assertThat(westmalle.compareTo(karmeliet), is(greaterThan(0)));
    }
}
