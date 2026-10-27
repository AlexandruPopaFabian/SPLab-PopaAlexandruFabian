package com.example.designpatternslab2026.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        // Log înainte de procesare
        System.out.println("[LOG BEFORE] Incoming Request: " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);

        // Log după procesare
        System.out.println("[LOG AFTER] Processed Request: " + req.getMethod() + " " + req.getRequestURI());
    }
}