package com.example.designpatternslab2026.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
@WebFilter(urlPatterns = "/*")
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();

        // Ignoră logarea pentru cererile interne ale H2 Console
        if (path.startsWith("/h2-console")) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("[LOG BEFORE] Incoming Request: " + req.getMethod() + " " + path);
        chain.doFilter(request, response);
        System.out.println("[LOG AFTER] Processed Request: " + req.getMethod() + " " + path);
    }
}