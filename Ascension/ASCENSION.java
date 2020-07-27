import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javafx.application.Application;
import java.lang.String;
//import java.io.*;

public class ASCENSION implements ActionListener{
    int [] race = {0,0,0,0,0,0};
    int [] style = {0.0,0,0,0,0};
    int [] profession = {0,0,0,0,0,0};

    JFrame window = new JFrame("Ascension v1");
    JPanel main = new JPanel();
    JPanel savedGames = new JPanel();
    JPanel newGame = new JPanel();
    JButton startSavedGame = new JButton("Saved Game");
    JButton startNewGame = new JButton("New Game");
    JButton backToMain = new JButton("Back to Main");
    JButton backToMain2 = new JButton("Back to Main");

    ASCENSION(){
        main.setLayout(null);
        main.setPreferredSize(new Dimension(780,580));
        main.setBackground(Color.BLACK);
        startNewGame.setBounds(200,290,100,20);
        startNewGame.addActionListener(this);
        startSavedGame.setBounds(400,290,100,20);
        startSavedGame.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    main.setVisible(false);
                    savedGames.setVisible(true);
				}
			}   
        );
        main.add(startNewGame);
        main.add(startSavedGame);
        main.setVisible(true);

        newGame.setLayout(null);
        newGame.setPreferredSize(new Dimension(780,580));
        backToMain.setBounds(200,200,100,20);
        backToMain.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newGame.setVisible(true);
                    main.setVisible(true);
				}
			}
		);
        newGame.setBackground(Color.BLACK);
        newGame.add(backToMain);
        newGame.setVisible(false);

        savedGames.setLayout(null);
        savedGames.setPreferredSize(new Dimension(780,580));
        backToMain2.setBounds(200,200,100,20);
        backToMain2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    savedGames.setVisible(false);
                    main.setVisible(true);
				}
			}
		);
        savedGames.setBackground(Color.BLACK);
        savedGames.add(backToMain2);
        savedGames.setVisible(false);

        window.add(main);
        window.add(newGame);
        window.add(savedGames);
        window.setLayout(new FlowLayout());
		window.setSize(800, 600);
		window.getContentPane().setBackground(Color.BLACK);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }

    public static void main(String args[]){
        ASCENSION ascension = new ASCENSION();
    }
    public void actionPerformed(ActionEvent e){
		main.setVisible(false);
		newGame.setVisible(true);
	}
}