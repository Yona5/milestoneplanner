package com.milestoneplanner.servlet;

import com.milestoneplanner.db.H2Milestone;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static final int PORT = 9000;

    private final H2Milestone h2Milestone;

    public Runner() {
        h2Milestone = new H2Milestone();
    }

    public void start() throws Exception {
        Server server = new Server(PORT);
        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setInitParameter("org.eclipse.jetty.servlet.Default." + "resourceBase", "src/main/resources/webapp");

        handler.addServlet(new ServletHolder(new MilestoneServlet(h2Milestone)), "/index.html");
        handler.addServlet(new ServletHolder(new MilestoneServlet(h2Milestone)), "/add");

        DefaultServlet ds = new DefaultServlet();
        handler.addServlet(new ServletHolder(ds), "/");

        server.start();
        LOG.info("Server started, will run until terminated");
        System.out.println("Server started, will run until terminated");
        server.join();
    }

    public static void main(String[] args) {
        try {
            LOG.info("starting MilestoneApp");
            Runner runner = new Runner();
            runner.start();
        } catch (Exception e) {
            LOG.error("Unexpected error running MilestoneApp: " + e.getMessage());
            e.printStackTrace();
        }
    }

    }
}
