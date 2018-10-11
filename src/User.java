public class User {

    public int id;
    public int pj_id;
    public String name;

    public User(int id, int pj_id, String name){
        this.id = id;
        this.pj_id = pj_id;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Project ID: %s | Name: %s", this.id, this.pj_id, this.name);
    }

}
