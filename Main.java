import java.util.*;

public class Main {

    public static void main(String[] args) {

        // get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired minefield size: ");
        int size = scanner.nextInt();
        System.out.println("Enter desired number of mines: ");
        int numMines = scanner.nextInt();

        // make new minefield
        Minefield minefield = new Minefield(size, numMines);

        // keep digging until win or hit a bomb
        while (minefield.dug.size() < (Math.pow(size, 2) - numMines)) {
            scanner.nextLine();
            System.out.println("Where do you want to dig next? Input as row, col: ");
            String userInputString = scanner.nextLine();

            String[] splitArray = userInputString.split(",");
            int row = Integer.parseInt(splitArray[0]);
            int col = Integer.parseInt(splitArray[1]);

            minefield.dig(row, col);

            minefield.print();
        }
        scanner.close();

    }
}