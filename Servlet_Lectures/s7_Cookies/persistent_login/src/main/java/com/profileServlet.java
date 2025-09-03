package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class profileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
            Cookie cookies[] = req.getCookies();
            req.getRequestDispatcher("links.html").include(req, resp); // Include links.html for navigation
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        out.println("<h1>Welcome " + cookie.getValue() + "</h1>");
                        out.println("<a href='logout'>Logout</a>");
                        return; // User is logged in, exit the method
                    }
                }
            } else {
                out.println("<h1>You are not logged in.</h1>");
                req.getRequestDispatcher("index.jsp").include(req, resp); // Include links.html for navigation
                // User is not logged in, exit the method
            }
    }
}