package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.HotelController;
import model.HotelDao;

public class CustomerReport extends JFrame{

	JFrame f4=new JFrame();
	String data[][]={};
	String column[]={"Id","Name","Mobile No","Nationality","Gender","Email","Id Proof","Address","Check In Date","Room No","Room Type","No of beds","Price per Day","No of Days","Total Amount","Check Out Date"};
	JTable jt=new JTable();
	
	JScrollPane sp=new JScrollPane(jt);
	
	 JLabel endDate = new JLabel("Check Out Date");
	 JTextField  fillEndDate = new JTextField();
	 JButton searchBtn = new JButton("Search");
	 DefaultTableModel model = new DefaultTableModel(data, column);
	
	public CustomerReport() {

		model.setColumnIdentifiers(column);
		jt.setModel(model);
		endDate.setBounds(300,460,150,30);
	    f4.add(endDate);

	    fillEndDate.setBounds(450,460,150,30);
	    f4.add(fillEndDate);
	    
	    searchBtn.setBounds(670,460,100,30);
        searchBtn.setBackground(new Color(255,0,0));
        f4.add(searchBtn);
        f4.add(sp);
    	

		//jt.setBounds(30, 100, 200, 300);
		//sp.setBounds(20, 70, 1000, 400);
		f4.setSize(1300,600);
		f4.setVisible(true);
        f4.setLayout(null);
        
        
    
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Calendar cal = Calendar.getInstance();
		fillEndDate.setText(sdf.format(cal.getTime()));
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String checkOutDate = fillEndDate.getText();
				Connection con = HotelDao.getCon();
				Statement st;
				ResultSet rs = null;
				try {
					st = con.createStatement();
					rs = st.executeQuery("select * from customers where checkOut = '"+checkOutDate+"';");

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

	            model = (DefaultTableModel)jt.getModel();
				try {
					while(rs.next())
					{
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)});

					}
					rs.close();
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
    
	}
}

