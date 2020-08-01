import java.awt.*;
import javax.swing.*;

public class CreateViewStart {
	JPanel start = new JPanel();
	JButton logIn = new JButton("Log In");
    JButton createAcct = new JButton("Create");
    JButton startAbout = new JButton("About"); 
    JLabel startUsername = new JLabel("Username");
    JLabel startPassword = new JLabel("Password");
    JTextField startEditUsername = new JTextField(20);
    JTextField startEditPassword = new JTextField(20);

    CreateViewStart(){
        start.setLayout(null);
		start.setPreferredSize(new Dimension(860,560));
		start.setBackground(Color.BLACK);
		startUsername.setForeground(Color.WHITE);
		startPassword.setForeground(Color.WHITE);
		startUsername.setBounds(380, 50, 200, 25);
		startEditUsername.setBounds(380, 100,200,25);
		startPassword.setBounds(380, 150, 200, 25);
		startEditPassword.setBounds(380, 200,200,25);
		logIn.setBounds(380,250,200,25);
		createAcct.setBounds(380,300,200,25);
		startAbout.setBounds(380,350,200,25);
		start.add(startUsername);
		start.add(startEditUsername);
		start.add(startPassword);
        start.add(startEditPassword);
		start.add(logIn);
		start.add(createAcct);
		start.add(startAbout);
		start.setVisible(true);
    }
}