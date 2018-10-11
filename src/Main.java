import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            ActDB actDB = ActDB.getSample();

            List<Project> projects= actDB.getAllProject();
            for (Project project : projects) {
                System.out.println(project.toString());
            }

            List<User> users = actDB.getAllUsers();
            for (User user : users) {
                System.out.println(user.toString());
            }

            List<Issue> issues = actDB.getAllIssues();
            for (Issue issue : issues) {
                System.out.println(issue.toString());
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
