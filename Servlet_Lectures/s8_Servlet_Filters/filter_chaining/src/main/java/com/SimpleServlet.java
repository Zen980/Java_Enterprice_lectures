package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// SimpleServlet is the target for our filter chain.
@WebServlet(name = "SimpleServlet", urlPatterns = "/simple")
public class SimpleServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SimpleServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Executing SimpleServlet.");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Hello from SimpleServlet!");
        out.println("Check the server console to see the filter execution order.");
    }
}

