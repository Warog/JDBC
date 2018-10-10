import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;


public class ActDB {
    private static final String bdPath = "jdbc:sqlite:D:/Documents/Test.s3db";

    private static ActDB sample = null;

    public static synchronized ActDB getSample() throws SQLException {
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
}
