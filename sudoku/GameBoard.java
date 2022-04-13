package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class GameBoard extends JPanel {
    // Name-constants for the game board properties
    public static final int GRID_SIZE = 9;    // Size of the board
    public static final int SUBGRID_SIZE = 3; // Size of the sub-grid

    // Name-constants for UI sizes
    public static final int CELL_SIZE = 60;   // Cell width/height in pixels
    public static final int BOARD_WIDTH  = CELL_SIZE * GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * GRID_SIZE;
                                             // Board width/height in pixels

    // The game board composes of 9x9 "Customized" JTextFields,
    private Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];

    // Countdown Timer
    JLabel time = new JLabel();

    LocalDateTime startTime = LocalDateTime.now(); // Time when game starts
    Duration duration = Duration.ofMinutes(10); // Countdown Duration

    // Timer is fired every 500ms
    Timer timer =new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            LocalDateTime now = LocalDateTime.now(); // Time when Timer is fired
            Duration timeLeft = duration.minus(Duration.between(startTime, now)); // Time Left

            // Timer stops at zero
            if (timeLeft.isZero() || timeLeft.isNegative()) {
                timeLeft = Duration.ZERO;
            }

            // Format time
            time.setText(format(timeLeft));

            // Time's Up
            if (timeLeft == Duration.ZERO) {
                JOptionPane.showMessageDialog(null, "GAME OVER", "Time's Up", 2);
                timer.stop();
            }
        }
    });

    // Constructor
    public GameBoard() {
        super.setLayout(new GridLayout(GRID_SIZE + 1, GRID_SIZE));  // JPanel

        // Allocate the 2D array of Cell, and added into JPanel.
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);   // JPanel
            }
        }

        // [TODO 4] Every editable cell adds this common listener
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if (cells[row][col].isEditable()) {
                    cells[row][col].addKeyListener(new MyKeyListener());   // For all editable rows and cols
                }
            }
        }

        // Add Timer
        time.setHorizontalAlignment(JLabel.CENTER);  
        super.add(time);

        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    /**
    * Initialize the puzzle number, status, background/foreground color,
    *   of all the cells from puzzle[][] and isRevealed[][].
    * Call to start a new game.
    */
    public void init(int numToGuess) {
        // Get a new puzzle
        Puzzle.getInstance().newPuzzle(numToGuess);

        // Based on the puzzle, initialize all the cells.
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                cells[row][col].init(Puzzle.getInstance().numbers[row][col], Puzzle.getInstance().isShown[row][col]);
            }
        }
        
        // Reset Timer
        startTime = LocalDateTime.now();
        timer.start();
    }

    // Reset current puzzle (ie. clear all input)
    public void reset() {
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                cells[row][col].init(Puzzle.getInstance().numbers[row][col], Puzzle.getInstance().isShown[row][col]);
            }
        }

        // Reset Timer
        startTime = LocalDateTime.now();
        timer.start();
    }

    /**
    * Return true if the puzzle is solved
    * i.e., none of the cell have status of NO_GUESS or WRONG_GUESS
    */
    public boolean isSolved() {
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                if (cells[row][col].status == CellStatus.NO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
                    return false;
                }
            }
        }
        return true;
    }
  
    // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
    //  Cells (JTextFields)
    // Define Listener Inner Class
    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Get a reference of the JTextField that triggers this key event
            Cell sourceCell = (Cell)e.getSource();
            // Input validation, reject non-numbers
            if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            	e.consume();
            } else if (sourceCell.getText().length() > 0) { //dodge first time input
            	sourceCell.setText("");
            } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            	sourceCell.setText(""); //set to empty, back space has a value
            	sourceCell.status = CellStatus.WRONG_GUESS;
            	sourceCell.paint(); //repaint the colour to red when the bg is alr green
            	return;
            }
        }
        
        @Override public void keyPressed(KeyEvent e) { }
		@Override
		public void keyReleased(KeyEvent e) {
			// Get a reference of the JTextField again
			Cell sourceCell = (Cell) e.getSource();
			// Input validation
			if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
				// Do nothing, already handled on keyTyped
			} else {
				// Retrieve the int entered
				int numberIn = Integer.parseInt(Character.toString(e.getKeyChar()));

                /*
                * [TODO 5]
                * Check the numberIn against sourceCell.number.
                * Update the cell status sourceCell.status,
                * and re-paint the cell via sourceCell.paint().
                */
				if (numberIn == sourceCell.number) {
					SudokuMain.correctEffect.play();
					sourceCell.status = CellStatus.CORRECT_GUESS;
				} else {
					SudokuMain.wrongEffect.play();
					sourceCell.status = CellStatus.WRONG_GUESS;
				}
				sourceCell.paint();
               
                /*
                * [TODO 6][Later] Check if the player has solved the puzzle after this move,
                *   by call isSolved(). Put up a congratulation JOptionPane, if so.
                */
				if (isSolved()) { // Check for puzzle solve
					JOptionPane.showMessageDialog(null, "You won the game!", "Congratulations", 1);
				}
			}
		}
	}

    // Format Time
    protected String format(Duration duration) {
        long mins = duration.toMinutes();
        long seconds = duration.minusMinutes(mins).toMillis() / 1000;
        return String.format("%dm %ds", mins, seconds);
    }
}