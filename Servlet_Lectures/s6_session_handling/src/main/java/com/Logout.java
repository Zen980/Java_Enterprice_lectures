package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("links.html").include(req, resp);
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            resp.sendRedirect("index.jsp");
        }else {
            resp.getWriter().println("<h1>Login first</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, resp);
        }
    }
}
