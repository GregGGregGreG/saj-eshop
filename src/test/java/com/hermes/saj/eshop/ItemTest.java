package com.hermes.saj.eshop;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void comparesIsEquivalentToProductComparison() {
        // given
        final Item kasteelItem = new Item(ProductMother.kasteel());
        final Item westmallItem = new Item(ProductMother.westmalle());

        // then
        assertThat(kasteelItem.compareTo(kasteelItem), is(equalTo(0)));
        assertThat(kasteelItem.compareTo(westmallItem), is(lessThan(0)));
        assertThat(westmallItem.compareTo(kasteelItem), is(greaterThan(0)));
    }
}
