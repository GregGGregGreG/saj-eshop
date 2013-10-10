package com.hermes.saj.eshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AuthenticatedServlet extends AbstractServlet {
    private static final String AUTHENTICATED_ATTRIBUTE_NAME = "authenticated";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isAuthenticated(req)) {
            delegateToNormalServiceMethod(req, resp);
        } else {
            redirectToAbsolutePath(req, resp, Navigation.LOGIN_URL);
        }
    }

    private boolean isAuthenticated(HttpServletRequest req) {
        return Boolean.TRUE.equals(getAuthenticatedAttribute(req));
    }

    private Boolean getAuthenticatedAttribute(HttpServletRequest req) {
        return (Boolean) req.getSession().getAttribute(AUTHENTICATED_ATTRIBUTE_NAME);
    }

    private void delegateToNormalServiceMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    static void authenticate(HttpServletRequest req) {
        req.getSession().setAttribute(AUTHENTICATED_ATTRIBUTE_NAME, Boolean.TRUE);
    }

    static void logout(HttpServletRequest req) {
        req.getSession().removeAttribute(AUTHENTICATED_ATTRIBUTE_NAME);
    }
}
