package User;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Show_Option extends Roles {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/ecom";
	public static final String username = "root";
	public static final String password = "root";

	public static Scanner sc = new Scanner(System.in);

	public void selction() throws SQLException {

		System.out.println("Select Role. ");
		int choice = sc.nextInt();

//		System.out.println("Enter your choice. ");
//		int choice1 = sc.nextInt();

		switch (choice) {

		case 1: {
			System.out.println("Enter choice User Operation");
			int choice1 = sc.nextInt();
			switch (choice1) {

			case 1: {

				UserRegistration userReg = new UserRegistration();

				userReg.userRegistration();

				break;
			}
			case 2: {
				userLogin userlog = new userLogin();

				userlog.userLogin();
				
				break;
			}
			case 3: {
				userviewProductitemasSortedOrder();
				break;
			}
			case 4: {
				buyProduct();
				break;
			}
			case 5: {
				viewCart();
				break;
			}
			case 6: {
				purchasetheitem();
				break;
			}
			}

			break;
		}

		case 2: {
			System.out.println("Admin Operation");
			break;
		}

		case 3: {
			System.out.println("Guest Operation");
		}

		}
	}

	public static void purchasetheitem() {

		System.out.println("Username >> ");
		String username = sc.next();

		System.out.println("Total Bill Amount");

	}

	public static void viewCart() {

		System.out.println("Product item has been added to cart ");

	}

	public static void buyProduct() {

		System.out.println("Enter the product id to buy product >> ");
		int Product_Id = sc.nextInt();

		System.out.println("Enter the quantity >> ");
		int Product_Quantity = sc.nextInt();

		System.out.println("Do you want to view cart (Yes/No)");

	}

	public static void userviewProductitemasSortedOrder() {
		System.out.println(" Product Id >> ");
		String Product_Id = sc.next();

		System.out.println(" Product Name >> ");
		String Product_Name = sc.next();

		System.out.println(" Product Description >> ");
		String Product_Desc = sc.next();

		System.out.println(" Available Quantity >> ");
		String Available_Qty = sc.next();

		System.out.println(" Available Price >> ");
		String Available_Price = sc.next();

	}

}
