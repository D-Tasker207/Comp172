package Lab09;

public class ProvidedTestSuite {
	public static void main(String[] args) {
		StandardCreditCard card1 = new StandardCreditCard("Mary", "Smith", "12345");
		System.out.println("Standard Credit Card");
		System.out.println("$100 purchase result (should be true): " + card1.makePurchase(100) + ", balance is (should be 100): " + card1.getBalance());
		System.out.println("$5000 purchase result (should be false): " + card1.makePurchase(5000) + ", balance is (should be 100): " + card1.getBalance());
		System.out.println("$90 payment result (should be true): " + card1.makePayment(90) + ", interest is (should be 1.5): "+ card1.getInterest() + ", balance is (shoule be 11.5): " +card1.getBalance());
		
		GoldCard card2 = new GoldCard("Mary", "Smith", "23456");
		System.out.println("\n\nGold Card");
		System.out.println("$100 purchase result (should be true): " + card2.makePurchase(100) + ", balance is (should be 100): " + card2.getBalance());
		System.out.println("$20000 purchase result (should be true): " + card2.makePurchase(20000) + ", balance is (should be 100): " + card2.getBalance());
		System.out.println(card2.getRewardPoints() + " should be 100");
		System.out.println("$100 purchase result (should be true): " + card2.makePurchase(100) + ", balance is (should be 200): " + card2.getBalance());
		System.out.println(card2.getRewardPoints() + " should be 200");
		System.out.println("$100 payment result (should be true): " + card2.makePayment(100) + ", interest is (should be 10): "+ card2.getInterest() + ", balance is (should be 110): " +card2.getBalance()); 
		
		LastChanceCard card3 = new LastChanceCard("Mary", "Smith", "34567");
		System.out.println("\n\nLast Chance Card");
		System.out.println("$100 purchase result (should be true): " + card3.makePurchase(100) + ", balance is (should be 100): " + card3.getBalance());
		System.out.println("$1000 purchase result (should be false): " + card3.makePurchase(1000) + ", balance is (should be 100): " + card3.getBalance());
		System.out.println("$90 payment result (should be true): " + card3.makePayment(90) + ", interest is (should be 2.5): "+ card3.getInterest() + ", balance is (shoule be 12.5): " +card3.getBalance());
		System.out.println("$12.5 payment result (should be true): " + card3.makePayment(12.5) + ", balance is (shoule be 0): " +card3.getBalance());
		
		for(int i = 0; i < 4; i++) {
			System.out.println("$100 purchase result (should be true): " + card3.makePurchase(100) + ", balance is (should be 100): " + card3.getBalance());
			System.out.println("$100 payment result (should be true): " + card3.makePayment(100) + ", balance is (shoule be 0): " +card3.getBalance());

		}
		
		System.out.println("\ninterest rate: " + card3.getInterestRate() + " should be 0.2");
		System.out.println("credit limit: " + card3.getCreditLimit() + " should be 2000");
		System.out.println("$100 purchase result (should be true): " + card3.makePurchase(100) + ", balance is (should be 100): " + card3.getBalance());
		System.out.println("$100 payment result (should be true): " + card3.makePayment(100) + ", balance is (shoule be 0): " +card3.getBalance());
		System.out.println("interest rate: " + card3.getInterestRate() + " should be 0.2");
		System.out.println("credit limit: " + card3.getCreditLimit() + " should be 2000");


		
		
	}
}
