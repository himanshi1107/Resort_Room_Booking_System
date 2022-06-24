package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyCanvas extends JFrame {

	JLabel l1;
	
	public MyCanvas() {
//		setTitle("background image");
//		setSize(700, 700);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		setLayout(new BorderLayout());
		
		setContentPane(new JLabel(new ImageIcon("D:\\Eclipse-Workspace\\Hotel_Management_System\\src\\image\\LogIn.jpeg")));
		setLayout(new FlowLayout());
		l1 = new JLabel();
		add(l1);
		setSize(500,500);

	}
}
