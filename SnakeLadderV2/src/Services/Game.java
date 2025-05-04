package Services;

import Entities.*;

import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;

    public Game(Board board, Queue<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void start(){
        while(true){
            Player current = players.poll();
            int diceFace = dice.roll();
            int currentPos = current.getPos();
            int newPos;
            if(diceFace==6) {
                int addDiceFace = dice.roll();
                newPos = currentPos + diceFace;
                if (addDiceFace == 6) {
                    int add2DiceFace = dice.roll();
                    if (add2DiceFace == 6) {
                        newPos = currentPos;
                    } else {
                        newPos = currentPos + 12 + add2DiceFace;
                    }
                } else {
                    newPos += addDiceFace;
                }
            }
            else{
                newPos = currentPos + diceFace;
            }


            System.out.println(" Player "+ current.getName()+ " rolled a "+ diceFace+" and moved from "+ currentPos +" to "+ newPos);

            if(newPos< 100){
                newPos = board.getNextPosition(newPos);
                current.setPos(newPos);
            }

            if(newPos == 100){
                System.out.println("Player "+ current.getName() + " has won the game.");
                break;
            }
            players.offer(current);
        }
    }
}
