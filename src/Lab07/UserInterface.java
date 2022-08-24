package Lab07;


import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine();
        int request = 0;
        double balance;
        
        vendingMachine.addProduct("Dr Pepper", 1.25, 3);
        vendingMachine.addProduct("Snapple", 1.00, 2);
        vendingMachine.addProduct("Water", 0.80, 1);

         do {

            System.out.println("\nWelcome to Soda Machine 2.0");
            System.out.println(" 1) Deposit Coins");
            System.out.println(" 2) Buy Drink");
            System.out.println(" 3) Get Change");
            System.out.println(" 4) Print Inventory");
            balance = vendingMachine.getBalance();
            System.out.printf("Your balance is %5.2f\n", balance);
            System.out.println("\nwhat would you like to do? ");
            request = scan.nextInt();

            if (request == 1) {
                String coinInserted = "";
                do {
                    System.out.println("Please enter coin type 'nickel' or 'dime' or 'quarter' or 'next' when ready: ");
                    coinInserted = scan.next();
                    vendingMachine.insertCoin(coinInserted);
                    balance = vendingMachine.getBalance();
                    System.out.printf("\nYour balance is %5.2f\n", balance);
                } while (!coinInserted.equalsIgnoreCase("next"));

            } else if (request == 2) {
                int selection;
                do {
                    System.out.println("Please make a selection: ");
                    System.out.println("1: Dr. Pepper: $1.25");
                    System.out.println("2: Snapple: $1.00");
                    System.out.println("3: Water: $0.80");
                    selection = scan.nextInt();
                } while (selection < 1 || selection > 3);

                if (vendingMachine.buy(selection)) {
                    System.out.println("Enjoy your drink!");
                }
                else {
                    System.out.println("Insufficient funds or selection out of stock");
                }
            }
            else if (request == 3  ) {
                if(vendingMachine.getBalance() > 0){
                    System.out.printf("Please find %5.2f in the coin return\n", vendingMachine.makeChange());
                }
                else {
                    System.out.println("No change");
                }
            }

            else if (request == 4){
                String inventory = vendingMachine.getInventory();
                System.out.print(inventory);
            }
            
        }while (request >= 1 && request <= 4); //while request
         scan.close();
    }//main
}//class
