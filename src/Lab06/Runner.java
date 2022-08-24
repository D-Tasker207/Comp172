package Lab06;

public class Runner {
	public static void main(String[] args) {
		TelecomAccount account1 = new TelecomAccount("Jane", "Smith", "708-172-1328", true, 0.05, 6.50);
		TelecomAccount account2 = new TelecomAccount("Adam", "Jones", "421-123-1523", true, 0.05, 1.50);
				
		//testing account generation
		System.out.println("Should be null and null: DataPlan: " + account1.getDataPlan() + ", VoicePlan: " + account1.getVoicePlan());
		account1.createPlan("voicePlan", 25.0);
		System.out.println("Should be null and not null: DataPlan: " + account1.getDataPlan() + ", VoicePlan: " + account1.getVoicePlan());
		account1.createPlan("dataPlan", 10.0);
		System.out.println("Should be not null and not null: DataPlan: " + account1.getDataPlan() + ", VoicePlan: " + account1.getVoicePlan());
		
		//testing with different federalFee values (6.50, 1.50)
		account1.calculateMonthlyCost();
		System.out.println("\nAccount1 should be 39.58, actual: "+ account1.getTotalCost());
		
		account2.createPlan("dataPlan", 10.0); account2.createPlan("voicePlan", 25.0); //creating plans for account2
		account2.calculateMonthlyCost();
		System.out.println("Account2 should be 34.58, actual: "+ account2.getTotalCost());
		
		//testing with different tax rates (0.15, 0.05)
		account1 = new TelecomAccount("Jane", "Smith", "708-172-1328", true, 0.15, 3.50);
		account2 = new TelecomAccount("Adam", "Jones", "421-123-1523", true, 0.05, 3.50);
		account1.createPlan("dataPlan", 10.0); account1.createPlan("voicePlan", 25.0); //creating plans for account1
		account2.createPlan("dataPlan", 10.0); account2.createPlan("voicePlan", 25.0); //creating plans for account2
		account1.calculateMonthlyCost(); account2.calculateMonthlyCost(); //Calculate monthly costs for both accounts
		System.out.println("\nAccount1 should be 39.73, actual: " + account1.getTotalCost());
		System.out.println("Account2 should be 36.58, actual: " + account2.getTotalCost());
		
		//testing with different plan costs (10 and 25, 7 and 40)
		account1 = new TelecomAccount("Jane", "Smith", "708-172-1328", true, 0.15, 3.50);
		account2 = new TelecomAccount("Adam", "Jones", "421-123-1523", true, 0.05, 3.50);
		account1.createPlan("dataPlan", 10.0); account1.createPlan("voicePlan", 25.0); //creating plans for account1
		account2.createPlan("dataPlan", 7.0); account2.createPlan("voicePlan", 40.0); //creating plans for account2
		account1.calculateMonthlyCost(); account2.calculateMonthlyCost(); //Calculate monthly costs for both accounts
		System.out.println("\nAccount1 should be 39.73, actual: " + Math.round(account1.getTotalCost()*100)/100.0);
		System.out.println("Account2 should be 47.92, actual: " + Math.round(account2.getTotalCost()*100)/100.0);
	}
}
