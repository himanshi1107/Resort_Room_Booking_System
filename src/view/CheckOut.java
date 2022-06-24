package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.HotelController;
import model.HotelDao;

public class CheckOut extends JFrame {

	 String []bedType = {"","Single","Double"};
	    String []roomType = {"","Ac","Non-Ac"};
	    String []roomNumbersOption = {"","1","2","3","4","5","6","7","8","9","10"};
	    String []genderType = {"","Male","Female","Other"};

	    JFrame  jframe = new JFrame();
	    JLabel roomNo = new JLabel("Room No");
	    JTextField  fillRoomNo = new JTextField();
	    JLabel name = new JLabel("Customer Name");
	    JTextField  fillName = new JTextField();
	    JLabel mobileNumber = new JLabel("Customer Mobile No.");
	    JTextField  fillMobile = new JTextField();
	    JLabel email = new JLabel("Email");
	    JTextField  fillEmail = new JTextField();
	    JLabel price = new JLabel("Price per Day");
	    JTextField  fillPrice = new JTextField();
	    JLabel days = new JLabel("Number of Days Stay");
	    JTextField  fillDays = new JTextField();

	    JLabel amount = new JLabel("Total Amount of Customer");
	    JTextField  fillAmount = new JTextField();


	    JLabel inDate  = new JLabel("Check In Date");
	    DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
	    JFormattedTextField fillDate1 = new JFormattedTextField(df1);
	    JLabel outDate  = new JLabel("Check Out Date(Today)");
	    DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
	    JFormattedTextField fillDate2 = new JFormattedTextField(df2);

	    JButton checkOutBtn = new JButton("Check Out");
	    JButton clearBtn = new JButton("Clear");
	    JButton searchBtn = new JButton("Search");

	    int id=0;
	    String query,roomType1,bed1,roomNo1;
	    public void check()
	    {
	        fillName.setEditable(false);
	        fillMobile.setEditable(false);
	        fillEmail.setEditable(false);
	        fillPrice.setEditable(false);
	        fillDays.setEditable(false);
	        fillAmount.setEditable(false);
	        fillDate1.setEditable(false);
	        fillDate2.setEditable(false);

	    }

	    public CheckOut(){

	        check();
	        jframe.setSize(1000,600);
	        jframe.setVisible(true);;
	        jframe.setLayout(null);

	        roomNo.setBounds(300,50,200,30);
	        jframe.add(roomNo);

	        fillRoomNo.setBounds(400,50,150,30);
	        jframe.add(fillRoomNo);

	        searchBtn.setBounds(650,50,100,30);
	        searchBtn.setBackground(new Color(255,0,0));
	        jframe.add(searchBtn);

	        name.setBounds(90,155,230,20);
	        jframe.add(name);

	        fillName.setBounds(90,179,230,20);
	        jframe.add(fillName);

	        mobileNumber.setBounds(650,155,230,20);
	        jframe.add(mobileNumber);

	        fillMobile.setBounds(650,179,230,20);
	        jframe.add(fillMobile);

	        inDate.setBounds(90,215,230,20);
	        jframe.add(inDate);

	        fillDate1.setBounds(90,239,230,20);
	        jframe.add(fillDate1);

	        outDate.setBounds(650,215,230,20);
	        jframe.add(outDate);

	        fillDate2.setBounds(650,239,230,20);
	        jframe.add(fillDate2);

	        price.setBounds(90,275,230,20);
	        jframe.add(price);

	        fillPrice.setBounds(90,299,230,20);
	        jframe.add(fillPrice);

	        days.setBounds(650,275,230,20);
	        jframe.add(days);

	        fillDays.setBounds(650,299,230,20);
	        jframe.add(fillDays);

	        amount.setBounds(90,335,230,20);
	        jframe.add(amount);

	        fillAmount.setBounds(90,359,230,20);
	        jframe.add(fillAmount);

	        email.setBounds(650,335,230,20);
	        jframe.add(email);

	        fillEmail.setBounds(650,359,230,20);
	        jframe.add(fillEmail);


	        checkOutBtn.setBounds(350,460,100,35);
	        jframe.add(checkOutBtn);
	        checkOutBtn.setBackground(new Color(204, 255, 204));

	        searchBtn.addActionListener(new ActionListener() {
	            Connection con = HotelDao.getCon();
	            Statement st;
	            ResultSet rs = null;

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                roomNo1 = fillRoomNo.getText();
	                String query="select * from customers where roomNo = '"+roomNo1+"'";

	                try
	                {
	                   st = con.createStatement();
	                   rs = st.executeQuery(query);
	                    if(rs.next())
	                    {
	                        fillRoomNo.setEditable(true);
	                        id=rs.getInt(1);
	                        fillName.setText(rs.getString(2));
	                        fillDate1.setText(rs.getString(9));
	                        fillMobile.setText(rs.getString(3));
	                        
	                        fillEmail.setText(rs.getString(6));
	                        fillPrice.setText(rs.getString(13));

	                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	                        Calendar cal = Calendar.getInstance();
	                        fillDate2.setText(sdf.format(cal.getTime()));
	                        
	                        String dateBeforeString = rs.getString(9);
	                    	Date dateBefore = sdf.parse(dateBeforeString);
	                    	String dateAfterString = sdf.format(cal.getTime());
	                    	Date dateAfter = sdf.parse(dateAfterString);
	                    	long difference = dateAfter.getTime() - dateBefore.getTime(); 
	                    	int stayDays = (int) (difference/(1000*60*60*24));
	                    	if(stayDays==0) {
	                    		stayDays=1;
	                    	}
	                    	fillDays.setText(String.valueOf(stayDays));
	                    	float price1 = Float.parseFloat(fillPrice.getText());
	                    		                    	
	                    	fillAmount.setText(String.valueOf(String.valueOf(price1*stayDays)));	

	                    }else {
	                    	JOptionPane.showMessageDialog(null, "Room Not Booked");
	                    }
	                  
	                }catch (Exception ex) {
	                	JOptionPane.showMessageDialog(null, ex);
					}

	            }
	        });

	        clearBtn.setBounds(500,460,100,35);
	        clearBtn.setBackground(new Color(204, 255, 204));
	        jframe.add(clearBtn);
	        
	        clearBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fillRoomNo.setText("");
					fillName.setText("");
		            fillDate1.setText("");
		            fillMobile.setText("");
		            fillDays.setText("");
		            fillEmail.setText("");
		            fillAmount.setText("");
		            fillDate2.setText("");
		            fillPrice.setText("");
				}
			});
	        
	        checkOutBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
					String name1 = fillName.getText();
					String moNo1 = fillMobile.getText();
		            String email1 = fillEmail.getText();
		            String checkOutDate = fillDate2.getText();
		            String noOfdayStay = fillDays.getText();
		            String amt = fillAmount.getText();
		            String roomNo1 = fillRoomNo.getText();
		            String price1 = fillPrice.getText();
		            
		            String query = "update customers set stayDays= "+noOfdayStay+",totalAmount = '"+amt+"',checkOut = '"+checkOutDate+"' where id ="+id+"";
	            	HotelController.setData(query, "");
	            	String query1="update rooms set roomStatus = 'Not Booked' where roomNo = "+roomNo1;
	            	HotelController.setData(query1, "");
	            	JOptionPane.showMessageDialog(null, "CheckOut Successfully !!");
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			});
	    }
	    
	    

	   
	}