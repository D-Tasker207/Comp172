package Lab11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Lab07.Product;

class Lab11Test {

	Bag<Product> ProductBag = new Bag<>();
	@Test
	void BetterBagtest() {
		
		assertEquals(0, ProductBag.getNumItems());
		
		assertEquals(null, ProductBag.getRandomItem());
		
		Product item1 = new Product("Bread", 12, 5);
		
		ProductBag.addToBag(item1);
		
		assertEquals(1, ProductBag.getNumItems());
		
		assertEquals("Bread", ProductBag.getRandomItem().getName());
		
		assertEquals(0, ProductBag.getNumItems());
	}
}
