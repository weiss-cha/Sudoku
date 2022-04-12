package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DifficultyDialog extends JDialog{

    // Constructor
    public DifficultyDialog(GameBoard board) {
        super(new JFrame(), "New Game");

        setLayout(new FlowLayout());

        JLabel label = new JLabel("Please choose your difficulty:");
        label.setHorizontalAlignment(JLabel.CENTER);  
        add(label);

        JPanel panel = new JPanel();
        add(panel);

        JButton easy = new JButton("Easy");
        JButton normal = new JButton("Normal");
        JButton hard = new JButton("Hard");

        panel.add(easy);
        panel.add(normal);
        panel.add(hard);
    
        setSize(250, 104);

        setVisible(true);

        // Add Listener to Button

        // Easy Mode
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.init(2);
                dispose();
            }
        });

        // Normal Mode
        normal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.init(20);
                dispose();
            }
        });

        // Hard Mode
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.init(50);
                dispose();
            }
        });
    }
}
