package Entities;

public class Player {
    String name;
    int pos;

    public Player(String name, int id) {
        this.name = name;
        this.pos = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int id) {
        this.pos = id;
    }
}
