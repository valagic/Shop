package shop.model;

public class Product {

	private int sku;
	private String name;
	private int quantity;
	private Double price;
	
	
	public Product() {
		super();
	}
	
	
	
	public Product(int sku, String name, int quantity, Double price) {
		super();
		this.sku = sku;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}



	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

	
}
