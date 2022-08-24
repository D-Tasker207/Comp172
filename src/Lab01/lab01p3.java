package Lab01;
import java.util.Scanner;

public class lab01p3 {
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What is your name? ");
		String userName = scan.nextLine();
		scan.close();
		
		Greeter greet = new Greeter(userName);
		greet.generateGreeting();
		System.out.println(greet.getGreeting());
	}
}

