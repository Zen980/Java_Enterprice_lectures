package com;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * This class demonstrates Jakarta Servlet Filter chaining using annotations.
 * The request will pass through FilterOne and then FilterTwo before
 * reaching the SimpleServlet.
 *
 * To run this example:
 * 1. Ensure you have a Jakarta EE compatible server (e.g., Tomcat, WildFly).
 * 2. Add the Jakarta Servlet API dependency to your project.
 * 3. Compile and deploy this single .java file as a web application.
 * 4. Access the servlet at a URL like http://localhost:8080/your-app-name/simple.
 */

// FilterOne is the first filter in the chain.
@WebFilter(filterName = "FilterOne", urlPatterns = "/simple")
public class FilterOne implements Filter {

    private static final Logger logger = Logger.getLogger(FilterOne.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("FilterOne initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Log a message before passing the request down the chain.
        logger.info("Executing FilterOne - Pre-processing.");

        // This line is crucial! It passes the request and response to the next filter
        // in the chain, or to the servlet if this is the last filter.
        chain.doFilter(request, response);

        // Log a message after the rest of the chain has executed.
        logger.info("Executing FilterOne - Post-processing.");
    }

    @Override
    public void destroy() {
        logger.info("FilterOne destroyed.");
    }
}