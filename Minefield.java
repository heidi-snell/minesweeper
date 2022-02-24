import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Minefield {
    int numMines;
    int size;
    String[][] minefield;
    Set<String> dug;

    public Minefield(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.minefield = newMinefield();
        this.assignValues();
    }

    public String[][] newMinefield() {
        Set<String> dug = new HashSet<String>();
        this.dug = dug;
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
        tallying: for (int r = Math.max(0, row - 1); r <= Math.min(this.size - 1, row + 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(this.size - 1, col + 1); c++) {
                if (r == row && c == col) {
                    continue tallying;
                } else if (this.minefield[r][c] == "X") {
                    numNeighborMines++;
                }
            }
        }
        return String.valueOf(numNeighborMines);
    }

    public boolean dig(int row, int col) {
        this.dug.add(row + "," + col);
        // return False = BOMB! game over
        if (this.minefield[row][col] == "X") {
            return false;
        } else if (this.minefield[row][col] != "0") {
            return true;
        } else {
            for (int r = Math.max(0, row - 1); r <= Math.min(this.size - 1, row + 1); r++) {
                for (int c = Math.max(0, col - 1); c <= Math.min(this.size - 1, col + 1); c++) {
                    this.dig(r, c);
                }
            }
            return true;
        }
    }

    public void printNakedBoard() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(Arrays.toString(this.minefield[i]));
        }
    }

    public void print() {
        String[][] visibleBoard = new String[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.dug.contains(row + "," + col) == true) {
                    visibleBoard[row][col] = this.minefield[row][col];
                } else {
                    visibleBoard[row][col] = "-";
                }
            }
        }
        for (int i = 0; i < visibleBoard.length; i++) {
            System.out.println(Arrays.toString(visibleBoard[i]));
        }
    }
}
