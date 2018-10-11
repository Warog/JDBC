import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;


public class ActDB {
    private static final String bdPath = "jdbc:sqlite:resources/Test.s3db";

    private static ActDB sample = null;

    public static ActDB getSample() throws SQLException {
        if(sample == null)
            sample = new ActDB();
        return sample;
    }

    private Connection connection;

    private ActDB() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(bdPath);
    }

    public List<Project> getAllProject() {
        try(Statement statement = this.connection.createStatement()) {
            List<Project> projects = new ArrayList<Project>();
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM Projects");
            while (resultSet.next()) {
                projects.add(new Project(resultSet.getInt("id"),
                                            resultSet.getString("Name")));
            }

            return projects;

            }catch(SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    public List<User> getAllUsers() {
        try(Statement statement = this.connection.createStatement()) {
            List<User> users = new ArrayList<User>();
            ResultSet resultSet = statement.executeQuery("SELECT id, Project_id, name FROM Users");
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                                            resultSet.getInt("Project_id"),
                                            resultSet.getString("Name")));
            }

            return users;

            }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<Issue> getAllIssues() {
        try(Statement statement = this.connection.createStatement()) {
            List<Issue> issues = new ArrayList<Issue>();
            ResultSet resultSet = statement.executeQuery("SELECT id, User_id, Issue FROM Issues");
            while (resultSet.next()) {
                issues.add(new Issue(resultSet.getInt("id"),
                                            resultSet.getInt("User_id"),
                                            resultSet.getString("Issue")));
            }

            return issues;

            }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
