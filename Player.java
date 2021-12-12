public class Player{
    private String name;
    private int id;
    Player(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return name+" "+id;
    }
}
