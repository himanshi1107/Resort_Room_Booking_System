package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LogInPage extends JFrame implements ActionListener  {

	Container container=getContentPane();
    
	JFrame frame = new JFrame();
	JLabel head = new JLabel("Resort Room Booking System");
	JLabel userLabel=new JLabel("USER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField("admin");
    JPasswordField passwordField=new JPasswordField("0000");
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
	 
   
    
	public LogInPage()
	{
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Eclipse-Workspace\\Hotel_Management_System\\src\\image\\logo1.png");
		
		frame.setIconImage(icon);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setLayout(null);

        head.setForeground(Color.white);
        head.setOpaque(true);
        head.setBackground(Color.black);
        head.setFont(new Font("Serif", Font.BOLD,30));
        
        head.setBounds(230, 30, 350, 40);
	    userLabel.setBounds(250,150,100,30);
	    passwordLabel.setBounds(250,220,100,30);
	    userTextField.setBounds(350,150,150,30);
	    passwordField.setBounds(350,220,150,30);
	    showPassword.setBounds(350,265,150,30);
	    loginButton.setBounds(260,320,100,30);
	    resetButton.setBounds(410,320,100,30);	
	    
	    loginButton.addActionListener(this);
	    resetButton.addActionListener(this);
	    showPassword.addActionListener(this);
	  
	       frame.add(userLabel);
	       frame.add(head);
	       frame.add(passwordLabel);
	       frame.add(userTextField);
	       frame.add(passwordField);
	       frame.add(showPassword);
	       frame.add(loginButton);
	       frame.add(resetButton);
	       
	  }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button
		if (e.getSource() == loginButton ) {
            String userText;
            String passText;
            userText = userTextField.getText();
            passText = String.valueOf(passwordField.getPassword());
            if (userText.equalsIgnoreCase("Admin") && passText.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(this, "Login Successfully");
                frame.dispose();
                new MenuPage();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }
        //RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
		
	}
	
	}
	
	
}
