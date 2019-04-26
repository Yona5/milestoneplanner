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


@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
    private H2Milestone h2Milestone = new H2Milestone();

    public String encode(String str) {
        StringBuilder sb = new StringBuilder();
        char tmp = str.charAt(0);
        int count = 1;
        for (int idx = 1; idx < str.length(); idx++) {
            char curr = str.charAt(idx);
            if (curr == tmp) {
                count++;
            } else {
                sb.append(tmp).append(count);
                count = 1;
            }
            tmp = curr;
        }
        sb.append(tmp).append(count);
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sharedLink = (String)request.getSession().getAttribute("email");

        String str = encode(sharedLink);

        request.setAttribute("sharedLink",str);
        request.getRequestDispatcher("project.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
