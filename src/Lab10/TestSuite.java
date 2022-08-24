package Lab10;

public class TestSuite {

	public static void main(String[] args) {
		Circle circ1 = new Circle(1,1,1);
		System.out.println("Circle 1");
		System.out.println("Area: " + circ1.area() + " should be 3.14 (ish)");
		System.out.println("Perimeter: " + circ1.perimeter()+ " should be 6.28 (ish)");
		
		Circle circ2 = new Circle(15.5,1,1);
		System.out.println("\nCircle2");
		System.out.println("Area:  "+ circ2.area() + " should be 754.77 (ish)");
		System.out.println("Perimeter: " + circ2.perimeter() + " should be 97.39 (ish)");
		
		Rectangle rect1 = new Rectangle(10,10,1,1);
		System.out.println("\nRectangle1");
		System.out.println("Area: " + rect1.area() + " should be 100");
		System.out.println("Perimeter: " + rect1.perimeter() + " should be 40");
		
		Rectangle rect2 = new Rectangle(0.5,0.5,1,1);
		System.out.println("\nRectangle2");
		System.out.println("Area: " + rect2.area() + " should be 0.25");
		System.out.println("Perimeter: " + rect2.perimeter() + " should be 2");
		
		Triangle tri1 = new Triangle(3,4,5,1,1);
		System.out.println("\nTriangle1");
		System.out.println("Area: " + tri1.area() + " should be 6");
		System.out.println("Perimeter " + tri1.perimeter() + " should be 12");
		
		Triangle tri2 = new Triangle(0.6,0.8,1,1,1);
		System.out.println("\nTriangle2");
		System.out.println("Area: " + tri2.area() + " should be 0.24 (ish)");
		System.out.println("Perimeter " + tri2.perimeter() + " should be 2.4");
	}

}
