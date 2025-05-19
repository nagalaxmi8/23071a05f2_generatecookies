package com.example.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Simple dummy check (you can add DB check here)
        if (email != null && password != null) {
            // Creating 4 cookies
            Cookie c1 = new Cookie("userEmail", email);
            Cookie c2 = new Cookie("loginTime", String.valueOf(System.currentTimeMillis()));
            Cookie c3 = new Cookie("userType", "student");
            Cookie c4 = new Cookie("sessionID", request.getSession().getId());

            // Set max age (optional)
            c1.setMaxAge(60 * 60); // 1 hour
            c2.setMaxAge(60 * 60);
            c3.setMaxAge(60 * 60);
            c4.setMaxAge(60 * 60);

            // Add cookies to response
            response.addCookie(c1);
            response.addCookie(c2);
            response.addCookie(c3);
            response.addCookie(c4);

            // Redirect to cookie display page
            response.sendRedirect("displayCookies");
        } else {
            response.getWriter().println("Invalid login details");
        }
    }
}
