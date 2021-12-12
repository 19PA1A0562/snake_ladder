public class Snakeandladder {
    private int startingpoint;
    private int endingpoint;
    Snakeandladder(int startingpoint,int endingpoint){
        this.startingpoint = startingpoint;
        this.endingpoint = endingpoint;
    }
    public int getStartIndex(){
        return startingpoint;
    }
    public int getEndingIndex(){
        return endingpoint;
    }
    public String toString(){
        return startingpoint+" "+endingpoint;
    }
}
