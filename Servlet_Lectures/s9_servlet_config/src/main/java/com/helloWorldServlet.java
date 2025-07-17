package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/hello"},
            initParams = {
                @WebInitParam(name = "firstName", value = "John"),
                @WebInitParam(name = "lastName", value = "Doe")
            })
public class helloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World from Servlet Config</h1>");
        ServletConfig config = this.getServletConfig();
        String fname = config.getInitParameter("firstName"); // Retrieve the first name from init parameters
        String lname = config.getInitParameter("lastName"); // Retrieve the last name from init parameters
        out.println("<h2>First Name: " + fname + "</h2>");
        out.println("<h2>Last Name: " + lname + "</h2>");
        out.println("</body></html>");
    }

}
