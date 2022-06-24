package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

import controller.HotelController;
import model.Hotel;
import model.HotelDao;

public class CheckIn extends JFrame {

	String []bedType = {"","Single","Double"};
	String []roomType = {"","Ac","Non-Ac"};
	String []genderType = {"","Male","Female","Other"};	
	
    JFrame  jframe = new JFrame();
    JLabel name = new JLabel("Name");
    JTextField  fillName = new JTextField();
    JLabel mobileNumber = new JLabel("Mobile No.");
    JTextField  fillMobile = new JTextField();
    JLabel nationality = new JLabel("Nationality");
    JTextField  fillNationality = new JTextField();
    JLabel gender = new JLabel("Gender");
    JComboBox<String> fillGender = new JComboBox<>(genderType);
    JLabel email = new JLabel("Email");
    JTextField  fillEmail = new JTextField();
    JLabel idProof = new JLabel("Id Proof");
    JTextField  fillIdProof = new JTextField();

    JLabel address = new JLabel("Address");
    JTextField  fillAddress = new JTextField();


    JLabel date  = new JLabel("Check In Date(Today)");
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    JFormattedTextField fillDate = new JFormattedTextField(df);
    Calendar cal = Calendar.getInstance();
    

    JLabel bed  = new JLabel("Bed");
    JComboBox<String> fillBed = new JComboBox<String>(bedType);

    JLabel room  = new JLabel("Room Type");
    JComboBox<String> fillRoom= new JComboBox<>(roomType);

    JLabel roomNo  = new JLabel("Room Number");
    JComboBox<String> fillRoomNo = new JComboBox<>();

    JLabel price = new JLabel("Price");
    JTextField  fillPrice = new JTextField("");

    JButton allotBtn = new JButton("Allot Room");
    JButton clearBtn = new JButton("Clear");
  
    String bed1,roomType1,roomNo1,price1;
    public CheckIn(){
    	
        jframe.setSize(1000,600);
        jframe.setVisible(true);;
        jframe.setLayout(null);
        fillDate.setEditable(false);
        fillPrice.setEditable(false);
        fillDate.setText(df.format(cal.getTime()));

        name.setBounds(90,35,230,20);
        jframe.add(name);

        address.setBounds(650,35,230,20);
        jframe.add(address);

        fillName.setBounds(90,59,230,20);
        jframe.add(fillName);

        fillAddress.setBounds(650,59,230,20);
        jframe.add(fillAddress);

        mobileNumber.setBounds(90,95,230,20);
        jframe.add(mobileNumber);

        date.setBounds(650,95,230,20);
        jframe.add(date);

        fillDate.setBounds(650,119,230,20);
        jframe.add(fillDate);

        fillMobile.setBounds(90,119,230,20);
        jframe.add(fillMobile);

        nationality.setBounds(90,155,230,20);
        jframe.add(nationality);

        bed.setBounds(650,155,230,20);
        jframe.add(bed);

        fillNationality.setBounds(90,179,230,20);
        jframe.add(fillNationality);

        fillBed.setBounds(650,179,230,20);
        jframe.add(fillBed);

        gender.setBounds(90,215,230,20);
        jframe.add(gender);

        room.setBounds(650,215,230,20);
        jframe.add(room);

        fillGender.setBounds(90,239,230,20);
        jframe.add(fillGender);

        fillRoom.setBounds(650,239,230,20);
        jframe.add(fillRoom);

        roomNo.setBounds(650,275,230,20);
        jframe.add(roomNo);

        email.setBounds(90,275,230,20);
        jframe.add(email);

        fillEmail.setBounds(90,299,230,20);
        jframe.add(fillEmail);

        fillRoomNo.setBounds(650,299,230,20);
        jframe.add(fillRoomNo);
        
        idProof.setBounds(90,335,230,20);
        jframe.add(idProof);

        price.setBounds(650,335,230,20);
        jframe.add(price);

        fillIdProof.setBounds(90,359,230,20);
        jframe.add(fillIdProof);

        fillPrice.setBounds(650,359,230,20);
        jframe.add(fillPrice);

        allotBtn.setBounds(350,460,100,35);
        jframe.add(allotBtn);
        allotBtn.setBackground(new Color(204, 255, 204));

        clearBtn.setBounds(500,460,100,35);
        clearBtn.setBackground(new Color(204, 255, 204));

        jframe.add(clearBtn);
        allotBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=1;
				String name1 = fillName.getText();
				String moNo1 = fillMobile.getText();
				String nationality1 = fillNationality.getText();
	            String gender1 = (String)fillGender.getSelectedItem();
	            String email1 = fillEmail.getText();
	            String idProof1 = fillIdProof.getText();
	            String address1 = fillAddress.getText();
	            String date1 = fillDate.getText();
	            String bd1 = (String)fillBed.getSelectedItem();
	            String room1 = (String)fillRoom.getSelectedItem();
	            String roomNo1 = (String)fillRoomNo.getSelectedItem();
	            String price1 = fillPrice.getText();
	            String query = "select max(id) from customers";
	            try
	            {
	            	ResultSet rs = HotelController.getData(query);
//	            	if(rs != null) {
//						do
//						{
//							id = rs.getInt(1);
//						}while(rs.next());
//	            	}
//	            	
	            	if(!price1.equals("")) {
	            		query = "update rooms set roomStatus='Booked' where roomNo='"+roomNo1+"'";
	            		HotelController.setData(query, "");
	            		query="insert into customers(fullname,moNo,nationality,gender,email,idProof,address,checkIn,roomType,bed,roomNo,pricePerDay) values ("+name1+"','"+moNo1+"','"+nationality1+"','"+gender1+"','"+email1+"','"+idProof1+"','"+address1+"','"+date1+"','"+room1+"','"+bd1+"','"+roomNo1+"',"+price1+")";
	            		HotelController.setData(query, "Check In Successfully");
	            		
	            	}
	            
	            }catch (Exception ex) {
	            	JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
        clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					fillName.setText("");
		            fillAddress.setText("");
		            fillMobile.setText("");
		            fillNationality.setText("");
		            fillEmail.setText("");
		            fillIdProof.setText("");
		            fillPrice.setText("");
				
			}
		});
        
       fillRoom.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			ArrayList<String> ar=new ArrayList<String>();
			ArrayList<String> ar1=new ArrayList<String>();
			String cb1=fillBed.getSelectedItem().toString();
			String cb2=fillRoom.getSelectedItem().toString();
			String sql="select * from rooms where beds ='"+cb1+"' and roomType = '"+cb2+"'";
			
		    String url ="jdbc:mysql://localhost:3306/hoteldb";
			String user = "root";
			String pass = "Himanshi@2001";
			Statement st=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,pass);
				st = con.createStatement();
				
			} catch (Exception x) {
				System.out.println("ERROR : 202");
				x.printStackTrace();
			}
			
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()) {
					ar.add(rs.getString(1));
					ar1.add(rs.getString(4));
					System.out.println("Data "+rs.getString(1));
					System.out.println("Data "+rs.getString(4));

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for(String s:ar)
			{
			fillRoomNo.addItem(s);
			}
			for(String s1:ar1)
			{
			fillPrice.setText(s1);
			}
		}
	});
       
             
}
    


	
   
}
