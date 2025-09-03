package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("admin") && password.equals("12345")) {
            Cookie cookie = new Cookie("username", username); //Creating and Sending a Cookie
            cookie.setPath("/"); // Available throughout the application
            cookie.setHttpOnly(true); // Important for security
            resp.addCookie(cookie); // Add the cookie to the response
            resp.sendRedirect("profile");
        }
    }
}
