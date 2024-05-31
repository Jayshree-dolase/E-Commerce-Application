package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class ProductTable {
	public static Scanner sc = new Scanner(System.in);
//	public static String Driver;
//	public static String url;
//	public static String username;
//	public static String password;
//	public static final String Driver = "com.mysql.cj.jdbc.Driver";
//	public static final String url = "jdbc:mysql://localhost:3306/ecom";
//	public static final String username = "root";
//	public static final String password = "root";
//	public static void getCredential() {
//		
//		try {
//			Properties properties = new Properties();
//			FileInputStream inputStream = new FileInputStream(new File(" "));
//			
//			properties.load(inputStream);
//			 String Driver =properties.getProperty("Driver");
//			 String url =properties.getProperty("url");
//			 String username =properties.getProperty("username");
//			 String password =properties.getProperty("password");
//			
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//	}

		
	public void createProduct() { }
		//try {
//			Properties properties = new Properties();
//			FileInputStream inputStream = new FileInputStream(new File(" "));
//			properties.load(inputStream);
//			 String Driver =properties.getProperty("Driver");
//			 String url =properties.getProperty("url");
//			 String username =properties.getProperty("username");
//			 String password =properties.getProperty("password");
//			
//			
//			// 1. load driver class
//			Class.forName(Driver);
//
//			// 2. establish connection
//			Connection con = DriverManager.getConnection(url, username, password);
//
//			// 3. prepare sql statment
//
//			PreparedStatement stmt = con.prepareStatement(
//					"create table product (Product_Id int , Product_description varchar(256) ,Product_name varchar(100) ,Product_price int ,Product_quantity int)");
//
//			int i = stmt.executeUpdate();
//
//			System.out.println("Done ");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public   void insertProduct(int Product_Id, String Product_description, String Product_name, int Product_price,
			int Product_quantity) {
		try {
			Properties properties = new Properties();
			FileInputStream inputStream = new FileInputStream(new File("D:\\Jayshree_Workspace-1.8\\E-Commerce Application\\Resources\\config.properties"));
			properties.load(inputStream);
			
			 String Driver =properties.getProperty("Driver");
			 String url =properties.getProperty("url");
			 String username =properties.getProperty("username");
			 String password =properties.getProperty("password");
			
			Class.forName(Driver);

			Connection con = DriverManager.getConnection(url,username,password);

			PreparedStatement stmt = con.prepareStatement("insert into product (Product_Id,Product_description,Product_name,Product_price,Product_quantity)"+" values (?,?,?,?,?)");

			stmt.setInt(1, Product_Id);
			stmt.setString(2, Product_description);
			stmt.setString(3, Product_name);
			stmt.setInt(4, Product_price);
			stmt.setInt(5, Product_quantity);

			int i = stmt.executeUpdate();

			System.out.println("Data inserted successfully.");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		ProductTable producttable = new ProductTable();

		// producttable.createProduct();
		
		for(int i=0;i<=10;i++) {
		System.out.println("Enetr  Product_Id : ");
		int Product_Id = sc.nextInt();

		System.out.println("Enetr Product description : ");
		String Product_description = sc.next();

		System.out.println("Enetr Product name : ");
		String Product_name = sc.next();

		System.out.println("Enetr  the price of Product  : ");
	    int  Product_price = sc.nextInt();

		System.out.println("Enetr the quantity of the Product  : ");
		int Product_quantity = sc.nextInt();
		
		
		producttable.insertProduct(Product_Id,Product_description,Product_name,Product_price,Product_quantity);
		
		}
	}

}
