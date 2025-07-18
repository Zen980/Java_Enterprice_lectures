package com;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletContext context = this.getServletContext(); // Get the ServletContext object
        String communitymail = context.getInitParameter("community-mail"); // Retrieve the community mail parameter from the web.xml file
        String adminmail = context.getInitParameter("admin-mail");// Retrieve the admin mail parameter from the web.xml file
        resp.getWriter().println("ServletContext Path: " + context.getContextPath() + "<br>");
        resp.getWriter().println("Community Mail: " + communitymail + "<br>");
        resp.getWriter().println("Admin Mail: " + adminmail + "<br>");
    }
}
