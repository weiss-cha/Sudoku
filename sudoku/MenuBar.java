package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar {

    GameBoard board = new GameBoard();
    
    public MenuBar(GameBoard board) {
        super();

        JMenu file = new JMenu("File");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exitGame = new JMenuItem("Exit");

        file.add(newGame);
        file.add(resetGame);
        file.add(exitGame);

        this.add(file);
        this.add(options);
        this.add(help);

        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.init();
            }
        });

        resetGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });

        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


    
}
