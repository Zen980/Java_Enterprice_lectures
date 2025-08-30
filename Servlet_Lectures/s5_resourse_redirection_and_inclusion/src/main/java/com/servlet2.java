package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servlet2" })
public class servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>This is servlet 2</h1>");
        RequestDispatcher rd = req.getRequestDispatcher("servlet3");
        rd.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>This is servlet 2</h1>");

        /*
         * The RequestDispatcher is forwarded through post method make
         * sure to handle through post method.
         */

        RequestDispatcher rd = req.getRequestDispatcher("servlet3"); // notice in output url remains servlet2 not changed to servlet3
        rd.forward(req, resp);
    }

}
