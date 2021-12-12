import java.util.*;
public class Board {
    private int no_of_players;
    private Map<String,Integer> positions;
    private Queue<Player> players;
    private Map<Integer,Snakeandladder> snakes;
    private Map<Integer,Snakeandladder> ladders;
    private Dices dice;
    private int boardsize = 100;
    Board(int no_of_players, Map<String,Integer>positions, Queue<Player> players, Map<Integer,Snakeandladder> snakes, Map<Integer,Snakeandladder> ladders,Dices dice){
        this.dice = dice;
        this.no_of_players = no_of_players;
        this.positions = positions;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
    }
    public void startGame(){
        Scanner in = new Scanner(System.in);
        System.out.println(" Game is about to start--");
        //Iterator<Player> it = players.iterator();
        while(players.size()>1){
            Player p = players.poll();
            String name = p.getName();
            int flag=0;
            System.out.println(name+" Type any key to roll the dice");
            String start = in.nextLine();
            int number = dice.startRoll();
            System.out.println(name+" got dice_number - "+number);

            if(positions.get(name)+number>100){
                System.out.println("   The position of "+name+" - "+(positions.get(name)));
                positions.put(name,positions.get(name));
            }
            else if(snakes.containsKey((positions.get(name)+number))){
                int val = snakes.get((positions.get(name)+number)).getEndingIndex();
                System.out.println("--- snake is bitten ---");
                System.out.println("   The position of "+name+" - "+val);
                positions.put(name,val);
            }
            else if(ladders.containsKey((positions.get(name)+number))){
                int val = ladders.get((positions.get(name)+number)).getEndingIndex();
                System.out.println("--- Got ladder ---");
                System.out.println("   The position of "+name+" - "+val);
                positions.put(name,val);
            }
            else{
                if((positions.get(name)+number) == 100){
                    System.out.println("The "+(no_of_players-players.size())+" winner is "+name);
                    flag=1;
                }
                System.out.println("   The position of "+name+" - "+(positions.get(name)+number));
                positions.put(name,positions.get(name)+number);
            }
            if(flag!=1){
                players.add(p);
            }
        }
        System.out.println("Game is over!");
    }
}
