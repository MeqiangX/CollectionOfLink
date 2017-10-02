package com.defin.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
     public Connection openConnection() {
    	 Properties pr = new Properties();
    	 String driver = null;
    	 String url = null;
    	 String user = null;
    	 String password = null;
    	 try {
			pr.load(this.getClass().getClassLoader().getResourceAsStream("DBconfig.properties"));
			driver = pr.getProperty("driver");
			url = pr.getProperty("url");
			user = pr.getProperty("url");
			password = pr.getProperty("password");
			
			Class.forName(driver);
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 
    	 return null;
     }
     
     public void CloseCon(Connection e) {
    	   try {
			e.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
     
}
