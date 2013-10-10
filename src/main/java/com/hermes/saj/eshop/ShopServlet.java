package com.hermes.saj.eshop;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Navigation.SHOP_URL)
public class ShopServlet extends AuthenticatedServlet {

    public static final String SHOP_ATTRIBUTE_NAME = "shop";
    private static final String SHOP_JSP = "/WEB-INF/shop.jsp";

    @Override
    public void init() throws ServletException {
        ShopBuilder builder = new ShopBuilder();
        builder.withProductNamed("Westmalle");
        builder.withProductNamed("Kriek");
        builder.withProductNamed("Triple Villers");
        builder.withProductNamed("Val Dieu Triple");
        builder.withProductNamed("Kasteel Blonde Triple");
        builder.withProductNamed("Karmeliet");
        final Shop shop = builder.build();
        getServletContext().setAttribute(SHOP_ATTRIBUTE_NAME, shop);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardTo(req, resp, SHOP_JSP);
    }

    static Shop getShop(ServletContext servletContext) {
        return (Shop) servletContext.getAttribute(SHOP_ATTRIBUTE_NAME);
    }
}
