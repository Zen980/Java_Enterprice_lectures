package com;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "sampleFilter",urlPatterns = "/servlet/*")
public class filter implements Filter {
    public static int count = 0;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        count++;
        request.setAttribute("count", count);
        System.out.println(count);
        chain.doFilter(request, response);
    }
   
}