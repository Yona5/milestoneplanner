package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();
//    public UserServlet(H2User h2User){
//        this.h2User = h2User;
//    }
//int milestoneId;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
///       int id = Integer.parseInt(request.getParameter("id"));
//        response.setContentType("text/html");
//        response.setStatus(200);
//        System.out.println(request.getParameter("id"));
//         milestoneId = Integer.parseInt(request.getParameter("id"));
//        System.out.println(milestoneId);
//        request.setAttribute("milestone",h2Milestone.getMilestone(milestoneId));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("above id");
//        System.out.println(request.getParameter("id"));
//        int id = milestoneId;
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("this is the id " + id);
        String milestone_name = request.getParameter("milestone_name");

        String milestone_des = request.getParameter("milestone_des");
        String completion_date = request.getParameter("completion_date");
        String due_date = request.getParameter("due_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dueDate = sdf.parse(due_date);
            Date completionDate = sdf.parse(completion_date);
            Milestone milestone = new Milestone(milestone_name, milestone_des, dueDate, completionDate, id);
            h2Milestone.editMilestone(milestone);
        }
        catch (ParseException e)
        {
            System.out.print(e);
        }

        response.sendRedirect("/ListServlet");
//        System.out.println("in servlet, yes");
    }
}
