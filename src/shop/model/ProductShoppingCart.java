package shop.model;

public class ProductShoppingCart {

	private String name;
	private int quantity;
	private double price;
	private double total;
	
	public ProductShoppingCart() {
		super();
	}

	public ProductShoppingCart(String name, int quantity, double price, double total) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return this.getName() + this.getQuantity() + this.getPrice();
	}
	
	
	
	
}
