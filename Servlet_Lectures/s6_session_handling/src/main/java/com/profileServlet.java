package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            req.getRequestDispatcher("links.html").include(req, resp);
            HttpSession session = req.getSession(false);
            if (session != null) {
                String name = (String) session.getAttribute("username");
                out.println("<h1>welcome, " + name + "</h1>");
            } else {
                out.println("<h1>Login first</h1>");
                req.getRequestDispatcher("index.jsp").include(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
