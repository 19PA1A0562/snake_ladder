import java.util.*;
public class Board {
    private int no_of_players;
    private Queue<Player> players;
    private Map<Integer,Snakeandladder> snakes;
    private Map<Integer,Snakeandladder> ladders;
    private Dices dice;
    private int boardsize = 100;
    Board(int no_of_players, Queue<Player> players, Map<Integer,Snakeandladder> snakes, Map<Integer,Snakeandladder> ladders,Dices dice){
        this.dice = dice;
        this.no_of_players = no_of_players;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
    }
    public int player_moving(int position,String name,Player p,int flag){
        if(position>100){
            System.out.println("   The position of "+name+" - "+(p.getPosition()));
        }
        else if(snakes.containsKey(position)){
            int val = snakes.get(position).getEndingIndex();
            System.out.println("--- snake is bitten ---");
            System.out.println("   The position of "+name+" - "+val);
            p.setPosition(val);
        }
        else if(ladders.containsKey(position)){
            int val = ladders.get(position).getEndingIndex();
            System.out.println("--- Got ladder ---");
            System.out.println("   The position of "+name+" - "+val);
            p.setPosition(val);
        }
        else{
            if((position == 100)){
                System.out.println("The "+(no_of_players-players.size())+" winner is "+name);
                flag=1;
            }
            System.out.println("   The position of "+name+" - "+(position));
            p.setPosition(position);
        }
        return flag;
    }
    public void startGame(){
        Scanner in = new Scanner(System.in);
        System.out.println(" Game is about to start--");
        while(players.size()>1){
            Player p = players.poll();
            String name = p.getName();
            int flag=0;
            System.out.println(name+" Type any key to roll the dice");
            String start = in.nextLine();
            int number = dice.startRoll();
            System.out.println(name+" got dice_number - "+number);
            int position = p.getPosition()+number;
            int six_count=0;
            if(number!=6){
                flag = player_moving(position, name, p, flag);
            }
            else{
                do{
                    six_count++;
                    if(six_count==3){
                        System.out.println("  Your score is 0!!!");
                        flag = player_moving(0, name, p, flag);
                        break;
                    }
                    else{
                        flag = player_moving(position, name, p, flag);
                        System.out.println("  You got an extra change, Type any key to roll the dice");
                        start = in.nextLine();
                        number = dice.startRoll();
                        System.out.println(name+" got dice_number - "+number);
                        position = p.getPosition()+number;
                    }
                }
                while(number==6);
                if(six_count!=3){
                     flag = player_moving(position, name, p, flag);
                }
            }
            if(flag!=1){
                players.add(p);
            }
        }
        System.out.println(players.poll().getName()+" lose the game");
        System.out.println("Game is over!");
    }
}
