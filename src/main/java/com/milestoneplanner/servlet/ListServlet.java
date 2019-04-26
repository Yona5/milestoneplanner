package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2User;
import com.milestoneplanner.model.Milestone;
import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String)request.getSession().getAttribute("email");
        List<Milestone> listMilestone = h2Milestone.findMilestones(email);
        request.setAttribute("listMilestone",listMilestone);
        request.getRequestDispatcher("project.jsp").forward(request,response);
        response.setContentType("text/html");
        response.setStatus(200);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
