package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * A simple Jakarta Servlet Filter that demonstrates the use of annotations
 * for configuration. The filter name and initialization parameters are defined
 * directly on the class using @WebFilter and @WebInitParam.
 */
@WebFilter(
    filterName = "MyAnnotationFilter",
    urlPatterns = {"/*"},
    initParams = {
        @WebInitParam(name = "welcomeMessage", value = "Hello from the annotated filter!")
    }
)
public class MyFilter implements Filter {

    /**
     * This method is called by the servlet container to initialize the filter.
     * The FilterConfig object is provided by the container and contains the
     * configuration information defined by the annotations.
     *
     * @param filterConfig The FilterConfig object containing the filter's configuration.
     * @throws ServletException if an initialization error occurs.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // The init parameter is retrieved in the same way, but its value
        // is now sourced from the @WebInitParam annotation.
        String initParamValue = filterConfig.getInitParameter("welcomeMessage");
        System.out.println("Annotated filter initialized. The 'welcomeMessage' init parameter is: " + initParamValue);

        // Get the name of the filter as defined by the @WebFilter annotation.
        String filterName = filterConfig.getFilterName();
        System.out.println("Filter name: " + filterName);

        // Get the ServletContext for the web application.
        ServletContext context = filterConfig.getServletContext();
        System.out.println("Context path of the web application: " + context.getContextPath());
    }

    /**
     * The main filtering method. This is called for each request that matches the
     * filter's URL pattern.
     *
     * @param request The ServletRequest object.
     * @param response The ServletResponse object.
     * @param chain The FilterChain object to pass the request to the next filter or servlet.
     * @throws IOException if an I/O error occurs during the filter chain processing.
     * @throws ServletException if a servlet error occurs during the filter chain processing.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("MyFilter is doing its job before the request is processed.");

        // Pass the request along the filter chain.
        chain.doFilter(request, response);

        System.out.println("MyFilter is doing its job after the response is generated.");
    }

    /**
     * This method is called by the servlet container when the filter is about to be taken
     * out of service.
     */
    @Override
    public void destroy() {
        System.out.println("MyFilter is being destroyed.");
    }
}

