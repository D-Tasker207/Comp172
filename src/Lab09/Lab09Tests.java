package Lab09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Lab09Tests {

	StandardCreditCard creditcard = new StandardCreditCard("card no.", "firstName", "lastName");
	
	@Test
	void testPurchase() {
		assertTrue(creditcard.makePurchase(1000));//purchase amount within credit limit
		assertFalse(creditcard.makePurchase(10000));//purchase above amount credit limit
		assertFalse(creditcard.makePurchase(-10));//purchase amount below zero
	}
	
	@Test
	void testPayment() {
		creditcard.setBalance(1000);//set balance to starting value for testing
		
		assertTrue(creditcard.makePayment(250));//payment allowed	
		
		creditcard.setBalance(1000);
		assertTrue(creditcard.makePayment(1000));//pay the entire balance off at once
		
		creditcard.setBalance(1000);
		assertFalse(creditcard.makePayment(0));//pay nothing
		assertFalse(creditcard.makePayment(-10));//pay negative amount
		assertFalse(creditcard.makePayment(1500));//pay more than entire balance
	}
	
	@Test
	void testInterest() {
		creditcard.setBalance(1000);//set balance to starting value
		creditcard.makePayment(250);//make partial payment
		assertEquals(862.5, creditcard.getBalance(), 0.001);//interest calculated on remaining balance
		
		creditcard.setBalance(1000);//set balance to starting value
		creditcard.makePayment(1000);//make complete payment
		assertEquals(0, creditcard.getBalance());//interest should be 0 since there is no balance remaining
	}
	
	@Test
	void testSettersandGetters() {
		creditcard.setFirstName("Fred");
		assertEquals("Fred", creditcard.getFirstName());
		
		creditcard.setLastName("Jones");
		assertEquals("Jones", creditcard.getLastName());
		
		creditcard.setCardNumber("8012");
		assertEquals("8012", creditcard.getCardNumber());
		
	}
	
	/*
	 * Testing Gold Card
	 */
	
	GoldCard goldcard = new GoldCard("card no.", "firstName", "lastName");
	
	@Test
	void testGoldPurchase() {
		assertFalse(goldcard.makePurchase(-1));//invalid purchase amount
		}

	@Test
	void testRewardPoints() {
		goldcard.setRewardPoints(0);//clearing any reward points
		goldcard.makePurchase(250.25);//make purchase to generate reward points
		assertEquals(250, goldcard.getRewardPoints());//check number of points generated matches purchase amount
		
		goldcard.makePurchase(768.39);//make additional purchase
		assertEquals(1018, goldcard.getRewardPoints());//check number of points generated matches adds correctly
	}

	/*
	 * Testing Last Chance Card
	 */
	
	LastChanceCard lastcard = new LastChanceCard("card no.", "firstName", "lastName");

	@Test
	void testLastChancePayment() {
		
		assertFalse(lastcard.makePayment(-10));//invalid
	}
	
	@Test
	void testPayOffStreak() {
		lastcard.setBalance(10);
		lastcard.makePayment(5);
		assertEquals(0, lastcard.getPayOffStreak());
		
		lastcard.setPayOffStreak(0);//clear payoff streak
		assertEquals(0.25, lastcard.getInterestRate());//check interest rate
		assertEquals(1000, lastcard.getCreditLimit());//check interest rate
		
		for(int i = 0; i < 5; i++) {//for loop to set payOffStreak to 5
			lastcard.setBalance(500);
			lastcard.makePayment(500);
		}
		assertEquals(5, lastcard.getPayOffStreak());//check payOffStreak
		
		assertEquals(0.20, lastcard.getInterestRate());//check interestRate
		assertEquals(2000, lastcard.getCreditLimit());//check creditLimit
	}
}
