package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;
import com.milestoneplanner.model.User;

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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();
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
        String milestone_name = request.getParameter("milestone_name");
        String milestone_des = request.getParameter("milestone_des");
        String due_date = request.getParameter("due_date");
        String completion_date = request.getParameter("completion_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String email = (String)request.getSession().getAttribute("email");

        try {
            Date dueDate = sdf.parse(due_date);
            Date completionDate = sdf.parse(completion_date);
            Milestone milestone = new Milestone(milestone_name, milestone_des, dueDate, completionDate, email);
            h2Milestone.addMilestone(milestone);
//            response.sendRedirect("list");
        }
        catch (ParseException e)
        {
            System.out.print(e);
        }

        response.sendRedirect("/ListServlet");

    }
}
