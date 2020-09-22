import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CreateSavedGameGUI{
    JPanel savedGames = new JPanel();
    JPanel savedGameSection1 = new JPanel();
    JPanel savedGameSection2 = new JPanel();
    JPanel savedGameSection3 = new JPanel();
    JPanel savedGameSection4 = new JPanel();
    JButton backToMain2 = new JButton("Back to Main");
    JButton loadGame1 = new JButton("Load Game");
    JButton loadGame2 = new JButton("Load Game");
    JButton loadGame3 = new JButton("Load Game");
    JButton loadGame4 = new JButton("Load Game");
    JButton deleteGame1 = new JButton("Delete");
    JButton deleteGame2 = new JButton("Delete");
    JButton deleteGame3 = new JButton("Delete");
    JButton deleteGame4 = new JButton("Delete");
    JLabel savedGameLabel1 = new JLabel("Game slot 1");
    JLabel savedGameLabel2 = new JLabel("Game slot 2");
    JLabel savedGameLabel3 = new JLabel("Game slot 3");
    JLabel savedGameLabel4 = new JLabel("Game slot 4");
    ArrayList<String> toons = new ArrayList<>();

    CreateSavedGameGUI(){
        savedGames.setLayout(new FlowLayout());
        savedGames.setPreferredSize(new Dimension(780,580));
        backToMain2.setBounds(200,500,100,20);
        savedGameSection1.setLayout(new FlowLayout());
        savedGameSection1.setPreferredSize(new Dimension(760,120));
        savedGameSection1.setBackground(Color.BLACK);
        savedGameLabel1.setPreferredSize(new Dimension(760,20));
        savedGameSection1.add(savedGameLabel1);
        savedGameSection1.add(loadGame1);
        savedGameSection1.add(deleteGame1);
        savedGameLabel1.setForeground(Color.WHITE);
        savedGameSection2.setLayout(new FlowLayout());
        savedGameSection2.setPreferredSize(new Dimension(760,120));
        savedGameSection2.setBackground(Color.BLACK);
        savedGameLabel2.setPreferredSize(new Dimension(760,20));
        savedGameSection2.add(savedGameLabel2);
        savedGameSection2.add(loadGame2);
        savedGameSection2.add(deleteGame2);
        savedGameLabel2.setForeground(Color.WHITE);
        savedGameSection3.setLayout(new FlowLayout());
        savedGameSection3.setPreferredSize(new Dimension(760,120));
        savedGameSection3.setBackground(Color.BLACK);
        savedGameLabel3.setPreferredSize(new Dimension(760,20));
        savedGameSection3.add(savedGameLabel3);
        savedGameSection3.add(loadGame3);
        savedGameSection3.add(deleteGame3);
        savedGameLabel3.setForeground(Color.WHITE);
        savedGameSection4.setLayout(new FlowLayout());
        savedGameSection4.setPreferredSize(new Dimension(760,120));
        savedGameSection4.setBackground(Color.BLACK);
        savedGameLabel4.setPreferredSize(new Dimension(760,20));
        savedGameSection4.add(savedGameLabel4);
        savedGameSection4.add(loadGame4);
        savedGameSection4.add(deleteGame4);
        savedGameLabel4.setForeground(Color.WHITE);
        savedGames.setBackground(Color.BLACK);
        savedGames.add(savedGameSection1);
        savedGames.add(savedGameSection2);
        savedGames.add(savedGameSection3);
        savedGames.add(savedGameSection4);
        savedGames.add(backToMain2);
        savedGames.setVisible(false);
    }

    public void getSavedGames(){
        try{
            File myFile = new File("/Users/wkpescherine/Desktop/Ascension/Version4/SavedGames.txt");
            Scanner myReader = new Scanner(myFile);
            int slotNumber = 1;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String [] dataArray = data.split(",",8);
                String savedGame1 = dataArray[0]+" "+dataArray[1]+" "+dataArray[2];
                toons.add(savedGame1);
                if(slotNumber == 1 ){
                    savedGameLabel1.setText(savedGame1);
                }
                if(slotNumber == 2 ){
                    savedGameLabel2.setText(savedGame1);
                }
                if(slotNumber == 3 ){
                    savedGameLabel3.setText(savedGame1);
                }
                if(slotNumber == 4 ){
                    savedGameLabel4.setText(savedGame1);
                }
                slotNumber+=1;
            }
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.print(toons.get(1));
    }
}//32