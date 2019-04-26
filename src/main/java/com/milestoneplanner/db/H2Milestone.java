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

    //add milestone to the database
    public void addMilestone(Milestone milestone) {
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestone (msName, description, dueDate, completionDate, email) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)) {
            Date dd = milestone.getDueDate();
            Date cd = milestone.getCompletionDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dd_str = formatter.format(dd);
            String cd_str = formatter.format(cd);

            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(dd_str));
            ps.setDate(4, java.sql.Date.valueOf(cd_str));
            ps.setString(5, milestone.getEmail());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //edit the milestone
    public void editMilestone(Milestone milestone) {
        final String EDIT_MILESTONE_QUERY = "UPDATE milestone SET msName = ?, description = ?, " +
                "dueDate = ?, completionDate = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(EDIT_MILESTONE_QUERY)) {
            Date dd = milestone.getDueDate();
            Date cd = milestone.getCompletionDate();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dd_str = formatter.format(dd);
            String cd_str = formatter.format(cd);

            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(dd_str));
            ps.setDate(4, java.sql.Date.valueOf(cd_str));
            ps.setInt(5, milestone.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // return milestone from the database
    public Milestone getMilestone(int m_id) {
        Milestone milestone = null;
        final String GET_MILESTONE_QUERY = "SELECT * FROM milestone WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(GET_MILESTONE_QUERY)) {
            ps.setInt(1, m_id); // come over here
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("msName");
                String desc = rs.getString("description");
                Date dd = rs.getDate("dueDate");
                Date cd = rs.getDate("completionDate");
                milestone = new Milestone(name, desc, dd, cd, id);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return milestone;
    }

    // remove milestone from the database
    public void removeMilestone(Milestone milestone) {
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestone WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)) {
            ps.setInt(1, milestone.getId()); // come back to this
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //list milestonesa
    public List<Milestone> findMilestones(String email) {
        final String LIST_MILESTONES_QUERY = "SELECT * FROM milestone WHERE email = ? AND dueDate != completionDate";
        List<Milestone> listMilestone = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("msName");
                String desc = rs.getString("description");
                Date dd = rs.getDate("dueDate");
                Date cd = rs.getDate("completionDate");

                listMilestone.add(new Milestone(name, desc, dd, cd, id));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listMilestone;
    }

    private void loadResource(String name) {
        try {
            String cmd = new Scanner(getClass().getResource(name).openStream()).useDelimiter("\\Z").next();
            PreparedStatement ps = connection.prepareStatement(cmd);
            ps.execute();
            ps.close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
