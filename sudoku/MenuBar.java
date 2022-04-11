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

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exitGame = new JMenuItem("Exit");

        // Add MenuItem to Menu
        file.add(newGame);
        file.add(resetGame);
        file.add(exitGame);

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
    }


    
}
