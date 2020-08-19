import java.awt.*;
import javax.swing.*;

public class CreateSavedGameGUI{
    JPanel savedGames = new JPanel();
    JButton backToMain2 = new JButton("Back to Main");
    JLabel savedGameLabel1 = new JLabel("Game slot 1");
    JLabel savedGameLabel2 = new JLabel("Game slot 2");
    JLabel savedGameLabel3 = new JLabel("Game slot 3");
    JLabel savedGameLabel4 = new JLabel("Game slot 4");
    
    CreateSavedGameGUI(){
        savedGames.setLayout(null);
        savedGames.setPreferredSize(new Dimension(780,580));
        backToMain2.setBounds(200,500,100,20);
        savedGameLabel1.setForeground(Color.WHITE);
        savedGameLabel1.setBounds(20,100,300,20);
        savedGameLabel2.setForeground(Color.WHITE);
        savedGameLabel2.setBounds(20,200,300,20);
        savedGameLabel3.setForeground(Color.WHITE);
        savedGameLabel3.setBounds(20,300,300,20);
        savedGameLabel4.setForeground(Color.WHITE);
        savedGameLabel4.setBounds(20,400,300,20);
        savedGames.setBackground(Color.BLACK);
        savedGames.add(backToMain2);
        savedGames.add(savedGameLabel1);
        savedGames.add(savedGameLabel2);
        savedGames.add(savedGameLabel3);
        savedGames.add(savedGameLabel4);
        savedGames.setVisible(false);
    }
}