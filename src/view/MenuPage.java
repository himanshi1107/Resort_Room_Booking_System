package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPage extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	JButton btn1 =new JButton("MANAGE ROOM"); 
	JButton btn2 =new JButton("CHECK IN");
	JButton btn3 =new JButton("CHECK OUT");
	JButton btn4 =new JButton("CUSTOMER DETAILS"); //all booking
	JButton logoutBtn = new JButton("LOGOUT");
	
	public MenuPage() {
		
		frame.setVisible(true);
	    frame.setSize(1000,600);
	    frame.setLayout(null);
	        
		btn1.setBounds(10,30,150,30);
		btn2.setBounds(200,30,150,30);
		btn3.setBounds(400,30,150,30);
		btn4.setBounds(600,30,150,30);
		logoutBtn.setBounds(800,30,150,30);
		
		logoutBtn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(logoutBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			
			new ManageRoom();
		}
		if(e.getSource() == btn2) {
			new CheckIn();
		}
		if(e.getSource() == btn3) {
			new CheckOut();
		}
		if(e.getSource() == btn4) {
			new CustomerReport();
		}
		if(e.getSource() ==  logoutBtn) {
			frame.dispose();
			new LogInPage();
		}
		
	}
//	roomNo1 = (String)fillRoomNo.getSelectedItem();
//	try {
//		ResultSet rs = HotelController.getData("select * from rooms where roomNo='"+roomNo1+"'");
//		if(rs != null) {
//			do
//			{
//				fillPrice.setText(rs.getString(4));
//			}while(rs.next());
//			rs.close();
//			}
//	}
//	catch(Exception e){
//		JOptionPane.showMessageDialog(null, e);
//	}
	
}
