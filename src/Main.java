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

            System.out.println("\nВведите одну из команд - (addUser | addProject | addIssue | getProjects | getUsers | getIssues | delProject |delUser | delIssue | exit): ");

            String[] params = bufferedReader.readLine().trim().split(" ");
            switch (params[0]){
                case "addUser":
                    actDB.addUser(new User(0, Integer.valueOf(params[1]), params[2]));
                    break;
                case "getUsers":
                    System.out.println("\t \u001B[33m -Users- \u001B[0m");
                    actDB.readList(actDB.getAllUsers());
                    break;
                case "addProject":
                    actDB.addProject(new Project(0, params[1]));
                    break;
                case "getProjects":
                    System.out.println("\t \u001B[33m -Projects- \u001B[0m");
                    actDB.readList(actDB.getAllProjects());
                    break;
                case "addIssue":
                    actDB.addIssue(new Issue(0, Integer.valueOf(params[1]), params[2]));
                    break;
                case "getIssues":
                    System.out.println("\t \u001B[33m -Issues- \u001B[0m");
                    actDB.readList(actDB.getAllIssues());
                    break;
                case "getIssue":
                    actDB.getIssue(params[1], params[2]);
                    break;
                case "delProject":
                    actDB.deleteProject(Integer.valueOf(params[1]));
                    actDB.readList(actDB.getAllProjects());
                    break;
                case "delUser":
                    actDB.deleteUser(Integer.valueOf(params[1]));
                    actDB.readList(actDB.getAllUsers());
                    break;
                case "delIssue":
                    actDB.deleteIssue(Integer.valueOf(params[1]));
                    actDB.readList(actDB.getAllIssues());
                    break;
                case "exit":
                    System.out.println("Good Bye");
                    return;
                default:
                    System.out.println("invalid command");
            }
        }
    }
}