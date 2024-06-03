package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class ProductTable {
	public static Scanner sc = new Scanner(System.in);
//	public static String Driver;
//	public static String url;
//	public static String username;
//	public static String password;
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/ecom";
	public static final String username = "root";
	public static final String password = "root";
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

		
	public void createProduct() {
		try {
//			Properties properties = new Properties();
//			FileInputStream inputStream = new FileInputStream(new File("D:\\Jayshree_Workspace-1.8\\E-Commerce Application\\Resources\\config.properties"));
//			properties.load(inputStream);
//			 String Driver =properties.getProperty("Driver");
//			 String url =properties.getProperty("url");
//			 String username =properties.getProperty("username");
//			 String password =properties.getProperty("password");
//			
			
			// 1. load driver class
			Class.forName(Driver);

			// 2. establish connection
			Connection con = DriverManager.getConnection(url, username, password);

			// 3. prepare sql statment

			PreparedStatement stmt = con.prepareStatement("create table product (Product_Id int ,Product_name varchar(1000),Product_description varchar(1000),Product_price int,Product_quantity int,primary key(Product_Id))");

			int i = stmt.executeUpdate();

			System.out.println("Done ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public   void insertProduct() throws InterruptedException {
		
//			Properties properties = new Properties();
//			FileInputStream inputStream = new FileInputStream("D:\\Jayshree_Workspace-1.8\\E-Commerce Application\\Resources\\config.properties");
//			properties.load(inputStream);
//			
//			 String Driver =properties.getProperty("Driver");
//			 String url =properties.getProperty("url");
//			 String username =properties.getProperty("username");
//			 String password =properties.getProperty("password");
//			
		try {	
			//List p = new ArrayList();
		List product = new ArrayList();

		for(int i=0;i<2;i++) {
			
			System.out.println("Enetr  Product_Id : ");
			int Product_Id = sc.nextInt();
			product.add(Product_Id);
			
			 sc.nextLine();
				System.out.println("Enetr Product name : ");
				String Product_name = sc.nextLine ();
				product.add(Product_name);

				//Thread.sleep(7000);
				
			System.out.println("Enetr Product description : ");
			String Product_description = sc.nextLine();
			product.add(Product_description);

			//Thread.sleep(7000);

			
			System.out.println("Enetr  the price of Product  : ");
			int Product_price = sc.nextInt();
			product.add(Product_price);

			System.out.println("Enetr the Quantity of the Product  : ");
			int Product_quantity = sc.nextInt();
			product.add(Product_quantity);

			
		    
			System.out.println(product);
			
			Class.forName(Driver);

			Connection con = DriverManager.getConnection(url,username,password);

			PreparedStatement stmt = con.prepareStatement("insert into product (Product_Id,Product_name,Product_description,Product_price,Product_quantity)"+" values (?,?,?,?,?)");

			
stmt.setInt(1,(int) product.get(0));
stmt.setString(2,(String) product.get(1));
stmt.setString(3,(String) product.get(2));
stmt.setInt(4,(int) product.get(3));
stmt.setInt(5,(int) product.get(4));
			
			
			stmt.executeUpdate();

			System.out.println("Data inserted successfully.");
			product.removeAll(product);
		}}catch (Exception e) {

			e.printStackTrace();
		
		}}
	

	public static void main(String[] args) throws InterruptedException {
		
		ProductTable producttable = new ProductTable();

		//producttable.createProduct();
		
		producttable.insertProduct();
		
		}
	}



