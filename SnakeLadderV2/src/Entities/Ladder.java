package Entities;

public class Ladder {
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
