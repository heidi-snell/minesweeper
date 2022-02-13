import java.util.*;

public class Minefield {
    int numMines;
    int size;

    public Minefield(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
    }

    public void newMinefield() {
        String[][] minefield = new String[this.size][this.size];
    }

}
