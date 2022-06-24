package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class HotelDao {
	
	public static String url ="jdbc:mysql://localhost:3306/hoteldb";
	public static String user = "root";
	public static String pass = "Himanshi@2001";
	static Statement st;
	static Connection con;


	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			System.out.println("ERROR : 202");
			e.printStackTrace();
		}
		return con;
		
	}

}
