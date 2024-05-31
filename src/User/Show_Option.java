package User;

import java.util.Scanner;

public class Show_Option  extends Roles{

	public static Scanner sc = new Scanner(System.in);

	

	public void selction() {

		System.out.println("Select Role. ");
		int choice = sc.nextInt();

		System.out.println("Enter your choice. ");
		int choice1 = sc.nextInt();

		switch (choice) {

		case 1: {
			System.out.println("User Operation");

			switch (choice1) {

			case 1: {
				userRegistration();
				break;
			}
			case 2:{
				userLogin();
               break;
			}
			case 3:{
				userviewProductitemasSortedOrder();
				break;
			}
			case 4:{
				buyProduct();
				break;
			}
			case 5:{
				viewCart();
				break;
			}
			case 6:{
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
		String username= sc.next();
		
		System.out.println("Total Bill Amount");
		
	}

	public static  void viewCart() {
	
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

	public static void userLogin() {
		System.out.println(" Enter the username >> ");
		String username = sc.next();

		System.out.println(" Enter the password >> ");
		String password = sc.next();

	}

	public static void userRegistration() {
		System.out.println("Enter the first name >> ");
		String name = sc.next();

		System.out.println("Enter the last name >> ");
		String lastname = sc.next();

		System.out.println("Enter the username >> ");
		String username = sc.next();

		System.out.println("Enter the password >> ");
		String password = sc.next();

		System.out.println("Enter the city >> ");
		String city = sc.next();

		System.out.println("Enter the mail id >> ");
		String mail_id = sc.next();

		System.out.println(" Enter the mobile number >> ");
		int mobile_No = sc.nextInt();

	}



}
