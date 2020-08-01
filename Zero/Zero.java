import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

public class Zero implements ActionListener{
	CreateViewAbout viewAbout = new CreateViewAbout();
	CreateViewStart viewStart = new CreateViewStart();
	CreateViewMain viewMain = new CreateViewMain();
	CreateViewCreate viewCreate = new CreateViewCreate();

	JFrame window = new JFrame("Zero 0.2.2");

    Zero(){
		viewStart.createAcct.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					viewStart.start.setVisible(false);
					viewCreate.create.setVisible(true);
				}
			}
		);

		viewStart.startAbout.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					viewStart.start.setVisible(false);
					viewCreate.create.setVisible(false);
					viewAbout.aboutSec.setVisible(true);
				}
			}
		);
		viewStart.logIn.addActionListener(this);

		viewCreate.back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					exit();
				}
			}
		);
		viewCreate.newAccount.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					viewCreate.create.setVisible(false);
					viewMain.main.setVisible(true);
				}
			}
		);

		viewAbout.aboutBack.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					viewAbout.aboutSec.setVisible(false);
					viewStart.start.setVisible(true);
				}
			}
		);

		viewMain.close.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					exit();
				}
			}
		);

		window.add(viewStart.start);
		window.add(viewMain.main);
		window.add(viewCreate.create);
		window.add(viewAbout.aboutSec);
		window.setLayout(new FlowLayout());
		window.getContentPane().setBackground(Color.BLACK);
		window.setSize(900,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }

    public static void main(String args[]){
		Zero zero = new Zero();
	}
	
	public void actionPerformed(ActionEvent e){
		viewStart.start.setVisible(false);
		viewCreate.create.setVisible(false);
		viewMain.main.setVisible(true);
	}

	public void exit(){
		viewMain.main.setVisible(false);
		viewStart.start.setVisible(true);
	}
}