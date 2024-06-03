package DataBase;

public class Product implements Comparable<Product> {
	private int  Product_Id;
	private String Product_name;
	private String Product_description;
	private int Product_price;
	private  int Product_quantity;
	
	

	public int getProduct_Id() {
		return Product_Id;
	}


	public String getProduct_name() {
		return Product_name;
	}


	public String getProduct_description() {
		return Product_description;
	}


	public int getProduct_price() {
		return Product_price;
	}


	public int getProduct_quantity() {
		return Product_quantity;
	}


public Product(int product_Id, String product_name, String product_description, int product_price,
			int product_quantity) {
		super();
		Product_Id = product_Id;
		Product_name = product_name;
		Product_description = product_description;
		Product_price = product_price;
		Product_quantity = product_quantity;
	}


	@Override
	public String toString() {
		return "Product [Product_name=" + Product_name + ", Product_description=" + Product_description
				+ ", Product_price=" + Product_price + ", Product_quantity=" + Product_quantity + "]";
	}


	@Override
	public int compareTo(Product product) {
		if (Product_price == product.Product_price) {
			return 0;
		}else if(Product_price > product.Product_price) {
			
		return 1;
		}else {
			return -1;
		}
	}
	
	
}
