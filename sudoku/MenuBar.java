package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar {

    GameBoard board = new GameBoard();

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
                board.init();
            }
        });

        //Reset Game
        resetGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });

        // Exit
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


    
}
