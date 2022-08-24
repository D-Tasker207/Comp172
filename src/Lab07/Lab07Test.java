package Lab07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Lab07Test {
	
	VendingMachine machine1 = new VendingMachine();
	
	@Test 
	void testAddProduct() {
		machine1.addProduct("Water", 0.50, 3);
		assertEquals("Water - $0.5 (3 left)\n", machine1.getInventory());
	}
	
	@Test
	void testInsertCoin() {
		machine1.insertCoin("dime");
		assertEquals(0.10, machine1.getBalance());
		
		machine1.insertCoin("quarter");
		assertEquals(0.35, machine1.getBalance());
	}
	
	@Test
	void testMakeChange() {
		machine1.insertCoin("dime");
		machine1.insertCoin("quarter");
		assertEquals(0.35, machine1.makeChange());
		assertEquals(0, machine1.getBalance());
	}
	
	@Test
	void testBuy() {
		machine1.makeChange();
		machine1.addProduct("Water", 0.50, 3);
		assertFalse(machine1.buy(1));

		
		machine1.insertCoin("quarter");
		machine1.insertCoin("quarter");
		assertTrue(machine1.buy(1));

		
	}
}
