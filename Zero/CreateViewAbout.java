import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class CreateViewAbout {
    JPanel aboutSec = new JPanel();
    JButton aboutBack = new JButton("Back");

    CreateViewAbout(){
        aboutSec.setLayout(new FlowLayout());
        aboutSec.setPreferredSize(new Dimension(300,560));
        aboutBack.setPreferredSize(new Dimension(80,60));
        aboutSec.add(aboutBack);
        aboutSec.setVisible(false);    
    }
}