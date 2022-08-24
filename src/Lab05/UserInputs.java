package Lab05;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.lang.Math;

public class UserInputs {
	
	public static void main (String[] args) {
		//three arrays of valid inputs for each of the non-numeric variables
		String[] validColors = {"GS", "P1", "P2", "P3"};
		String[] validPaperTypes = {"GLOSSY", "MATTE"};
		String[] validSidedness = {"DOUBLE", "SINGLE"};
				
		Scanner scan = new Scanner(System.in);
		LinkedList<PrintOrder> orders = new LinkedList<PrintOrder>(); //Create arraylist to store the print orders
		
		boolean doneWithUserInput = false;
		while(!doneWithUserInput){
			//create local variables for each print job, reset to 0 after job is submitted
			int pageCount = 0;
			String colorType = "";
			String paperType = "";
			String sidedType = "";
			
			while(!(pageCount > 0)){ //while page count is less than zero
				System.out.print("Enter Number of Pages :: ");
				pageCount = scan.nextInt();
			}
			
			while(!(Arrays.asList(validPaperTypes).contains(paperType.toUpperCase()))){ //while papertype is not equal to a member of validPaperTypes
				System.out.print("Enter paper type " + Arrays.toString(validPaperTypes) + " :: ");
				paperType = scan.next();
			}
			
			while(!(Arrays.asList(validColors).contains(colorType.toUpperCase()))){ //while colorType is not equal to a member of validColors
				System.out.print("Enter color type " + Arrays.toString(validColors) + " :: ");
				colorType = scan.next();
			}
			
			while(!(Arrays.asList(validSidedness).contains(sidedType.toUpperCase()))){ //while sidedType is not equal to a member of validSidedness
				System.out.print("Enter single or double sided printing " + Arrays.toString(validSidedness) + " :: ");
				sidedType = scan.next();
			}
			
			orders.add(new PrintOrder(colorType, paperType, sidedType, pageCount)); //add order to arraylist of all orders
			orders.get(orders.size()-1).determineTotalCost();
			System.out.println("Print order " + (orders.size()) + " Total Cost is " + Math.round(orders.get(orders.size()-1).getTotalCost()*100)/100.0 + " cost per page is: " + Math.round(orders.get(orders.size()-1).getCostPerPage()*100)/100.0);


			
			System.out.print("\nAre there more print orders? (y/n) :: "); //ask user if there are more orders, break variable if input is n
			char isFinished = scan.next().charAt(0);
			if (Character.toLowerCase(isFinished) == 'n'){
				doneWithUserInput = true;
			}
		}
		scan.close();
		
		for (int i = 0; i < orders.size(); i++){ //iterate through arraylist and pring cost per page and total cost for each order
				System.out.println("Print order " + (i+1) + " Total Cost is " + Math.round(orders.get(i).getTotalCost()*100)/100.0 + " Cost per page is: " + Math.round(orders.get(i).getCostPerPage()*100)/100.0);
		}
	}
}

/*
 * Test cases:
 * 
 * Testing papertype:
 * 2, glossy, gs, single: should be 0.40 total cost, 0.20 cost per page 
 * 2, matte, gs, single: should be 0.30 total cost, 0.15 cost per page
 * 
 * Testing colors
 * 3, glossy, p3, single: should be 2.25 total cost, 0.75 cost per page
 * 3, glossy, p2, single: should be 1.65 total cost, 0.55 cost per page
 * 3, glossy, p1, single: should be 1.20 total cost, 0.40 cost per page
 * 3, glossy, gs, single: should be 0.60 total cost, 0.20 cost per page
 * 
 * Testing Sidedness
 * 2, matte, p1, single: should be 0.70 total cost, 0.35 cost per page
 * 2, matte, p1, double: should be 1.25 total cost, 0.63 cost per page
 * 
 * Testing pagecount
 * 1, matte, p2, single: should be 0.50 total cost, 0.50 cost per page
 * 4, matte, p2, single: should be 2.00 total cost, 0.50 cost per page
 * 10, matte, p2, single: should be 5.00 total cost, 0.50 cost per page 
 * 
 * Boundary Tests
 * 0, matte, p2, single: no output, loops requsting number
 * 1, semigloss, gs, double: no output, loops requesting paper type
 * 1, matte, p3, single: no output, loops requesting color type
 * 1, matte, p2, triple: no output, loops requesting sided type
 * 
*/
