package Lab09;

/**
 * 
 * @author duncantasker
 *
 */

public class GoldCard extends StandardCreditCard{
	
	private int rewardPoints;
	
	/**
	 * 
	 * @param cardNumber the credit card number for user
	 * @param firstName user's first name
	 * @param lastName user's last name
	 */
	public GoldCard(String cardNumber, String firstName, String lastName) {
		super(cardNumber, firstName, lastName);
		super.setCreditLimit(20000);
		super.setInterestRate(0.1);
		super.setBalance(0);
		rewardPoints = 0;
	}
	
	
	@Override
	/**
	 * Overrides makePurchase to call calculate reward points on valid payments
	 * 
	 * @param purchaseAmount
	 * @return true if purchase is valid false if purchase is invalid
	 */
	public boolean makePurchase(double purchaseAmount) {
		boolean isPurchaseValid = purchaseHandler(purchaseAmount);
		if (isPurchaseValid) calculateRewardPoints(purchaseAmount);
		return isPurchaseValid;
	}
	
	/**
	 * calculates the reward points based on purchase amount
	 * 
	 * @param transcationAmount
	 */
	private void calculateRewardPoints(double transcationAmount) {
		rewardPoints += transcationAmount;
	}
	
	protected void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
}
