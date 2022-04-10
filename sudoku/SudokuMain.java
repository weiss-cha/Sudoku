package sudoku;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
	// private variables
	GameBoard board = new GameBoard();
	JButton btnNewGame = new JButton("New Game");

	// Constructor
	public SudokuMain() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(board, BorderLayout.CENTER);

		// Add a button to the south to re-start the game
		// ......

		board.init();

		pack(); // Pack the UI components, instead of setSize()
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle window closing
		setTitle("Sudoku");
		setVisible(true);

		// Background Music
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource("Guitar-Gentle.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
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