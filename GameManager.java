import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class GameManager{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of players?");
        int no_of_players = in.nextInt();
        Queue<Player> players = new ArrayDeque<Player>();
        for(int i=0;i<no_of_players;i++){
            System.out.println("Enter the name of the player"+(i+1));
            String name = in.next();
            Player p = new Player(name,0);
            players.add(p);
        }
        Map<Integer,Snakeandladder> snakes = new HashMap<>();
        snakes.put(17,new Snakeandladder(17, 7));
        snakes.put(62,new Snakeandladder(62, 19));
        snakes.put(54,new Snakeandladder(54, 34));
        snakes.put(87,new Snakeandladder(87, 36));
        snakes.put(64,new Snakeandladder(64, 60));
        snakes.put(93,new Snakeandladder(93, 73));
        snakes.put(95,new Snakeandladder(95, 75));
        snakes.put(98,new Snakeandladder(98, 79));
        Map<Integer,Snakeandladder> ladders = new HashMap<>();
        ladders.put(4,new Snakeandladder(4, 14));
        ladders.put(9,new Snakeandladder(9, 31));
        ladders.put(28,new Snakeandladder(28, 84));
        ladders.put(21,new Snakeandladder(21, 42));
        ladders.put(51,new Snakeandladder(51, 67));
        ladders.put(72,new Snakeandladder(93, 91));
        ladders.put(80,new Snakeandladder(80, 99));
        System.out.println("Enter the no of dices?");
        int no_of_dices = in.nextInt();
        Dices dice = new Dices(no_of_dices);
        Board b = new Board(no_of_players,players,snakes,ladders,dice);
        b.startGame();
    }
}