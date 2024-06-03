package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRegistration {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/ecom";
	public static final String username = "root";
	public static final String password = "root";
	public static Scanner sc = new Scanner(System.in);


public void userRegistration() {
		
		ArrayList<String> user= new ArrayList<String>();
	System.out.println("Enter the first name >> ");
		String first_Name = sc.next();
		user.add(first_Name);
		
		System.out.println("Enter the last name >> ");
		String LastName = sc.next();
        user.add(LastName);
        
		System.out.println("Enter the username >> ");
		String user_Name = sc.next();
        user.add(user_Name);

		System.out.println("Enter the password >> ");
		String pass_word = sc.next();
        user.add(pass_word);

		System.out.println("Enter the city >> ");
		String city = sc.next();
        user.add(city);

		System.out.println("Enter the mail id >> ");
		String mail_Id = sc.next();
        user.add(mail_Id);

		System.out.println(" Enter the mobile number >> ");
		String mobile_number = sc.next();
        user.add(mobile_number);

        System.out.println(user);
        
       
		try {
			
			Class.forName(Driver);

			Connection con = DriverManager.getConnection(url,username,password);

			PreparedStatement stmt = con.prepareStatement("insert into user(first_Name,LastName,username,password,city,mail_Id,mobile_number)"+" values (?,?,?,?,?,?,?)");

			
			stmt.setString(1,(String) user.get(0));
			stmt.setString(2,(String) user.get(1));
			stmt.setString(3, (String) user.get(2));
			stmt.setString(4,(String) user.get(3));
			stmt.setString(5,(String) user.get(4));
			stmt.setString(6,(String) user.get(5));
			stmt.setString(7,(String) user.get(6));

			int i = stmt.executeUpdate();

			System.out.println("Data inserted successfully.");

		} catch (Exception e) {

			e.printStackTrace();
		}
} 
}
