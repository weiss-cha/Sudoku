package sudoku;
import java.awt.*;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    // private variables
    GameBoard board = new GameBoard();
    MenuBar menuBar = new MenuBar(board);
    
    // Sounds instances
    public static Sounds backgroundMusic = new Sounds("Guitar-Gentle.wav");
    public static Sounds correctEffect = new Sounds("correct-sound.wav");
    public static Sounds wrongEffect = new Sounds("wrong-sound.wav");
    public static String currentBGM = "bgm1";
	
	// Constructor
	public SudokuMain() {

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(board, BorderLayout.CENTER);

		cp.add(menuBar, BorderLayout.NORTH);

		board.init(2);
		backgroundMusic.loop();
		
		pack(); // Pack the UI components, instead of setSize()
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle window closing
		setTitle("Sudoku");
		setVisible(true);

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