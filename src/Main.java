import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        ActDB actDB = ActDB.getSample();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
//            System.out.println("\nКоманды добавления(add) необходимо вводить с параемтрами указанными через пробел";
            System.out.println("\n\t*Шаблоны команд*" +
                    "\naddUsers ProjectID UserName" +
                    "\naddProject ProjectName" +
                    "\naddIssue UserID IssueName");

            System.out.println("\nВведите одну из команд - (addUser | addProject | addIssue | getProjects | getUsers | getIssues | exit): ");

            String[] params = bufferedReader.readLine().trim().split(" ");
            switch (params[0]){
                case "addUser":
                    actDB.addUser(new User(0, Integer.valueOf(params[1]), params[2]));
                    break;
                case "getUsers":
                    System.out.println("\t \u001B[33m -Users- \u001B[0m");
                    List<User> users = actDB.getAllUsers();
                    for (User user : users) {
                        System.out.println(user.toString());
                    }
                    break;
                case "addProject":
                    actDB.addProject(new Project(0, params[1]));
                    break;
                case "getProjects":
                    System.out.println("\t \u001B[33m -Projects- \u001B[0m");
                    List<Project> projects = actDB.getAllProject();
                    for (Project project : projects) {
                        System.out.println(project.toString());
                    }
                    break;
                case "addIssue":
                    actDB.addIssue(new Issue(0, Integer.valueOf(params[1]), params[2]));
                    break;
                case "getIssues":
                    System.out.println("\t \u001B[33m -Issues- \u001B[0m");
                    List<Issue> issues = actDB.getAllIssues();
                    for (Issue issue : issues) {
                        System.out.println(issue.toString());
                    }
                    break;
                case "exit":
                    System.out.println("Good Bye");
                    return;
                default:
                    System.out.println("Неверная команда");
            }
        }
//        try {
//            actDB.addProject(new Project(0, "SPAM"));
//            actDB.addUser(new User(0, 1, "Ulia"));
//            actDB.addIssue(new Issue(0, 2, "Make a space pen"));
//
//            List<Project> projects= actDB.getAllProject();
//            for (Project project : projects) {
//                System.out.println(project.toString());
//            }
//
//            List<User> users = actDB.getAllUsers();
//            for (User user : users) {
//                System.out.println(user.toString());
//            }
//
//            List<Issue> issues = actDB.getAllIssues();
//            for (Issue issue : issues) {
//                System.out.println(issue.toString());
//            }
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
    }
}