import java.awt.*; 
//import java.awt.event.*;
import javax.swing.*;
//import java.lang.String;

public class CreateDisplay {
    JPanel main = new JPanel();
    JButton createFile = new JButton("Create New File");

    CreateDisplay(){
        main.add(createFile);
        main.setLayout(new FlowLayout());
        main.setPreferredSize(new Dimension(400,580));
    }
}