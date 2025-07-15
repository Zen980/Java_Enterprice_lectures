package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Simple validation logic
        if ("admin".equals(username) && "12345".equals(password)) { // changed to any username, try for your self
            HttpSession session = req.getSession();
            session.setAttribute("username", username); // Store username in session
            resp.sendRedirect("profile");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
