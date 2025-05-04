package Entities;

public class Dice {
    int faces =6;
    int diceFace;

    public int roll() {
        return (int)(Math.random()*6+1);
    }
}
