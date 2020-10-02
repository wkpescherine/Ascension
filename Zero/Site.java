import java.awt.*;
import javax.swing.*;
public class Site{
	JPanel siteMain = new JPanel();
	JLabel label1 = new JLabel("Welcome");
	Site(){
		siteMain.setLayout(new FlowLayout());
		siteMain.add(label1);
	}
}