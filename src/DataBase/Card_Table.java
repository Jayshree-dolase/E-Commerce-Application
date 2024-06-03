package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Card_Table {
	
	private final static String Driver = "com.mysql.cj.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/ecom";
	private final static String username="root";
	private final static String password="root";
	public static void main(String[] args) {
try {
	Class.forName(Driver);
	Connection con = DriverManager.getConnection(url,username,password);
	PreparedStatement stmt = con.prepareStatement("create table card (card_id int AUTO_INCREMENT,cname varchar(100))");
 
	stmt.execute();
System.out.println("Table created successfully.");
con.close();
stmt.close();
}catch(Exception e) {
	e.printStackTrace();
}
		
		
	}

}
