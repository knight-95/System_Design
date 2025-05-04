package Services;

import java.util.HashMap;

public class Board {
    int size;
    HashMap<Integer,Integer> snake;
    HashMap<Integer,Integer> ladder;

    public Board(int size, HashMap<Integer, Integer> snake, HashMap<Integer, Integer> ladder) {
        this.size = size;
        this.snake = snake;
        this.ladder = ladder;
    }

    /**
     * Given a cell, this method recursively returns the final cell
     * after applying all snakes and ladders
     */
    public int getNextPosition(int currentPosition) {
        int newPosition = currentPosition;

        while (true) {
            if (snake.containsKey(newPosition)) {
                System.out.println("Oops! Bitten by snake at " + newPosition);
                newPosition = snake.get(newPosition);
                System.out.print(" to "+newPosition);
                System.out.println();
            } else if (ladder.containsKey(newPosition)) {
                System.out.println("Yay! Climbed ladder from " + newPosition);
                newPosition = ladder.get(newPosition);
                System.out.print(" to "+newPosition);
                System.out.println();
            } else {
                break;
            }
        }

        return newPosition;
    }

    public boolean isWinningPosition(int position) {
        return position == size;
    }
}
