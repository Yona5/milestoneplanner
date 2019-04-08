package com.milestoneplanner.db;

import com.milestoneplanner.model.Milestone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class H2Milestone implements AutoCloseable{
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(H2Milestone.class);

    public static final String MEMORY = "jdbc:h2:mem:shop";
    public static final String FILE = "jdbc:h2:~/shop";

    private Connection connection;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
        return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
    }

    public H2Milestone() {
        this(MEMORY);
    }

    public H2Milestone(String db) {
        try {
            connection = getConnection(db);
            loadResource("/milestone.sql");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMilestone(Milestone milestone) {
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestone (msName, description, dueDate, completionDate) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)) {
            ps.setString(1, milestone.getName()); //come back to this
            ps.setString(2, milestone.getDescription());
            ps.setDate(3, java.sql.Date.valueOf("2013-09-04"));
            ps.setDate(4, java.sql.Date.valueOf("2013-09-04"));
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Milestone> findMilestones() {
        final String LIST_MILESTONES_QUERY = "SELECT msName  FROM milestone";
        List<Milestone> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.add(new Milestone(rs.getString(1), rs.getString(1), new Date(), new Date()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    private void loadResource(String name) {
        try {
            String cmd = new Scanner(getClass().getResource(name).openStream()).useDelimiter("\\Z").next();
            PreparedStatement ps = connection.prepareStatement(cmd);
            ps.execute();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
