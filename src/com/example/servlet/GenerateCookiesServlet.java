package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GenerateCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Create cookies
        Cookie cookie1 = new Cookie("username", "john_doe");
        Cookie cookie2 = new Cookie("userRole", "admin");
        Cookie cookie3 = new Cookie("preferredLanguage", "en");

        // Set cookie max age (in seconds) - optional
        cookie1.setMaxAge(60 * 60 * 24); // 1 day
        cookie2.setMaxAge(60 * 60 * 24); // 1 day
        cookie3.setMaxAge(60 * 60 * 24); // 1 day

        // Add cookies to response
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);

        // Send response to browser
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>3 Cookies have been added to your browser.</h2>");
        response.getWriter().println("</body></html>");
    }
}
