import java.util.*;
import javafx.util.Pair;

public class Minefield {
    int numMines;
    int size;
    Set<Pair> uncovered = ;

    public Minefield(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.uncovered = Minefield.emptySet();
    }

    static void placeBombs() {

    }

    static void display() {

        System.out.println();

        String xAxisLabel = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

        System.out.println(xAxisLabel);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 26; j++) {

                // System.out.println(this.cell[i][j]));

            }

        }
        System.out.println(xAxisLabel);

    }

}
