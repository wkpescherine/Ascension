import java.awt.*;
import javax.swing.*;

public class CreateNewGameGUI {
    JPanel newGame = new JPanel();
    JButton backToMain = new JButton("Back to Main");

    CreateNewGameGUI(){
        newGame.setLayout(new FlowLayout());
        newGame.setPreferredSize(new Dimension(780,580));
        newGame.setBackground(Color.BLACK);
        backToMain.setBounds(200,100,100,20);
        newGame.add(backToMain);
        newGame.setVisible(false);
    }
}