package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    // private variables
    GameBoard board = new GameBoard();
    MenuBar menuBar = new MenuBar(board);

	// Constructor
	public SudokuMain() {

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(board, BorderLayout.CENTER);

    cp.add(menuBar, BorderLayout.NORTH);

		board.init(2);
		Sounds.init(); //Pre-load all of the sound files
		
		pack(); // Pack the UI components, instead of setSize()
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle window closing
		setTitle("Sudoku");
		setVisible(true);
		Sounds.BGM1.loop(); //Background Music
    
    // Display JFrame to the center of the screen
		setLocationRelativeTo(null);
	}
  


	/** The entry main() entry method */
	public static void main(String[] args) {
		// [TODO 1] Check Swing program template on how to run the constructor
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SudokuMain(); // Let the constructor do the job
			}
		});
	}
}