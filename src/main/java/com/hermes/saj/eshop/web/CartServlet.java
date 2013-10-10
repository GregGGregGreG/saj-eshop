package com.hermes.saj.eshop.web;

import com.google.common.base.Optional;
import com.hermes.saj.eshop.Product;
import com.hermes.saj.eshop.Shop;
import com.hermes.saj.eshop.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(Navigation.CART_URL)
public class CartServlet extends AuthenticatedServlet {

    private static final String CART_ATTRIBUTE = "cart";
    private static final String PRODUCT_NAME_PARAMETER = "productName";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Optional<Product> optionalProduct = findProduct(req);
        if (optionalProduct.isPresent()) {
            synchronizAddProductToCart(optionalProduct.get(), req);
        }
        redirectToAbsolutePath(req, resp, Navigation.SHOP_URL);
    }

    private Optional<Product> findProduct(HttpServletRequest req) {
        final String productName = req.getParameter(PRODUCT_NAME_PARAMETER);
        final Shop shop = ShopServlet.getShop(getServletContext());
        return shop.findProductByName(productName);
    }

    private void synchronizAddProductToCart(Product product, HttpServletRequest req) {
        final HttpSession session = req.getSession();
        synchronized (session) {
            addProductToCart(product, session);
        }
    }

    private void addProductToCart(Product product, HttpSession session) {
        final ShoppingCart cart = getCartOrCreateOne(session);
        cart.add(product);
    }

    private ShoppingCart getCartOrCreateOne(HttpSession session) {
        ShoppingCart cart = getCartAttribute(session);
        if (cart == null) {
            cart = createCartAndStoreInSession(session);
        }
        return cart;
    }

    private ShoppingCart createCartAndStoreInSession(HttpSession session) {
        final ShoppingCart cart = new ShoppingCart();
        session.setAttribute(CART_ATTRIBUTE, cart);
        return cart;
    }

    private ShoppingCart getCartAttribute(HttpSession session) {
        return (ShoppingCart) session.getAttribute(CART_ATTRIBUTE);
    }

}
