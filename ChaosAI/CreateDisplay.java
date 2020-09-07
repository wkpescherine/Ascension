import java.awt.*; 
//import java.awt.event.*;
import javax.swing.*;
//import java.lang.String;

public class CreateDisplay {
    JPanel main = new JPanel();
    JTextField fileName = new JTextField(20);
    JButton createFile = new JButton("Create New File");
    JButton writeFile = new JButton("Click to write File");

    CreateDisplay(){
        main.add(fileName);
        main.add(createFile);
        main.add(writeFile);
        main.setLayout(new FlowLayout());
        main.setPreferredSize(new Dimension(400,580));
    }
}