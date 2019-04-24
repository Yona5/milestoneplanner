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
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class H2Milestone implements AutoCloseable{
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(H2Milestone.class);

    public static final String MEMORY = "jdbc:h2:mem:msApp";
    public static final String FILE = "jdbc:h2:~/msApp";

    private Connection connection;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
        return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
    }

//    public H2Milestone(String jdbcURL, String jdbcUsername, String jdbcPassword) {
//        this.jdbcURL = jdbcURL;
//        this.jdbcUsername = jdbcUsername;
//        this.jdbcPassword = jdbcPassword;
//    }

    public H2Milestone() {
        this(FILE);
    }

    public H2Milestone(String db) {
        try {
            connection = getConnection(db);
            loadResource("/msapp.sql");
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
            Date dd = milestone.getDueDate();
            Date cd = milestone.getCompletionDate();
//            System.out.println(dd + " " + cd);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dd_str = formatter.format(dd);
            String cd_str = formatter.format(cd);
//            System.out.println(dd_str + " " + cd_str);
            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(dd_str));
            ps.setDate(4, java.sql.Date.valueOf(cd_str));
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMilestone(Milestone milestone) {
        final String EDIT_MILESTONE_QUERY = "UPDATE milestone SET msName = ?, description = ?, " +
                "dueDate = ?, completionDate = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(EDIT_MILESTONE_QUERY)) {
            Date dd = milestone.getDueDate();
            Date cd = milestone.getCompletionDate();
//            System.out.println(dd + " " + cd);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dd_str = formatter.format(dd);
            String cd_str = formatter.format(cd);

            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(dd_str));
            ps.setDate(4, java.sql.Date.valueOf(cd_str));
            ps.setInt(5, milestone.getId()); // why set not get
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Milestone getMilestone(int id) {
        final String GET_MILESTONE_QUERY = "SELECT * FROM milestone WHERER id = ?";
        try (PreparedStatement ps = connection.prepareStatement(GET_MILESTONE_QUERY)) {
//            ps.setString(1, milestone.getName()); // come over here
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Milestone(id); //finish it tomorrow
    }

    public void removeMilestone(Milestone milestone) {
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestone WHERE WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)) {
            ps.setString(1, milestone.getDescription()); // come back to this
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Milestone> findMilestones() {
        final String LIST_MILESTONES_QUERY = "SELECT * FROM milestone";
        List<Milestone> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("msName");
                String desc = rs.getString("description");
                Date dd = rs.getDate("dueDate");
                Date cd = rs.getDate("completionDate");

                out.add(new Milestone(name, desc, dd, cd, id));
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
