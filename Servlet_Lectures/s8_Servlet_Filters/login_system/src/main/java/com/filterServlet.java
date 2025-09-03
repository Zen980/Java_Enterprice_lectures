package com;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/profile" }, dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.REQUEST })
//This Filter is mapped all servlet requested for profile link.
public class filterServlet implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            // Not logged in, redirect to login page
            res.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        if ("admin".equalsIgnoreCase(username)) {
            // Admin user, redirect to admin panel
            res.sendRedirect(req.getContextPath() + "/profile/adminPanel");
            System.out.print(req.getContextPath() + "/profile/adminPanel");
            return;
        } else {
            // Regular user, redirect to user panel
            res.sendRedirect(req.getContextPath() + "/profile/userPanel");
            return;
        }
    }

}
