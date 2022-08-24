package Lab10;

/**
 * 
 * @author duncantasker
 *
 */
public class Circle extends Shape {

	private double radius;
	
	/**
	 * 
	 * @param radius radius of circle
	 * @param xLocation x coordinate of shape
	 * @param yLocation y coordinate of shape
	 */
	public Circle(double radius, double xLocation, double yLocation) {
		super(xLocation, yLocation);
		this.radius = radius;
	}

	/**
	 * @return area of circle
	 */
	public double area() {
		return (Math.PI * Math.pow(radius, 2));
	}

	/**
	 * @return perimeter of circle
	 */
	public double perimeter() {
		return 2 * (Math.PI * radius);
	}

	public double getRadius() {
		return radius;
	}
}
