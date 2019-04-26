package com.milestoneplanner.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.milestoneplanner.db.H2User;
import com.milestoneplanner.model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    private H2User h2User = new H2User();
//    public UserServlet(H2User h2User){
//        this.h2User = h2User;
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(first, last, email, password );
        this.h2User.addUser(user);
        response.sendRedirect("indexsignup.jsp");
//        RequestDispatcher req = request.getRequestDispatcher("project.jsp");
//        req.forward(request, response);
//        System.out.println("in servlet, yes");
    }
}
