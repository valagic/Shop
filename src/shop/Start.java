package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shop.controller.InputContoller;
import shop.model.Product;

public class Start {
	
	public static Scanner scanner;
	private List<Product> inventoryProducts;
	//private List<Product> selectedProducts;

	
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
		System.out.println("ADD - add item to inventory");
		System.out.println("REMOVE - Removes an item from the shopping cart");
		System.out.println("CHECKOUT - Print all items");
		System.out.println("END - Closes the stage and exits the program");
			
			
		}
	
	public static void main(String[] args) {
		new Start();
		
	}

}
