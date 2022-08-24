package Lab10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Lab10Test {

	Rectangle rect1 = new Rectangle(5, 10, 3, 4);
	
	@Test
	void testRect() {
		assertEquals(10, rect1.getHeight());
		assertEquals(5, rect1.getLength());
		
		assertEquals(50, rect1.area());
		
		assertEquals(30, rect1.perimeter());
		
		assertEquals(5, rect1.getDistance());
		
		double[] arr = {3,4};
		assertArrayEquals(arr , rect1.getLocation());
	}
	
	Circle circ1 = new Circle(3, 0, 0);
	
	@Test
	void testCircle() {
		assertEquals(3, circ1.getRadius());
		
		assertEquals((Math.PI*9), circ1.area());
		
		assertEquals((Math.PI*6), circ1.perimeter());
		
		assertEquals(0, circ1.getDistance());
	}
	
	Triangle tri1 = new Triangle(3, 4, 5, -9, 3);
	
	@Test
	void testTriangle() {
		assertEquals(3, tri1.getSideA());
		assertEquals(4, tri1.getSideB());
		assertEquals(5, tri1.getSideC());
		
		assertEquals(12, tri1.perimeter());
		
		assertEquals(6, tri1.area());
		
		assertTrue(tri1.isATriangle());
		
		assertEquals(Math.sqrt(90), tri1.getDistance());
		
		Triangle tri2 = new Triangle(2, 7, 12, 0 ,0);
		
		assertFalse(tri2.isATriangle());
		
	}

}
