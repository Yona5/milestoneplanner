package com.milestoneplanner.servlet;

import lombok.Data;
import com.milestoneplanner.db.H2Milestone;
import com.milestoneplanner.model.Milestone;
import com.milestoneplanner.util.mustache.MustacheRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Date;
import java.text.ParseException;

public class MilestoneServlet extends HttpServlet{
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(MilestoneServlet.class);

    private final H2Milestone h2Milestone;
    private final MustacheRender mustache;
    public MilestoneServlet(H2Milestone h2Milestone) {
        mustache = new MustacheRender();
        this.h2Milestone = h2Milestone;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Milestone> milestones = h2Milestone.findMilestones();
        String html = mustache.render("index.mustache", new Result(milestones.size()));
        response.setContentType("text/html");
        response.setStatus(200);
        response.getOutputStream().write(html.getBytes(Charset.forName("utf-8")));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String milestone_name = request.getParameter("milestone_name");
        String dd_str = request.getParameter("dd");
        String cd_str = request.getParameter("cd");
        System.out.println(dd_str);
        try{
            Date dd = new SimpleDateFormat("dd/MM/yyyy").parse(dd_str);
            Date cd =new SimpleDateFormat("dd/MM/yyyy").parse(cd_str);
            Milestone milestone = new Milestone(milestone_name, milestone_name, dd, cd);
            h2Milestone.addMilestone(milestone);
        }catch(ParseException ex){
            System.out.println(ex);
        }


        response.sendRedirect("/index.html");
    }

    @Data
    class Result {
        private int count;
        Result(int count) { this.count = count; }
    }
}
