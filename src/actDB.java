import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;


public class actDB {
    private static final String bdPath = "jdbc:sqlite:D:/Documents/Test.s3db";

    private static actDB sample = null;

    public static synchronized actDB getSample() throws SQLException {
        if(sample == null)
            sample = new actDB();
        return sample;
    }

    private Connection connection;

    private actDB() throws SQLException {
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
        }


    }
}
