package Lab06;

public class ProvidedTests {

	public static void main(String[] args) {
		TelecomAccount account1 = new TelecomAccount("Jane", "Doe", "123-456-111", false, 5, 50);
		account1.createPlan("voiceplan", 49);
		account1.calculateMonthlyCost();
		System.out.println("Total cost (should be 101.45): " + account1.getTotalCost());
	}
}
