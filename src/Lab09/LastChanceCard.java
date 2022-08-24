package Lab09;

/**
 * 
 * @author duncantasker
 *
 */

public class LastChanceCard extends StandardCreditCard{

	private int payOffStreak;
	
	/**
	 * 
	 * @param cardNumber the credit card number for user
	 * @param firstName user's first name
	 * @param lastName user's last name
	 */
	public LastChanceCard(String cardNumber, String firstName, String lastName) {
		super(cardNumber, firstName, lastName);
		super.setInterestRate(0.25);
		super.setCreditLimit(1000);
		payOffStreak = 0;
	}
	
	@Override
	/**
	 * Overrides makePayment to call checkpayoff on valid payments
	 * 
	 * @param paymentAmount
	 * @return true if payment is valid false if payment is not valid
	 */
	public boolean makePayment(double paymentAmount) {
		boolean isPaymentValid = paymentHandler(paymentAmount);
		if (isPaymentValid) checkPayoff();
		return isPaymentValid;
	}

	/**
	 * checks the payoff streak to see if it is eligible to upgrade
	 */
	public void checkPayoff() {
		if (super.getBalance() == 0){
			payOffStreak++;
		}
		if (payOffStreak >=5) {
			super.setCreditLimit(2000);
			super.setInterestRate(0.20);
		}
	}
	
	protected void setPayOffStreak(int payOffStreak) {
		this.payOffStreak = payOffStreak;
	}
	
	public int getPayOffStreak() {
		return payOffStreak;
	}
}
