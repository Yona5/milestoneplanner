package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();
//    public UserServlet(H2User h2User){
//        this.h2User = h2User;
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Milestone milestone = new Milestone(id);
        h2Milestone.removeMilestone(milestone);
        response.sendRedirect("/ListServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Milestone milestone = new Milestone(id);
//        h2Milestone.removeMilestone(milestone);
//        response.sendRedirect("/ListServlet");
    }
}
