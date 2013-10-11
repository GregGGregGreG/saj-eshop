package com.hermes.saj.eshop.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { Navigation.LOGIN_URL, Navigation.ROOT_URL })
public class LoginServlet extends AbstractServlet {

    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String VALID_PASSWORD = "password";
    private static final String VALID_USER_NAME = "user";
    private static final String LOGIN_JSP = "/WEB-INF/login.jsp";
    private static final String AUTHENTICATION_FAILED_ATTRIBUTE = "authenticationFailed";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardTo(req, resp, LOGIN_JSP);
        resetAuthenticationFailed(req);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isLoginVerified(req) && isPasswordVerified(req)) {
            authenticateAndRedirectToShop(req, resp);
        } else {
            failAuthenticationAndRedirectToLoginForm(req, resp);
        }
    }

    private boolean isLoginVerified(HttpServletRequest req) {
        final String login = req.getParameter(LOGIN_PARAMETER);
        return login.equals(VALID_USER_NAME);
    }

    private boolean isPasswordVerified(HttpServletRequest req) {
        final String password = req.getParameter(PASSWORD_PARAMETER);
        return password.equals(VALID_PASSWORD);
    }

    private void authenticateAndRedirectToShop(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AuthenticatedServlet.authenticate(req);
        redirectToAbsolutePath(req, resp, Navigation.SHOP_URL);
    }

    private void failAuthenticationAndRedirectToLoginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        failAuthentication(req);
        redirectToAbsolutePath(req, resp, Navigation.LOGIN_URL);
    }

    private void failAuthentication(HttpServletRequest req) {
        AuthenticatedServlet.logout(req);
        req.getSession().setAttribute(AUTHENTICATION_FAILED_ATTRIBUTE, Boolean.TRUE);
    }

    private void resetAuthenticationFailed(HttpServletRequest req) {
        req.getSession().removeAttribute(AUTHENTICATION_FAILED_ATTRIBUTE);
    }
}
