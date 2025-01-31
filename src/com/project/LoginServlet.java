package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded login credentials (for demonstration purposes only)
        String validUsername = "admin";
        String validPassword = "secret";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Verify credentials
        if (username.equals(validUsername) && password.equals(validPassword)) {
            out.println("<html><body>");
            out.println("<h3>Login Successful!</h3>");
            out.println("<p>Welcome, " + username + "!</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h3>Login Failed!</h3>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href=\"login.html\">Try Again</a>");
            out.println("</body></html>");
        }
    }
}

/*The line <a href=\"login.html\">Try Again</a> is an HTML anchor tag (<a>) that creates a hyperlink on the page. Here's a breakdown of what it does:
Explanation:
<a> Tag: This is an anchor tag in HTML, used to create hyperlinks to other pages or resources.
href Attribute: The href (hyperlink reference) attribute specifies the URL or path to which the link points. In this case, it points to login.html.
Try Again: This is the text that will be displayed as the clickable part of the hyperlink on the web page.
What It Does:
When the user clicks on the text "Try Again," they will be redirected to the login.html page. This is typically used to allow the user to return to the login form after a failed login attempt, giving them a chance to retry entering their credentials.
*/

/*
 package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of the database
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/yourDatabase";
    private static final String DB_USER = "yourUsername";
    private static final String DB_PASSWORD = "yourPassword";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the database driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare a SQL statement to check user credentials
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Login successful
                out.println("<html><body>");
                out.println("<h3>Login Successful!</h3>");
                out.println("<p>Welcome, " + username + "!</p>");
                out.println("</body></html>");
            } else {
                // Login failed
                out.println("<html><body>");
                out.println("<h3>Login Failed!</h3>");
                out.println("<p>Invalid username or password.</p>");
                out.println("<a href=\"login.html\">Try Again</a>");
                out.println("</body></html>");
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h3>Error occurred while processing the request.</h3>");
            out.println("</body></html>");
        }
    }
}
*/

