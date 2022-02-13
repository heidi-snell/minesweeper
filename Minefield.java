
// import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Minefield {
    int numMines;
    int size;
    String[][] minefield;

    public Minefield(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.minefield = newMinefield();
        this.assignValues();
    }

    public String[][] newMinefield() {
        String[][] minefield = new String[this.size][this.size];
        int minesPlated = 0;
        placingMines: while (minesPlated < this.numMines) {
            int row = ThreadLocalRandom.current().nextInt(this.size);
            int col = ThreadLocalRandom.current().nextInt(this.size);
            if (minefield[row][col] == "X") {
                continue placingMines;
            } else {
                minefield[row][col] = "X";
                minesPlated++;
            }
        }
        return minefield;
    }

    public void assignValues() {
        labeling: for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.minefield[row][col] == "X") {
                    continue labeling;
                } else {
                    this.minefield[row][col] = getNumNeighborMines(row, col);
                }
            }
        }
    }

    public String getNumNeighborMines(int row, int col) {
        int numNeighborMines = 0;
        tallying: for (int r = Math.max(0, row - 1); r <= Math.min(this.size, row + 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(this.size, col + 1); c++) {
                if (r == row && c == col) {
                    continue tallying;
                } else if (this.minefield[r][c] == "X") {
                    numNeighborMines++;
                }
            }
        }
        return String.valueOf(numNeighborMines);
    }

    public void dig(int row, int col) {

    }
}
