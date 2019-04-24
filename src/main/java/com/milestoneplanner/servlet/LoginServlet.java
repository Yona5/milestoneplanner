package com.milestoneplanner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.milestoneplanner.db.H2User;
import com.milestoneplanner.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.milestoneplanner.servlet.Runner;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private H2User h2User = new H2User();

    String jdbcURL = getServletContext().getInitParameter("jdbcURL");



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user =new User(username,password);
        boolean isUserValid = h2User.getUser(user);

        if (isUserValid) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/list");
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials!");
            request.getRequestDispatcher("login.jsp").forward(
                    request, response);
        }
    }

}