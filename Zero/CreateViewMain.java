import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CreateViewMain {
	Site site = new Site();
	String [] assets ={
		"import java.awt.*;", 
		"import javax.swing.*;",
		"public class Site{",
		"\tJPanel siteMain = new JPanel();",
		"\tJLabel label1 = new JLabel(\"Welcome\");",
		"\tSite(){",
		"\t\tsiteMain.setLayout(new FlowLayout());",
		"\t\tsiteMain.add(label1);",
		"\t}",
		"}"
	};

	JPanel main = new JPanel();
	JPanel display = new JPanel();
	JButton close = new JButton("Exit");
	JButton mail = new JButton("Mail");
	JButton home  = new JButton("Home");
	JButton blank  = new JButton("");
	JButton blank1  = new JButton("");
	JButton blank2  = new JButton("");
	JButton blank3  = new JButton("");
	JButton about2 = new JButton("About");
	JButton searchBtn = new JButton("search");
	JTextField search = new JTextField(50);
	
	CreateViewMain(){
		main.setLayout(new FlowLayout());
		main.setBackground(Color.BLACK);
		main.setPreferredSize(new Dimension (860,540));
		display.setPreferredSize(new Dimension (750,520));
		display.add(site.siteMain);
		close.setPreferredSize(new Dimension(60,60));
		close.setFont(new Font("Serif", Font.PLAIN,12));
		mail.setPreferredSize(new Dimension(60,60));
		mail.setFont(new Font("Serif", Font.PLAIN, 12));
		about2.setPreferredSize(new Dimension(80,60));
		about2.setFont(new Font("Serif", Font.PLAIN,12));
		searchBtn.setPreferredSize(new Dimension(90,20));
		searchBtn.setFont(new Font("Serif", Font.PLAIN, 12));
		home.setPreferredSize(new Dimension(60,60));
		blank.setPreferredSize(new Dimension(60,60));
		blank1.setPreferredSize(new Dimension(60,60));
		blank2.setPreferredSize(new Dimension(60,60));
		blank3.setPreferredSize(new Dimension(60,60));
		main.add(home);
		main.add(mail);
		main.add(close);
		main.add(about2);
		main.add(blank);
		main.add(blank1);
		main.add(blank2);
		main.add(blank3);
		main.add(search);
		main.add(searchBtn);
		main.add(display);
		main.setVisible(false);
	};

	public void Home(){
		System.out.println("Hit this function");
		File f = new File("Site.java");
		f.delete();
        try{
            FileWriter myWriter = new FileWriter("Site.java", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            for(int a = 0; a< assets.length; a++){
                pWriter.write(assets[a]+"\r");    
            }
            pWriter.close();
            System.out.print("Current File Created");
        }catch(IOException e){
            e.printStackTrace();  
		}
		display.validate();
		display.repaint();
	}
}//38