package service;

import models.Player;
import models.Board;
import java.util.ArrayList;

public class Game {
    Player p1;
    Player p2;
    Player currPlayer;
    Board board;

    public Game(Player p1, Player p2, int size){
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board(size);
    }
    public void start(ArrayList<Integer> list){
        currPlayer = p1;
        board.printBoard();

        while(!list.isEmpty()){
            int row = list.get(0);
            list.remove(0);
            int col = list.get(0);
            list.remove(0);


            System.out.println(currPlayer.getName()+" played at "+ row+" , "+col);

            if(!board.isValidCell(row, col)){
                System.out.println("Invalid Input, hence "+currPlayer.getName()+" will play again");
                continue;
            }
            board.addSymbols(row, col, currPlayer.getSymbol());
            if(board.checkWin(currPlayer.getSymbol())){
                System.out.println(currPlayer.getName() + " has won the game.");
                break;
            }
            board.printBoard();
            currPlayer = (currPlayer == p1) ? p2 : p1;

            if(board.isOver()){
                System.out.println("Game is over");
            }
        }
    }
}
