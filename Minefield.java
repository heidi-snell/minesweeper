import java.util.Random;

public class Minefield {
    int numMines;

    Minefield(int numMines) {
        this.numMines = numMines;
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
