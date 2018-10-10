public class Project {

    public int id;
    public String name;

    public Project(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Name %s", this.id, this.name);
    }


}
