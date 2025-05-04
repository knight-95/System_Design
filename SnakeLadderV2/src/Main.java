import Entities.Dice;
import Entities.Player;
import Services.Board;
import Services.Game;

import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Reading snakes;
        int s = sc.nextInt();
        HashMap<Integer,Integer> snakes = new HashMap<>();
        for(int i=0;i<s;i++){
           snakes.put(sc.nextInt(),sc.nextInt());
        }

        //Reading ladders
        int l = sc.nextInt();
        HashMap<Integer,Integer> ladder = new HashMap<>();
        for(int i=0;i<l;i++){
            ladder.put(sc.nextInt(),sc.nextInt());
        }

        // Read players
        int p = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < p; i++) {
            String name = sc.nextLine();
            players.add(new Player(name,0));
        }

        //Intitializing game components
        Dice dice = new Dice();
        Board board = new Board(100, snakes, ladder);
        Game game = new Game(board,players,dice);

        game.start();
    }
}