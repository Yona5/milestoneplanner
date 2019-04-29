package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListSharedServlet")
public class ListSharedServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();


    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        try{
            for (int i = 0; i < str.length(); i += 2) {
                int count = Integer.valueOf("" + str.charAt(i + 1));
                for (int j = 0; j < count; j++) {
                    sb.append(str.charAt(i));
                }
            }
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sharedEmail = request.getParameter("sharedLink");

        String str = decode(sharedEmail);

        List<Milestone> sharedMilestone = h2Milestone.findMilestones(str);

        request.setAttribute("sharedMilestone",sharedMilestone);
        request.getRequestDispatcher("shared.jsp").forward(request,response);
        response.setContentType("text/html");
        response.setStatus(200);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
