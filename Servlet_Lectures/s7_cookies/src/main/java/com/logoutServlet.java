package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("links.html").include(req, resp); // Include links.html for navigation
        
        Cookie cookie = new Cookie("username", ""); // Create a cookie with an empty value
        cookie.setMaxAge(0); // Set the max age to 0 to delete the cookie
        cookie.setPath("/"); // Ensure the path matches where the cookie was set
        resp.addCookie(cookie); // Add the cookie to the response to delete it

        out.println("<p>You have been logged out successfully.</p>");
        req.getRequestDispatcher("index.jsp").include(req, resp); // Redirect to index.jsp after logout
    }
}
