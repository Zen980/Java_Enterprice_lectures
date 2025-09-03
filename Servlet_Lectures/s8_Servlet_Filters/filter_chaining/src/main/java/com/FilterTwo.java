package com;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// FilterTwo is the second filter in the chain.
@WebFilter(filterName = "FilterTwo", urlPatterns = "/simple")
public class FilterTwo implements Filter {

    private static final Logger logger = Logger.getLogger(FilterTwo.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("FilterTwo initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Executing FilterTwo - Pre-processing.");

        // Pass the request to the next component (in this case, the servlet).
        chain.doFilter(request, response);

        logger.info("Executing FilterTwo - Post-processing.");
    }

    @Override
    public void destroy() {
        logger.info("FilterTwo destroyed.");
    }
}

