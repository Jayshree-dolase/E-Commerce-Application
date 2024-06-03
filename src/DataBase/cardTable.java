package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class cardTable {

	public static void main(String[] args) {
		
		
		
		try {
			Properties properties = new Properties();
			FileInputStream inputStream = new FileInputStream(new File("D:\\Velocity_E-commerce\\E-Commerce-Application\\Resources\\config.properties "));
			properties.load(inputStream);
			 String Driver =properties.getProperty("Driver");
			 String url =properties.getProperty("url");
			 String username =properties.getProperty("username");
			 String password =properties.getProperty("password");
			
			
			// 1. load driver class
			Class.forName(Driver);

			// 2. establish connection
			Connection con = DriverManager.getConnection(url, username, password);

			// 3. prepare sql statment

//			PreparedStatement stmt = con.prepareStatement(
//					"create table product (Product_Id int , Product_description varchar(256) ,Product_name varchar(100) ,Product_price int ,Product_quantity int)");

			//int i = stmt.executeUpdate();
			
			String createCardQuery = "CREATE TABLE card_table ("
                    + "card_Id INT NOT NULL AUTO_INCREMENT, "
                    + "user_Id INT NOT NULL, "
                    + "total_amount DECIMAL(10, 2) NOT NULL, "
                    + "PRIMARY KEY (card_id), "
                    + "FOREIGN KEY (user_Id) REFERENCES user(user_Id)"
                    + ")";
			PreparedStatement stmt = con.prepareStatement(createCardQuery);
			int executeUpdate = stmt.executeUpdate();
			System.out.println("Card Tabel created");

			System.out.println("Done ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
