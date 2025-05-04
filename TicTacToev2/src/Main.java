import models.*;
import service.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char symbol1, symbol2;
        Player player1, player2;

         symbol1 = sc.next().charAt(0);
         player1 = new Player(sc.next(), symbol1);
         sc.nextLine();

         symbol2 = sc.next().charAt(0);
         player2 = new Player(sc.next(), symbol2);
         sc.nextLine();

        ArrayList<Integer> position = new ArrayList<>();

         while(sc.hasNextLine()){
             String s = sc.nextLine().trim();
             if(s.toLowerCase().contains("exit")) break;

             String[] parts = s.split("\\s+");
             int row = Integer.parseInt(parts[0]);
             row--;
             int col = Integer.parseInt(parts[1]);
             col--;
             position.add(row);
             position.add(col);
         }

        Game game = new Game(player1,player2,3);
        game.start(position);
    }
}

