import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Minefield {
    int numMines;
    int size;

    public Minefield(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
    }

    public void newMinefield() {
        String[][] minefield = new String[this.size][this.size];
        int minesPlated = 0;
        placingMines: while (minesPlated < this.numMines) {
            int row = ThreadLocalRandom.current().nextInt(this.size);
            int col = ThreadLocalRandom.current().nextInt(this.size);
            if (minefield[row][col] == "X") {
                continue placingMines;
            } else {
                minefield[row][col] = "X";
            }
        }
    }

}
