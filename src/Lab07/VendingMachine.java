package Lab07;

import java.util.ArrayList;

/**
 * 
 * @author duncantasker
 *
 */
public class VendingMachine {
	
	private double balance;
	private ArrayList<Product> inventory;
	
	/**
	 * constructor, init balance and inventory
	 */
	public VendingMachine() {
		balance = 0.0;
		inventory = new ArrayList<Product>();
	}
	
	/**
	 * 
	 * @param name name of product
	 * @param price price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {
		inventory.add(new Product(name, price, quantity));
	}
	
	/**
	 * 
	 * @param coin type of coin inserted
	 */
	public void insertCoin(String coin) {
		balance += Coin.value(coin);
	}
	
	/**
	 * 
	 * @return remainder of balance and sets balance to 0
	 */
	public double makeChange() {
		double change = balance;
		balance = 0;
		return change;
	}
	
	/**
	 * 
	 * @param selection 1 + index of selection from vending machine
	 * @return true if enough money for transaction, false if not enough money for transaction
	 */
	public boolean buy(int selection) {
		if ((balance - inventory.get(selection-1).getPrice() >= 0) && (inventory.get(selection-1).getQuantity() > 0)) {
			inventory.get(selection-1).decrementQuantity();
			balance -= inventory.get(selection-1).getPrice();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return string representation of inventory
	 */
	public String getInventory() {
		String strInventory = "";
		for (int i = 0; i < inventory.size(); i++) {
			strInventory += inventory.get(i).toString() + "\n";
		}
		return strInventory;
	}
	
	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
}
