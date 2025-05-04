package Service;

import Entities.*;

public class Game {
    Player p1;
    Player p2;
    Player currPlayer;
    Board board;

    public Game(Player p1, Player p2, Board board, int size) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board(size);
    }
    boolean start(int row, int col){
        board.printBoard();
        System.out.println(currPlayer.getName() + " is playing ");

        boolean leagalMove = board.makeMove(row,col,currPlayer.getSymbol());

        if(!leagalMove){
            System.out.println("Invalid Move");
        }
        board.printBoard();


    }
}
