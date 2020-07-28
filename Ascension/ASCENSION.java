import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javafx.application.Application;
//import java.io.*;
import java.lang.String;

public class ASCENSION implements ActionListener{
    String [] attributes = {"None", "None", "None"};
    int [][] stats = new int[3][10];

    JFrame window = new JFrame("Ascension v1");
    JPanel main = new JPanel();
    JPanel savedGames = new JPanel();
    JPanel newGame = new JPanel();
    JPanel selectRace = new JPanel();
    JPanel selectStyle = new JPanel();
    JPanel selectClass = new JPanel();
    JPanel selectBonusAndSkills = new JPanel();
    JPanel bonusSection = new JPanel();
    JPanel skillsSection = new JPanel();
    JButton startSavedGame = new JButton("Saved Game");
    JButton startNewGame = new JButton("New Game");
    JButton bonusAndSkills = new JButton("Bonus and Skills");
    JButton backToMain = new JButton("Back to Main");
    JButton backToMain2 = new JButton("Back to Main");
    JButton backToNewGame = new JButton("Back to New Game");
    JButton start = new JButton("Start Game");
    JButton human = new JButton("Human");
    JButton dwarf = new JButton("Dwarf");
    JButton elven = new JButton("Elven");
    JButton divine = new JButton("Divine");
    JButton diabolic = new JButton("Diabolic");
    JButton wise = new JButton("Wise");
    JButton warrior = new JButton("Warrior");
    JButton rogue = new JButton("Rogue");
    JButton mage = new JButton("Mage");

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

        newGame.setLayout(new FlowLayout());
        newGame.setPreferredSize(new Dimension(780,580));
        selectRace.setPreferredSize(new Dimension(760,170));
        selectRace.add(human);
        human.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Human",0,2,2,2,2,2,2);
				}
			}
        );
        selectRace.add(dwarf);
        dwarf.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Dwarf",0,1,3,2,2,2,2);
				}
			}
        );
        selectRace.add(elven);
        elven.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Elven",0,1,3,2,2,2,2);
				}
			}
        );
        selectStyle.setPreferredSize(new Dimension(760,170));
        selectStyle.add(divine);
        divine.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Divine",1,2,2,2,2,2,2);
				}
			}
        );
        selectStyle.add(diabolic);
        diabolic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Diabolic",1,1,3,2,2,2,2);
				}
			}
        );
        selectStyle.add(wise);
        wise.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Wise",1,1,3,2,2,2,2);
				}
			}
        );
        selectClass.setPreferredSize(new Dimension(760,170));
        selectClass.add(warrior);
        warrior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Warrior",2,2,2,2,2,2,2);
				}
			}
        );
        selectClass.add(rogue);
        rogue.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Rogue",2,2,2,2,2,2,2);
				}
			}
        );
        selectClass.add(mage);
        mage.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Mage",2,2,2,2,2,2,2);
				}
			}
        );
        backToMain.setBounds(200,100,100,20);
        backToMain.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newGame.setVisible(false);
                    main.setVisible(true);
				}
			}
        );
        bonusAndSkills.setBounds(200,300,100,20);
        bonusAndSkills.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newGame.setVisible(false);
                    selectBonusAndSkills.setVisible(true);
				}
			}
        );        
        newGame.setBackground(Color.BLACK);
        newGame.add(selectRace);
        newGame.add(selectStyle);
        newGame.add(selectClass);
        newGame.add(backToMain);
        newGame.add(bonusAndSkills);
        newGame.setVisible(false);

        selectBonusAndSkills.setLayout(new FlowLayout());
        selectBonusAndSkills.setPreferredSize(new Dimension(780,580));
        bonusSection.setPreferredSize(new Dimension(250,510));
        skillsSection.setPreferredSize(new Dimension(500,510));
        backToNewGame.setBounds(200,100,100,20);
        backToNewGame.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newGame.setVisible(true);
                    selectBonusAndSkills.setVisible(false);
				}
			}
        );  
        start.setBounds(200,300,100,20);
        selectBonusAndSkills.setBackground(Color.BLACK);
        selectBonusAndSkills.add(bonusSection);
        selectBonusAndSkills.add(skillsSection);
        selectBonusAndSkills.add(backToNewGame);
        selectBonusAndSkills.add(start);
        selectBonusAndSkills.setVisible(false);

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
        window.add(selectBonusAndSkills);
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
    
    public void setStats(String choice, int a, int b, int c, int d, int e, int f , int g){
        attributes [a] = choice;
        stats [a][0] = b;
        stats [a][1] = c;
        stats [a][2] = d;
        stats [a][3] = e;
        stats [a][4] = f;
        stats [a][5] = g;

        System.out.println(attributes[0]+" "+attributes[1]+" "+attributes[2]);
    }
}