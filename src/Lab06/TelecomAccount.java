package Lab06;
import Lab03.PhonePlan;

public class TelecomAccount {

	String firstName, lastName, phoneNumber;
	boolean contractStatus;
	double taxRate, federalFee, totalCost;
	PhonePlan voicePlan, dataPlan;
	
	/**
	 * 
	 * @param firstNameIn
	 * @param lastNameIn
	 * @param phoneNumberIn
	 * @param contractStatusIn
	 * @param taxRateIn
	 * @param federalFeeIn
	 */
	public TelecomAccount(String firstNameIn, String lastNameIn, String phoneNumberIn, boolean contractStatusIn, double taxRateIn, double federalFeeIn) {
		firstName = firstNameIn;
		lastName = lastNameIn;
		phoneNumber = phoneNumberIn;
		contractStatus = contractStatusIn;
		taxRate = taxRateIn;
		federalFee = federalFeeIn;
		totalCost = 0.0;
	}
	
	/**
	 * 
	 * @param planName
	 * @param originalCost
	 */
	public void createPlan(String planName, double originalCost){
		if (planName.equalsIgnoreCase("voicePlan") && voicePlan == null){
			voicePlan = new PhonePlan(originalCost, contractStatus);
		}
		else if (planName.equalsIgnoreCase("dataPlan") && dataPlan == null){
			dataPlan = new PhonePlan(originalCost, contractStatus);
		}
	}
	
	/**
	 * 
	 */
	public void calculateMonthlyCost(){
		if (voicePlan != null){
			voicePlan.calculateCost(taxRate);
			totalCost += voicePlan.getFinalCost();
		}
		if (dataPlan != null){
			dataPlan.calculateCost(taxRate);
			totalCost += dataPlan.getFinalCost();
		}
		totalCost += federalFee;
	}
	
	/**
	 * 
	 * @return first name of client
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return last name of client
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @return client phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @return voice plan object
	 */
	public PhonePlan getVoicePlan() {
		return voicePlan;
	}

	/**
	 * 
	 * @return data plan object
	 */
	public PhonePlan getDataPlan() {
		return dataPlan;
	}
	
	/**
	 * 
	 * @return total cost
	 */
	public double getTotalCost(){
		return totalCost;
	}
}

