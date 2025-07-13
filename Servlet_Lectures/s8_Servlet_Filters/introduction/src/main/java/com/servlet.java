package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/firstServlet")
public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            resp.setContentType("text/html");
            resp.getWriter().println("<h2>Servlet Filter Example</h2>");
            resp.getWriter().println("<p>" + req.getAttribute("count") + "</p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
