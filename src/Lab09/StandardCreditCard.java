package Lab09;

/**
 * 
 * @author duncantasker
 *
 */

public class StandardCreditCard {
	private String cardNumber;
	private String firstName;
	private String lastName;
	private double interestRate;
	private double creditLimit;
	private double balance;
	private double interest;
	
	/**
	 * 
	 * @param cardNumber the credit card number for user
	 * @param firstName user's first name
	 * @param lastName user's last name
	 */
	public StandardCreditCard(String cardNumber, String firstName, String lastName) {
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.interestRate = 0.15;
		this.creditLimit = 5000;
		this.balance = 0;
	}
	
	/**
	 * Override method for child classes
	 * 
	 * @param purchaseAmount 
	 * @return true if purchase is valid, false if purchase is not valid
	 */
	public boolean makePurchase(double purchaseAmount){
		return purchaseHandler(purchaseAmount);
	}
	
	/**
	 * Body for makePurchase
	 * 
	 * @param purchaseAmount
	 * @return  true if purchase is valid, false if purchase is not valid
	 */
	protected boolean purchaseHandler(double purchaseAmount) {
		if (((balance + purchaseAmount) <= creditLimit) && (purchaseAmount > 0)){
			balance += purchaseAmount;
			return true;
		}
		else return false;
	}
	
	/**
	 * Override method for child classes
	 * 
	 * @param paymentAmount
	 * @return true if payment if valid, false if payement is not valid
	 */
	public boolean makePayment(double paymentAmount) {
		return paymentHandler(paymentAmount);
	}
	
	/**
	 * Body for makePayment
	 * 
	 * @param paymentAmount
	 * @return true if payment if valid, false if payement is not valid
	 */
	protected boolean paymentHandler(double paymentAmount) {
		if ((paymentAmount > 0) && (paymentAmount <= balance)) {
			balance -= paymentAmount;
			calculateInterest();
			return true;
		}
		else return false;
	}
	
	/**
	 * Calculate interest on the current balance
	 */
	protected void calculateInterest() {
		interest = interestRate * balance;
		balance += interest;
	}

	protected void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	protected void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterest() {
		return interest;
	}

	protected void setInterest(double interest) {
		this.interest = interest;
	}
	
	
}
