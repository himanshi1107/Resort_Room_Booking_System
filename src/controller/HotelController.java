package controller;

import model.Hotel;
import model.HotelDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HotelController {

	static Connection con = null;
	static Statement st= null;
	static ResultSet rs;
	public static ArrayList<Hotel> customerList = new ArrayList<>();
	
	public static void setData(String query, String msg) {
		try {
			con = HotelDao.getCon();
			st = con.createStatement();
			st.executeUpdate(query);
			if(!msg.equals("")) {
				JOptionPane.showMessageDialog(null, msg);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ResultSet getData(String query) {
		
		try {
			con = HotelDao.getCon();
			st = con.createStatement();
			st.executeQuery(query);
			
			return rs;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return null;
		
	}

	
	
}