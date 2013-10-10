package com.hermes.saj.eshop;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShopTest {
    @Test
    public void findByNameExistingProduct() {
        // given
        Shop driveIn = buildShop();

        // when
        Optional<Product> karmeliet = driveIn.findProductByName(ProductMother.KARMELIET_NAME);

        // then
        assertThat(karmeliet.isPresent(), is(true));
        assertThat(karmeliet.get().getName(), is(equalTo(ProductMother.KARMELIET_NAME)));
    }

    @Test
    public void shopSortsProductsByName() {
        // given
        final Shop shop = buildShop();

        // when
        Iterable<Product> products = shop.getProducts();

        // then
        final Iterator<Product> productIterator = products.iterator();
        assertThat(productIterator.next(), is(equalTo(ProductMother.karmeliet())));
        assertThat(productIterator.next(), is(equalTo(ProductMother.kasteel())));
        assertThat(productIterator.next(), is(equalTo(ProductMother.tripleVillers())));
        assertThat(productIterator.next(), is(equalTo(ProductMother.westmalle())));
    }

    private Shop buildShop() {
        ShopBuilder builder = new ShopBuilder();
        builder.withProductNamed(ProductMother.KASTEEL_NAME);
        builder.withProductNamed(ProductMother.WESTMALLE_NAME);
        builder.withProductNamed(ProductMother.KARMELIET_NAME);
        builder.withProductNamed(ProductMother.TRIPLE_VILLERS_NAME);
        return builder.build();
    }
}
