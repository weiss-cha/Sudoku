package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent; // For JSlider
import javax.swing.event.ChangeListener; // For JSlider

public class MenuBar extends JMenuBar {

	// Constructor    
    public MenuBar(GameBoard board) {
        super();

        JMenu file = new JMenu("File");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");
        JMenu volumeMenu = new JMenu("Volume");
        JMenu changeBGM = new JMenu("Change Music");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exitGame = new JMenuItem("Exit");
        
        JMenuItem volumeMute = new JMenuItem("Mute/Unmute");
        JMenuItem volumeLow = new JMenuItem("Low");
        JMenuItem volumeMedium = new JMenuItem("Medium");
        JMenuItem volumeMax = new JMenuItem("High");
        
        JMenuItem bgm1 = new JMenuItem("Music 1");
        JMenuItem bgm2 = new JMenuItem("Music 2");
        JMenuItem bgm3 = new JMenuItem("Music 3");
        
        // Add MenuItem to Menu
        file.add(newGame);
        file.add(resetGame);
        file.add(exitGame);
        
        // Add volume submenus settings
        volumeMenu.add(volumeMute); 
        volumeMenu.add(volumeLow); 
        volumeMenu.add(volumeMedium); 
        volumeMenu.add(volumeMax);
        // Add Volume into Options
        options.add(volumeMenu);
        
        // Add change music submenus
        changeBGM.add(bgm1);
        changeBGM.add(bgm2);
        changeBGM.add(bgm3);
        //Add Change Music into Options
        options.add(changeBGM);
        
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
        
        // Volume, adjust volume
        JSlider sldrVolCtrl; // Volume control using JSlider
    	sldrVolCtrl = new JSlider(-40, 6); //(min, max)
        volumeMenu.add(sldrVolCtrl); // Add the slider into Volume menu
        sldrVolCtrl.addChangeListener(new ChangeListener() {
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		if(sldrVolCtrl.getValue() == -40) {
        			SudokuMain.backgroundMusic.setVolume((float)-80);
        			SudokuMain.correctEffect.setVolume((float)-80.0);
        			SudokuMain.wrongEffect.setVolume((float)-80.0);
        			Sounds.isMute = true;
        		} else {
        			SudokuMain.backgroundMusic.setVolume((float)sldrVolCtrl.getValue());
        			SudokuMain.correctEffect.setVolume((float)sldrVolCtrl.getValue());
        			SudokuMain.wrongEffect.setVolume((float)sldrVolCtrl.getValue());
        			Sounds.isMute = false;
        		}
        	}
        });
        volumeMute.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.volumeMute();
        		SudokuMain.correctEffect.volumeMute();
        		SudokuMain.wrongEffect.volumeMute();
        		sldrVolCtrl.setValue(sldrVolCtrl.getMinimum());
        	}
        });
        
        volumeLow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)-25.0);
        		SudokuMain.correctEffect.setVolume((float)-25.0);
        		SudokuMain.wrongEffect.setVolume((float)-25.0);
        		sldrVolCtrl.setValue(-25);
        	}
        });
        
        volumeMedium.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)-10.0);
        		SudokuMain.correctEffect.setVolume((float)-10.0);
        		SudokuMain.wrongEffect.setVolume((float)-10.0);
        		sldrVolCtrl.setValue(-10);
        	}
        });
        
        volumeMax.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SudokuMain.backgroundMusic.setVolume((float)6.0);
        		SudokuMain.correctEffect.setVolume((float)6.0);
        		SudokuMain.wrongEffect.setVolume((float)6.0);
        		sldrVolCtrl.setValue(sldrVolCtrl.getMaximum());
        	}
        });
        
        // Change music
        bgm1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm1") {
        			SudokuMain.backgroundMusic.switchSong("Guitar-Gentle.wav");
        			SudokuMain.backgroundMusic.setVolume(sldrVolCtrl.getValue());
        			SudokuMain.currentBGM = "bgm1";
        		}
        	}
        });
        
        bgm2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm2") {
        			SudokuMain.backgroundMusic.switchSong("Neverland.wav");
        			SudokuMain.backgroundMusic.setVolume(sldrVolCtrl.getValue());
        			SudokuMain.currentBGM = "bgm2";
        		}
        	}
        });
        
        bgm3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm3") {
        			SudokuMain.backgroundMusic.switchSong("The-Beginning-w-Caturday.wav");
        			SudokuMain.backgroundMusic.setVolume(sldrVolCtrl.getValue());
        			SudokuMain.currentBGM = "bgm3";
        		}
        	}
        });
    }
}
