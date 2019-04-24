package com.milestoneplanner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milestoneplanner.servlet.Runner;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private LoginService userValidationService = new LoginService();
    private TodoService todoService = new TodoService();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isUserValid = userValidationService.isUserValid(username, password);

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