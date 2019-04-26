package com.milestoneplanner.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.milestoneplanner.db.H2User;
import com.milestoneplanner.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.milestoneplanner.servlet.Runner;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private H2User h2User = new H2User();
//    String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("login.jsp").forward(request, response);
        response.setContentType("text/html");
        response.setStatus(200);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in login servlet");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user1 = new User(email,password);
        boolean isUserValid = this.h2User.getUser(user1);

        if (isUserValid) {
            request.getSession().setAttribute("email", email);
//            response.sendRedirect("/list");
            //RequestDispatcher req = request.getRequestDispatcher("project.jsp");
            //req.forward(request, response);
            response.sendRedirect("/ListServlet");
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials!");
//            request.getRequestDispatcher("login.jsp").forward(
//                    request, response);
            RequestDispatcher req = request.getRequestDispatcher("indexsignup.jsp");
            req.forward(request, response);
        }
    }

}