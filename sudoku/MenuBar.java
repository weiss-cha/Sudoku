package sudoku;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar {

	// Constructor    
    public MenuBar(GameBoard board) {
        super();

        JMenu fileMenu = new JMenu("File");
        JMenu optionsMenu = new JMenu("Options");
        JMenu volumeMenu = new JMenu("Volume");
        JMenu bgmMenu = new JMenu("Change Music");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exitGame = new JMenuItem("Exit");
        
        JMenuItem volumeMute = new JMenuItem("Mute/Unmute");
        JMenuItem volumeLow = new JMenuItem("Low");
        JMenuItem volumeMedium = new JMenuItem("Medium");
        JMenuItem volumeHigh = new JMenuItem("High");
        
        JMenuItem bgm1 = new JMenuItem("Music 1");
        JMenuItem bgm2 = new JMenuItem("Music 2");
        JMenuItem bgm3 = new JMenuItem("Music 3");
        
        // Add MenuItem to fileMenu
        fileMenu.add(newGame);
        fileMenu.add(resetGame);
        fileMenu.add(exitGame);
        
        // Add volume submenus settings
        volumeMenu.add(volumeMute); 
        volumeMenu.add(volumeLow); 
        volumeMenu.add(volumeMedium); 
        volumeMenu.add(volumeHigh);

        // Add Volume into optionsMenu
        optionsMenu.add(volumeMenu);
        
        // Add change music submenus
        bgmMenu.add(bgm1);
        bgmMenu.add(bgm2);
        bgmMenu.add(bgm3);

        //Add Change Music into optionsMenu
        optionsMenu.add(bgmMenu);
        
        // Add Menu to MenuBar
        this.add(fileMenu);
        this.add(optionsMenu);

        // Set Mnemonic (i.e. Alt)
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newGame.setMnemonic(KeyEvent.VK_N);
        resetGame.setMnemonic(KeyEvent.VK_R);
        exitGame.setMnemonic(KeyEvent.VK_E);

        optionsMenu.setMnemonic(KeyEvent.VK_O);
        volumeMenu.setMnemonic(KeyEvent.VK_V);
        bgmMenu.setMnemonic(KeyEvent.VK_C);
        
        volumeMute.setMnemonic(KeyEvent.VK_U);
        volumeLow.setMnemonic(KeyEvent.VK_L);
        volumeMedium.setMnemonic(KeyEvent.VK_M);
        volumeHigh.setMnemonic(KeyEvent.VK_H);

        bgm1.setMnemonic(KeyEvent.VK_M);
        bgm2.setMnemonic(KeyEvent.VK_U);
        bgm3.setMnemonic(KeyEvent.VK_S);

        // Set Accelerator (i.e. Ctrl)
        newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        resetGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        exitGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        
        volumeMute.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK));
        volumeLow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
        volumeMedium.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK));
        volumeHigh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));

        bgm1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        bgm2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        bgm3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));

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
        
        // Change music
        bgm1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm1") {
        			SudokuMain.backgroundMusic.switchSong("Guitar-Gentle.wav");
        			SudokuMain.currentBGM = "bgm1";
        		}
        	}
        });
        
        bgm2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm2") {
        			SudokuMain.backgroundMusic.switchSong("Neverland.wav");
        			SudokuMain.currentBGM = "bgm2";
        		}
        	}
        });
        
        bgm3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(SudokuMain.currentBGM != "bgm3") {
        			SudokuMain.backgroundMusic.switchSong("The-Beginning-w-Caturday.wav");
        			SudokuMain.currentBGM = "bgm3";
        		}
        	}
        });
    }


    
}
