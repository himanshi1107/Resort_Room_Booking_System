package view;

import controller.HotelController;
import model.Hotel;
import model.HotelDao;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class ManageRoom extends JFrame {

	JFrame jframe = new JFrame();
	String []bedType = {"","Single","Double"};
    String []roomType = {"","Ac","Non-Ac"};
    
	JLabel head = new JLabel("Add Rooms");
	JLabel roomNo = new JLabel("Room Number");
	JTextField fillRoomNo = new JTextField();
	JLabel bed  = new JLabel("Bed");
    JComboBox<String> fillBed = new JComboBox<>(bedType);

    JLabel room  = new JLabel("Room Type");
    JComboBox<String> fillRoom= new JComboBox<>(roomType);

	JLabel price = new JLabel("Price");
    JTextField  fillPrice = new JTextField();
    JButton addBtn=new JButton("Add Room");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table=new JTable();
 
	void table()
	{
		
		String data[][]={{"","","",""}};
		String column[]={"Room No","No of beds","Room Type","Price per Day"};
		table.setBackground(Color.CYAN.brighter());
		table.setForeground(Color.black);
		Font font = new Font("", 1, 18);
		table.setFont(font);
		table.setRowHeight(30);
		model.setColumnIdentifiers(column);
		table.setModel(model);
    	JScrollPane sp=new JScrollPane(table);
    	
      	jframe.add(sp);
    	
    	 sp.setBounds(30, 100, 500, 400);
        
	}
	public ManageRoom() {
		
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Eclipse-Workspace\\Hotel_Management_System\\src\\image\\manage.png");
		
		jframe.setIconImage(icon);
		head.setForeground(Color.white);
        head.setOpaque(true);
        head.setBackground(Color.black);
        head.setFont(new Font("Serif", Font.BOLD,25));
        head.setBounds(400, 30, 140, 35);
        jframe.setVisible(true);
        jframe.setSize(1000,600);
        jframe.setLayout(null);
        
        roomNo.setBounds(650,155,230,20);
        jframe.add(roomNo);

        fillRoomNo.setBounds(650,179,230,20);
        jframe.add(fillRoomNo);
        
        bed.setBounds(650,215,230,20);
        jframe.add(bed);

        fillBed.setBounds(650,239,230,20);
        jframe.add(fillBed);
        
        room.setBounds(650,275,230,20);
        jframe.add(room);

        fillRoom.setBounds(650,299,230,20);
        jframe.add(fillRoom);
        
        price.setBounds(650,335,230,20);
        jframe.add(price);

        fillPrice.setBounds(650,359,230,20);
        jframe.add(fillPrice);
        
        addBtn.setBounds(650,460,100,35);
        addBtn.setBackground(new Color(204, 255, 204));
        jframe.add(addBtn);
        
        jframe.add(head);
        
        table();
        addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String rn= fillRoomNo.getText();
				String bd = (String)fillBed.getSelectedItem();
				String rt = (String)fillRoom.getSelectedItem();
				String pr = fillPrice.getText();
				
				String query = "insert into rooms values("+rn+",'"+bd+"','"+rt+"',"+pr+",'Not Booked')";
				HotelController.setData(query, "Successfully Added");
				setVisible(true);

				Connection con = HotelDao.getCon();
				Statement st;
				ResultSet rs = null;
				try {
					st = con.createStatement();
					rs = st.executeQuery("Select * from rooms");

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				model = (DefaultTableModel)table.getModel();
				try {
					while(rs.next())
					{
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
					}
					rs.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
			
				
			}
		});
        jframe.setLocationRelativeTo(null);
        
		
	}
	
	
}