package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shop.controller.InputContoller;
import shop.model.Product;

public class Start {
	
	public static Scanner scanner;
	private List<Product> product;
	//private List<Product> selectedProducts;

	
	public Start() {
		

		product = new ArrayList<Product>();
		InputContoller.scanner = new Scanner(System.in);
		System.out.println("ADD - add item to inventory");
		System.out.println("END - Closes inventory stages");
		selectedOption();
		menuShoppingCart();

	}


		
		private void selectedOption() {
		
		
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

			/*if(InputContoller.addOrEnd("Choose between add or end", "")) {
				
				addItemToInventory();
				
			}if(InputContoller.addOrEnd("Choose between add or end", "you didnt choose between add or end")) {
				
				menuShoppingCart();
			}
		}*/
	
	private void addItemToInventory(String[] splited) {
		try {
			int sku = Integer.parseInt(splited[1]);
		} catch (Exception e) {
			System.out.println("SKU nije broj probajte ponovo");
			
		}
		

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
