package sudoku;
import java.util.Random;
/**
 * The Sudoku number puzzle to be solved
 */
public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    int[][] numbers = new int[GameBoard.GRID_SIZE][GameBoard.GRID_SIZE];
    // The masks - to show or not
    boolean[][] isShown = new boolean[GameBoard.GRID_SIZE][GameBoard.GRID_SIZE];

    // Singleton
    private static Puzzle puzzle = new Puzzle();

    private Puzzle() {

    }

    public static Puzzle getInstance()
    {
        return puzzle;
    }

    // Generate a new puzzle given the number of cells to be guessed
    // Need to set the arrays numbers and isShown
    public void newPuzzle(int numToGuess) {

        int[][] hardcodedNumbers =
            {{5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}};

        // Random int between 1-8
        int randomInt = new Random().nextInt(8) + 1;

        // Copy from hardcoded number, then add random int
        for (int row = 0; row < GameBoard.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoard.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col] + randomInt;

                // Return to 1 after 9 (eg. 10 -> 1, 13 -> 4)
                if (numbers[row][col] > 9) {
                    numbers[row][col] = numbers[row][col] - 9;
                }
            }
        }

        // Default isShown with all true
        boolean[][] defaultIsShown =
            {{true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true}};

        // Copy from default isShown
        for (int row = 0; row < GameBoard.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoard.GRID_SIZE; ++col) {
                isShown[row][col] = defaultIsShown[row][col];
            }
        }

        // Randomly assign masks
        for (int i = 0; i < numToGuess; ++i) {
            int randomRow = new Random().nextInt(9);
            int randomCol = new Random().nextInt(9);
            isShown[randomRow][randomCol] = false;
        }
    }
}