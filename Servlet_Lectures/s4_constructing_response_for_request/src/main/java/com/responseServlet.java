package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/responseServlet")
public class responseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // set the content type of the response
        /*
         * Here, we can write the code to process the request and generate the response.
         * In this example, we are just getting the value of the form submited from the
         * client by input name attribute.
         * We can use the req.getParameter() method to get the value of the input field.
         * The name of the input field is "name" in this example.
         * we can also get the values of multiple checkboxes using the
         * req.getParameterValues() method.
         */
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String hobbies[] = req.getParameterValues("hobbies");

        // Now, we can generate the response using the PrintWriter class.
        PrintWriter out = resp.getWriter();
        out.println("<h2>Name : " + name + "</h2>");
        out.println("<h2>Email : " + email + "</h2>");
        out.println("<h2>Gender : " + gender + "</h2>");
        out.println("<h2>Hobbies : </h2>");
        out.println("<ol>");
        for (String hobbie : hobbies) {
            out.println("<li>" + hobbie + "</li>");
        }
        out.println("</ol>");
    }
}
