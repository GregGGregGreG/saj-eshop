package com.hermes.saj.eshop;

class ProductMother {

    public static final String KASTEEL_NAME = "Kasteel blonde";
    public static final String TRIPLE_VILLERS_NAME = "Triple Villers";
    public static final String WESTMALLE_NAME = "Westmalle blonde";
    public static final String KARMELIET_NAME = "Karmeliet";

    public static Product karmeliet() {
        return new Product(KARMELIET_NAME);
    }

    public static Product westmalle() {
        return new Product(WESTMALLE_NAME);
    }

    public static Product tripleVillers() {
        return new Product(TRIPLE_VILLERS_NAME);
    }

    public static Product kasteel() {
        return new Product(KASTEEL_NAME);
    }
}
