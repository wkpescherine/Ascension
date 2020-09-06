import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

public class ChaosAI implements ActionListener{
    int value = 0;
    CreateDisplay cdisplay = new CreateDisplay();
    LineDisplay ldisplay = new LineDisplay();

    JFrame window = new JFrame("ChaosAI v1");

    ChaosAI(){
        cdisplay.createFile.addActionListener(this);

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
        ldisplay.lineLabel.setText("value = " + value);
        ldisplay.main.add(ldisplay.lineLabel);
        ldisplay.main.revalidate();
        ldisplay.main.repaint();
        value +=1;
	}
}