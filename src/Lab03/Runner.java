package Lab03;

public class Runner {
	
	public static void main (String[] args) {
		//test case 1 100 dollar original cost, has contract, 0.05 tax per dollar
		PhonePlan plan1 = new PhonePlan(100, true);
		plan1.calculateCost(0.05);
		System.out.println("Should be 10.0, Discount amount = " + plan1.getDiscount());
		System.out.println("Should be 94.5, Total monthly cost = " + plan1.getFinalCost());
		System.out.println("Should be 4.5, Tax amount = " + plan1.getTax());
		
		//test case 2 100 dollar original cost, no contract, 0.05 tax per dollar
		PhonePlan plan2 = new PhonePlan(100, false);
		plan2.calculateCost(0.05);
		System.out.println("\nShould be 0.0, Discount amount = " + plan2.getDiscount());
		System.out.println("Should be 105.0, Total monthly cost = " + plan2.getFinalCost());
		System.out.println("Should be 5.0, Tax amount = " + plan2.getTax());

	}
}

