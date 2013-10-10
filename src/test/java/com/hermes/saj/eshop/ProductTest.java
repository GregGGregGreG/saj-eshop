package com.hermes.saj.eshop;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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
}
