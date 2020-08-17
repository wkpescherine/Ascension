import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CreateSavedGames{
    JPanel savedGames = new JPanel();
    JButton backToMain2 = new JButton("Back to Main");
    JLabel savedGameLabel1 = new JLabel("Game slot 1");
    JLabel savedGameLabel2 = new JLabel("Game slot 2");
    JLabel savedGameLabel3 = new JLabel("Game slot 3");
    JLabel savedGameLabel4 = new JLabel("Game slot 4");

    CreateSavedGames(){
        getSavedGames();
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

    public void getSavedGames(){
        try{
            File myFile = new File("ascensionSavedGames.txt");
            Scanner myReader = new Scanner(myFile);
            int slotNumber = 1;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String [] dataArray = data.split(",",8);
                String savedGame1 = dataArray[0]+" "+dataArray[1]+" "+dataArray[2];
                System.out.print(slotNumber + savedGame1);
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
    }
}