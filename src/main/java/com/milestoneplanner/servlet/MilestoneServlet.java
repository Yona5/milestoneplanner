package com.milestoneplanner.servlet;

import lombok.Data;
import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;
import com.milestoneplanner.util.mustache.MustacheRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class MilestoneServlet extends HttpServlet {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(MilestoneServlet.class);

    private final H2Milestone h2Milestone;
    public MilestoneServlet(H2Milestone h2Milestone) {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        this.h2Milestone = h2Milestone;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();


            switch (action) {
                case "/add":
                    addMilestone(request, response);
                    break;
                case "/delete":
                    removeMilestone(request, response);
                    break;
                case "/update":
                    updateMilestone(request, response);
                    break;
                default:
                    listMilestones(request, response);
                    break;
            }

    }

    private void listMilestones(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Milestone> listMilestone = h2Milestone.findMilestones();
        request.setAttribute("listMilestones", listMilestone);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Milestones.jsp");
        dispatcher.forward(request, response);
    }



}