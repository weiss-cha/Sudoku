package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar {

	// Constructor    
    public MenuBar(GameBoard board) {
        super();

        JMenu file = new JMenu("File");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");
        JMenu volumeMenu = new JMenu("Volume");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exitGame = new JMenuItem("Exit");
        
        JMenuItem volumeMute = new JMenuItem("Mute/Unmute");
        JMenuItem volumeLow = new JMenuItem("Low");
        JMenuItem volumeMedium = new JMenuItem("Medium");
        JMenuItem volumeHigh = new JMenuItem("High");
        
        // Sounds instances
        //Sounds backgroundMusic = new Sounds("Guitar-Gentle.wav");
        //Sounds correctEffect = new Sounds("correct-sound.wav");
        //Sounds wrongEffect = new Sounds("wrong-sound.wav");
        
        // Add MenuItem to Menu
        file.add(newGame);
        file.add(resetGame);
        file.add(exitGame);
        
        // Add volume submenus settings
        volumeMenu.add(volumeMute); 
        volumeMenu.add(volumeLow); 
        volumeMenu.add(volumeMedium); 
        volumeMenu.add(volumeHigh);
        // Add Volume into Options
        options.add(volumeMenu);
        
        
        // Add Menu to MenuBar
        this.add(file);
        this.add(options);
        this.add(help);

        // Add Listener to MenuItem

        // New Game
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Choose Difficulty
                DifficultyDialog diff = new DifficultyDialog(board);

                // Display dialog to the center of GameBoard
                diff.setLocationRelativeTo(board);
            }
        });

        // Reset Game
        resetGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Display OptionPane to confirm action
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the game?", 
                "Reset Game", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(result == JOptionPane.YES_OPTION) {
                    board.reset();
                }
            }
        });

        // Exit
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Display OptionPane to confirm action
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", 
                "Exit Game", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        // Volume
        volumeMute.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.volumeMute();
        		SudokuMain.correctEffect.volumeMute();
        		SudokuMain.wrongEffect.volumeMute();
        	}
        });
        
        volumeLow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)-25.0);
        		SudokuMain.correctEffect.setVolume((float)-25.0);
        		SudokuMain.wrongEffect.setVolume((float)-25.0);
        	}
        });
        
        volumeMedium.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)-10.0);
        		SudokuMain.correctEffect.setVolume((float)-10.0);
        		SudokuMain.wrongEffect.setVolume((float)-10.0);
        	}
        });
        
        volumeHigh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)6.0);
        		SudokuMain.correctEffect.setVolume((float)6.0);
        		SudokuMain.wrongEffect.setVolume((float)6.0);
        	}
        });
    }


    
}
