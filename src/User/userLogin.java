package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userLogin {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/ecom";
	public static final String username = "root";
	public static final String password = "root";
	public static Scanner sc = new Scanner(System.in);
	static String User_Name;
	static String Pass_word;
	static String Product_Id;
	static String Product_description;
	static String Product_name;
	static String Product_price;
	static String Product_quantity;

	public void userLogin() throws java.sql.SQLException {

		try {
			Class.forName(Driver);

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement stmt = con.prepareStatement("Select * from user");

			ResultSet rs = stmt.executeQuery();
			List<String> usergetFromTable = new ArrayList<String>();

			while (rs.next()) {

				User_Name = rs.getString(4);
				usergetFromTable.add(User_Name);
//				System.out.println(User_Name);
				Pass_word = rs.getString(5);
				usergetFromTable.add(Pass_word);

//				System.out.println(Pass_word);
			}
			
			List<String> user = new ArrayList<String>();

			System.out.println(" Enter the username >> ");
			String username = sc.next();
            user.add(username);

			System.out.println(" Enter the password >> ");
            String password = sc.next();

			user.add(password);

			System.out.println(user);
	        System.out.println("   Product ID   |     Product Name     |     Description    |       Price     | Quantity\n");

			if ((User_Name.equals(user.get(0))) && Pass_word.equals(user.get(1))) {
               PreparedStatement preparestmt = con.prepareStatement("Select * from product");
               ResultSet resultset = preparestmt.executeQuery();

				    while (resultset.next()) {
                    Product_Id = resultset.getString(1);
					Product_name = resultset.getString(2);
					Product_description = resultset.getString(3);
					Product_price = resultset.getString(4);
                    Product_quantity = resultset.getString(5);
//					System.out.println("<th>"+"Product_Id"+"</th>"       +"<th>"+ "Product_name" +"</th>"+        "<th>"+ "Product_description" +"</th>"+       "<th>"+"Product_price" +"<th>"+        "<th>"+ "Product_quantity"+"</th>");
//				
//					System.out.println(Product_Id         +Product_name                                                                                                                              +Product_description                   +Product_price                  +Product_quantity);

					StringBuilder html = new StringBuilder();

			        
			        html.append("------------------------------------------------------------------------------------------------------------------------------------------\n");
			        
			        html.append(    Product_Id   +"          ,"+      Product_name+"        \"|%-20s|\"          |"   +     Product_description +"            |"   +     Product_price  +"                  |"  +Product_quantity);
 
			        System.out.println(html.toString());
					
				}
			} else {
				System.out.println("Above User is not register please Do Registration and then login.");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
