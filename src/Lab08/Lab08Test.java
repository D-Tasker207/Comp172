package Lab08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Lab08Test {
	
	/*
	 * Testing the Kennel class
	 */
	Kennel kennel1 = new Kennel("/Users/duncantasker/eclipse-workspace/COMP172/src/Lab08/kennel.txt", 4);	
	@Test
	void testReadInKennel() {
		
		assertEquals("0 Owner Name: Doe, Credit Card: 1234567, Dog Name: Sassy, Stay Length: 10.0, Cost Per Night: 20.0\n"
				+ "1 Owner Name: Jones, Credit Card: 0987654, Dog Name: Fido, Stay Length: 5.0, Cost Per Night: 45.0\n"
				+ "2 Owner Name: Smith, Credit Card: 67583920, Dog Name: Spot, Stay Length: 1.0, Cost Per Night: 25.0"
				+ "\n", kennel1.getDogInfo());
	}

	@Test
	void testHeadCount() {
		assertEquals(3, kennel1.headcount());
	}
	
	@Test
	void testDogInfo() {
		assertEquals("0 Owner Name: Doe, Credit Card: 1234567, Dog Name: Sassy, Stay Length: 10.0, Cost Per Night: 20.0\n", kennel1.getDogInfo(0));
	}
	
	@Test
	void testAddDog() {
		assertTrue(kennel1.checkInDog("Green", "1234567", "Killer", 3, 10.0));
		
		assertFalse(kennel1.checkInDog("Jackson", "9999999", "Barky", 3, 10.0));
		
	}
	
	@Test
	void testCheckOutDog() {
		assertEquals(25, kennel1.checkOutDog("Smith", "Spot"));
		assertEquals(-1, kennel1.checkOutDog("Brown", "Boo"));
	}
	
	
	/*
	 * Testing the dog class
	 */
	
	Dog dog1 = new Dog("Smith", "123", "Spot", 2, 25);
	Dog dog2 = new Dog("Adam", "123", "Ash", 4.5, 25);
	Dog dog3 = new Dog("Jane", "123", "Itch", 14, 40);
	
	@Test
	void testDog() {
		dog1.calculateTotalCost();
		assertEquals(50, dog1.getTotalCost());
		
		dog2.calculateTotalCost();
		assertEquals(125, dog2.getTotalCost());
		
		dog3.calculateTotalCost();
		assertEquals(560, dog3.getTotalCost());
	}
}
