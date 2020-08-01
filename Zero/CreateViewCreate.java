import java.awt.*;
import javax.swing.*;

public class CreateViewCreate {
    JPanel create = new JPanel();
    JButton logIn = new JButton("Log In");
    JButton back = new JButton("Back");
    JButton newAccount = new JButton("Create Account");
    JLabel username = new JLabel("Username");
	JLabel password = new JLabel("Password");
	JTextField username3 = new JTextField(20);
	JTextField password3 = new JTextField(20);

    CreateViewCreate(){
        create.setLayout(new FlowLayout());
		create.setBackground(Color.BLACK);
		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		create.setPreferredSize(new Dimension(100,560));
        back.setPreferredSize(new Dimension(80,60));
        create.add(username);
		create.add(username3);
		create.add(password);
		create.add(password3);
		create.add(newAccount);
		create.add(back);
		create.setVisible(false);
    }
}