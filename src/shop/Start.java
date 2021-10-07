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
		selectedProducts = new ArrayList<Product>();
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
		if(splited.length!=5) {
			System.out.println("Please type command in format 'ADD 1 ball 5 5.00'");
		}else {
			boolean productExists = false;
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
			
			for(Product p : inventoryProducts) {
				if(p.getSku()==newProduct.getSku()) {
					System.out.println("Product is allready added to inventory");
					productExists = true;
				}
			}
			
			if(!productExists) {
				inventoryProducts.add(newProduct);
			}
		}	
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
			remove(splitedCart);
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


	private void remove(String[] splitedCart) {
		Product selectedProduct = new Product();
		boolean productFound = false;
		if(selectedProducts.isEmpty()) {
			System.out.println("is empty");
		}else {
			for(Product p : selectedProducts) {
				if(p.getSku()==Integer.parseInt(splitedCart[1])) {
					selectedProduct = p;
					productFound = true;
					selectedProducts.remove(p);
					break;
				}
			}
		}
		if(productFound) {
			int index = 0;
			for(Product p : inventoryProducts) {
				if(p.getSku()==selectedProduct.getSku()) {
					p.setQuantity(p.getQuantity()+selectedProduct.getQuantity());
					inventoryProducts.set(index, p);
					break;
				}
				index++;
			}
			
		}
		
	}


	private void addItemToShoppingCart(String[] splitedCart) {
		if(splitedCart.length!=3) {
			System.out.println("Please type command in format 'ADD 1 1'");
		}else {
			int tempSKU = 0;
			int tempQuantity = 0;
			boolean productFound = false;
			
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
					if(p.getQuantity()==0) {
						System.out.println("Unable to add that product to cart because it is currently out of stock.");
					}else {
						if(p.getQuantity()<tempQuantity) {
							System.out.println("There is no enough items in store");
						}else {
							Product newProduct = new Product(tempSKU, p.getName(), tempQuantity, p.getPrice());					
							selectedProducts.add(newProduct);
							int index = inventoryProducts.indexOf(p);
							p.setQuantity(p.getQuantity()-tempQuantity);
							inventoryProducts.set(index, p);
							productFound = true;
						}						
					}
					break;	
				}
				if(!productFound) {
					System.out.println("There is no such product in store");
				}
			}		
		}
		
	}
	
	private void checkout() {
		if(selectedProducts.isEmpty()) {
			System.out.println("is empty");
		}else {
			
			Product pp;
			
			for(int i = 0; i < selectedProducts.size(); i++) {
				pp = selectedProducts.get(i);
				double sum=0;
				
				sum= (pp.getQuantity()*pp.getPrice());
				
				System.out.println(pp.getName() + " " +  pp.getQuantity() + " X " + pp.getPrice() + " = " + sum);
				
			
		}
			
	}
	}


	public static void main(String[] args) {
		new Start();
		
	}

}
