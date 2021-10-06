package shop.controller;
import java.util.Scanner;

public class InputContoller {



		public static Scanner scanner;
		
		public static int  loadNumber(String message, String error, int min, int max) {
			int number = 0;
			while(true) {
				System.out.println(message);
				try {

					number = Integer.parseInt(
							scanner.nextLine());
					if (number<min || number>max) {
						System.out.println("the number must not be less " + min
								+ " or greater then " + max);
						continue;
				}
					break;
				}catch (Exception e) {
					System.out.println(error);
				}
			}
			return number;
		}
		
		public static double loadDouble(
				String message, 
				String error, 
				double min, 
				double max) {
			double number=0;
			while(true) {
				System.out.print(message);
				try {
					
					number = Double.parseDouble(
							scanner.nextLine());
					if (number<min || number>max) {
						System.out.println("the number must not be less " + min
								+ " or greater then " + max);
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println(error);
				}
			}
			
			return number;
		}
		
		public static String loadString(String message,String error) {
			String s="";
			while(true) {
				System.out.print(message);
				s = scanner.nextLine();
				if(s.trim().equals("")){
					System.out.println(error);
					continue;
				}
				break;
			}
			
			return s;
		}
		
		public static  boolean addOrEnd (String message, String error) {
			String input = "";
			while(true) {
				System.out.println(message);
				input = scanner.nextLine();
				if(input.trim().toLowerCase().equals("add")) {
					return true;
				}
				if(input.trim().toLowerCase().equals("end")) {
					return false;
				}
				System.out.println(error + "Choose between add or end");
			}
		}
}
	


