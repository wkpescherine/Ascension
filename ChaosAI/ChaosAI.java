import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.*;

public class ChaosAI implements ActionListener{
    CreateDisplay cdisplay = new CreateDisplay();
    LineDisplay ldisplay = new LineDisplay();
    BuilderAI builder = new BuilderAI();

    //String [] data = new String[10];
    String fileName = "tested";
    int value = 0;

    JFrame window = new JFrame("ChaosAI v1");

    ChaosAI(){
        System.out.println(builder.words);
        System.out.println(builder.data);
        System.out.println(builder.data3);
        reBuildAI();
        cdisplay.createFile.addActionListener(this);
        cdisplay.writeFile.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    try{
                        fileName = cdisplay.fileName.getText()+".html";
                        FileWriter myWriter = new FileWriter(fileName, true);
                        BufferedWriter bWriter = new BufferedWriter(myWriter);
                        PrintWriter pWriter = new PrintWriter(bWriter);
                        for(int a = 1; a< ldisplay.data.length; a++){
                            if(ldisplay.data[a] == ""){pWriter.close();}
                            pWriter.write(ldisplay.data[a]+"\r");    
                        }
                        pWriter.close();
                        System.out.print("Current File Created");
                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }  
				}
			}
        );

        window.add(cdisplay.main);
        window.add(ldisplay.main);
		window.setLayout(new FlowLayout());
		window.getContentPane().setBackground(Color.BLACK);
		window.setSize(900,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }

    public static void main(String args[]){
        ChaosAI chaos = new ChaosAI();
    }

    public void actionPerformed(ActionEvent e){
        ldisplay.data[1] = "<!DOCTYPE html>";
        ldisplay.data[2] = "\t <html>";
        ldisplay.data[3] = "\t <body>";
        ldisplay.data[4] = "\t\t <h1>My First Heading</h1>";
        ldisplay.data[5] = "\t\t <p>My first paragraph.</p>";
        ldisplay.data[6] = "\t </body>";
        ldisplay.data[7] = "</html>";
        ldisplay.main.revalidate();
        ldisplay.main.repaint();
        System.out.print(ldisplay.data[2]);
        value +=1;
    }
    
    public void reBuildAI(){      
        File f = new File(fileName + ".html");
        f.delete();
        try{
            FileWriter myWriter = new FileWriter("builderAI.java", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }  
    }
}