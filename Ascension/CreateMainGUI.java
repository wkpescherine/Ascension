import java.awt.*;
import javax.swing.*;

public class CreateMainGUI {
    JPanel main = new JPanel();
    JButton startSavedGame = new JButton("Saved Game");
    JButton startNewGame = new JButton("New Game");

    CreateMainGUI(){
        main.setLayout(null);
        main.setPreferredSize(new Dimension(780,580));
        main.setBackground(Color.BLACK);
        startNewGame.setBounds(200,290,100,20);
        startSavedGame.setBounds(400,290,100,20);
        main.add(startNewGame);
        main.add(startSavedGame);
        main.setVisible(true);
    }    
} 