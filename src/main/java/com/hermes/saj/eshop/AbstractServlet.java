package com.hermes.saj.eshop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet extends HttpServlet {
    protected void redirectToAbsolutePath(HttpServletRequest req, HttpServletResponse resp, String relativePath) throws IOException {
        final String redirectPath = req.getContextPath() + relativePath;
        redirectToEncodedPath(resp, redirectPath);
    }

    private void redirectToEncodedPath(HttpServletResponse resp, String redirectPath) throws IOException {
        final String encodedRedirectPath = resp.encodeRedirectURL(redirectPath);
        resp.sendRedirect(encodedRedirectPath);
    }

    protected void forwardTo(HttpServletRequest req, HttpServletResponse resp, String jspPath) throws ServletException, IOException {
        final RequestDispatcher dispatcher = req.getRequestDispatcher(jspPath);
        dispatcher.forward(req, resp);
    }
}
