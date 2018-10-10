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
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
