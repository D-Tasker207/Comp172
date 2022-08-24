package Lab01;
import java.util.Scanner;

public class lab01p2 {
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name :: ");
		
		String userName = scan.nextLine();
		scan.close();
		
		System.out.println("Hello " + userName + "!");
	}
}

