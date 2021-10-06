package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shop.controller.InputContoller;
import shop.model.Product;
import shop.model.ProductShoppingCart;

public class Start {
	
	public static Scanner scanner;
	private List<Product> inventoryProducts;
	private List<Product> selectedProducts;

	
	public Start() {
		

		inventoryProducts = new ArrayList<Product>();
		InputContoller.scanner = new Scanner(System.in);
		selectedOption();
		menuShoppingCart();

	}


		
		private void selectedOption() {
			System.out.println("ADD - add item to inventory");
			System.out.println("END - Closes inventory stages");
		
				Scanner s = new Scanner(System.in);
				String input = s.nextLine();
				String[] splited = input.split(" ");
				if(splited[0].trim().toLowerCase().equals("add")) {

					addItemToInventory(splited);
					selectedOption();
				
				}
				
				if (splited[0].trim().toLowerCase().equals("end")) {
					return;
				} else {
					
				}
			
			
		}


	private void addItemToInventory(String[] splited) {
		Product newProduct = new Product();
		try {
			newProduct.setSku(Integer.parseInt(splited[1]));
		} catch (Exception e) {
			System.out.println("SKU is a number, try again");
		}
		newProduct.setName(splited[2]);
		try {
			newProduct.setQuantity(Integer.parseInt(splited[3]));
		} catch (Exception e) {
			System.out.println("Quantity is a number, try again");
		}
		try {
			newProduct.setPrice(Double.parseDouble(splited[4]));
		} catch (Exception e) {
			System.out.println("Price is a decimal number, try again");
		}
		inventoryProducts.add(newProduct);
	}



	
	
	private void menuShoppingCart() {
			selectedOptionShoppingCart();
			
		}
	
	
	/* **************************************************** */
	
	
	private void selectedOptionShoppingCart() {
		System.out.println("ADD - Adds an item in the current shopping cart");
		System.out.println("REMOVE - Removes an item from the shopping cart");
		System.out.println("CHECKOUT - Print all items");
		System.out.println("END - Closes the stage and exits the program");
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String[] splitedCart = input.split(" ");
		if(splitedCart[0].trim().toLowerCase().equals("add")) {

			addItemToShoppingCart(splitedCart);
			selectedOptionShoppingCart();
		
		}
		if (splitedCart[0].trim().toLowerCase().equals("remove")) {
			remove();
			selectedOptionShoppingCart();
		}
		if (splitedCart[0].trim().toLowerCase().equals("checkout")) {
			checkout();
			selectedOptionShoppingCart();
		}
		if (splitedCart[0].trim().toLowerCase().equals("end")) {
			 System.exit(0);
		} else {
			System.out.println("Error, choose option");
		}
		
	}


	private void remove() {
		if(selectedProducts.isEmpty()) {
			System.out.println("is empty");
		}else {
			for(int i = 0; i < selectedProducts.size(); i++) {
				selectedProducts.remove(i);
			}
		}
		
	}



	private void addItemToShoppingCart(String[] splitedCart) {
		int tempSKU = 0;
		int tempQuantity = 0;
		
		Product newProduct = new Product();
		selectedProducts = new ArrayList<>();
		
		try {
			tempSKU = Integer.parseInt(splitedCart[1]);
		} catch (Exception e) {
			
		}
		
		try {
			tempQuantity  = Integer.parseInt(splitedCart[2]);
		} catch (Exception e) {
			
		}
		for (Product p : inventoryProducts) {
			if (tempSKU == p.getSku()) {
				selectedProducts.add(newProduct);
			} else {
				System.out.println("The product is not in the database");
			}
			
		}
		
		
		
	}




// treba dodati total
	private void checkout() {
		if(selectedProducts.isEmpty()) {
			System.out.println("is empty");
		}else {
			
			Product p;
			for(int i = 0; i < selectedProducts.size(); i++) {
				p = selectedProducts.get(i);
				double sum=0;
				//double total=0;
				sum= (p.getQuantity()*p.getPrice());
				//total = total * p.getQuantity();
				System.out.println(p.getName() + " " +  p.getQuantity() + " X " + p.getPrice() + " = " + sum);
				//System.out.println(total);
		}
		
	}
	}

	public static void main(String[] args) {
		new Start();
		
	}

}
