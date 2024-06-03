package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class CardItem {

	public static void main(String[] args) {
		Properties properties = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("D:\\Velocity_E-commerce\\E-Commerce-Application\\Resources\\config.properties "));
			properties.load(inputStream);
			 String Driver =properties.getProperty("Driver");
			 String url =properties.getProperty("url");
			 String username =properties.getProperty("username");
			 String password =properties.getProperty("password");
			 
			 String createCatdItmequery = "CREATE TABLE card_Item ("
					    + "card_Item_Id INT NOT NULL AUTO_INCREMENT, "
					    + "card_Id INT NOT NULL, "
					    + "Product_Id INT NOT NULL, "
					    + "quantity INT, "
					    + "PRIMARY KEY (card_Item_Id), "
					    + "FOREIGN KEY (card_Id) REFERENCES card_table(card_Id), "
					    + "FOREIGN KEY (Product_Id) REFERENCES product(product_id)"  // Ensure the referenced table and column are correct
					    + ")";
			 
				// 1. load driver class
				Class.forName(Driver);

				// 2. establish connection
				Connection con = DriverManager.getConnection(url, username, password);
				
				PreparedStatement pmst = con.prepareStatement(createCatdItmequery);
				int executeUpdate = pmst.executeUpdate();
				
				System.out.println("CardItemTable created successfully");

			 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
