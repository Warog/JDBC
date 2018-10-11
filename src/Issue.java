public class Issue {

    public int id;
    public int user_id;
    public String issue;

    public Issue(int id, int user_id, String issue){
        this.id = id;
        this.user_id = user_id;
        this.issue = issue;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Project ID: %s | Name: %s", this.id, this.user_id, this.issue);
    }

}
