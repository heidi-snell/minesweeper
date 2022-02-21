import java.util.*;

public class Main {

    public static void main(String[] args) {

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired minefield size: ");
        int size = input.nextInt();
        System.out.println("Enter desired number of mines: ");
        int numMines = input.nextInt();
        input.close();

        // make new minefield
        Minefield minefield = new Minefield(size, numMines);

        // keep digging until win or hit a bomb
        while (minefield.dug.size() < (Math.pow(size, 2) - numMines)) {
            Scanner digScanner = new Scanner(System.in);
            System.out.println("Next place to dig? Input as row, col: ");
            String userInputString = digScanner.nextLine();
            digScanner.close();

            int[] userInput = Arrays.stream(userInputString.split(",")).mapToInt(Integer::parseInt).toArray();

            System.out.println(userInput);
        }
    }
}