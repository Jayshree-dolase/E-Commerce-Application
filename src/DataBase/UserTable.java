package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import User.Show_Option;

public class UserTable {

	public void createUser() {
		
	try {
		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream("D:\\Jayshree_Workspace-1.8\\E-Commerce-Application\\Resources\\config.properties");
		properties.load(inputStream);
		
		 String Driver =properties.getProperty("Driver");
		 String url =properties.getProperty("url");
		 String username =properties.getProperty("username");
		 String password =properties.getProperty("password");
		
		Class.forName(Driver);

		Connection con = DriverManager.getConnection(url,username,password);

		PreparedStatement stmt = con.prepareStatement("create table User(user_Id int  AUTO_INCREMENT,first_Name varchar(200),LastName varchar(200), username varchar(100),password varchar(100),city varchar (100),mail_Id varchar (50), mobile_number int ,PRIMARY KEY (user_Id))");

				 stmt.executeUpdate();

		System.out.println("table creaeted successfully.");

	} catch (Exception e) {

		e.printStackTrace();
	}
}

	public static void main(String[] args) {
		
		UserTable usertable = new UserTable();
		 usertable.createUser();
		//usertable.insertUser();
		
		
	}
	
	

		
	}
	

