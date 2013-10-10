package com.hermes.saj.eshop;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShopTest {
    @Test
    public void findByNameExistingProduct() {
        // given
        ShopBuilder builder = new ShopBuilder();
        builder.withProduct("Kasteel blonde");
        builder.withProduct("Westmaele triple");
        builder.withProduct("Karmeliet");
        builder.withProduct("Triple Villers");
        Shop driveIn = builder.build();

        // when
        Optional<Product> karmeliet = driveIn.findProductByName("Karmeliet");

        // then
        assertThat(karmeliet.isPresent(), is(true));
        assertThat(karmeliet.get().getName(), is(equalTo("Karmeliet")));
    }
}
