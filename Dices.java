public class Dices {
    private  int no_of_dices;
    Dices(int no_of_dices){
        this.no_of_dices=no_of_dices;
    }
    public int startRoll(){
        return (int)(Math.random() * (6*no_of_dices - no_of_dices+1)+ no_of_dices);
    }
}
