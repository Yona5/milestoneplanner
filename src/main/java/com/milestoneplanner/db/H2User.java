package com.milestoneplanner.db;

import com.milestoneplanner.model.Milestone;
import com.milestoneplanner.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class H2User implements AutoCloseable{
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(H2Milestone.class);

    public static final String MEMORY = "jdbc:h2:mem:msApp";
    public static final String FILE = "jdbc:h2:~/msApp";

    private Connection connection;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
        return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
    }

    public H2User() {
        this(MEMORY);
    }

    public H2User(String db) {
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

    public void addUser(User user) {

        //implement the code that checks if the email address already exists in the db

        final String ADD_USER_QUERY = "INSERT INTO user (fName, lName, email, password) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_USER_QUERY)) {
            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getUser(User u) {
        String email = null;
        String password = null;
        final String ADD_USER_QUERY = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(ADD_USER_QUERY)) {
            ps.setString(1, u.getEmail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(u.getPassword().equals(password)){
            return true;
        }
        return false;
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
