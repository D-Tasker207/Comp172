package Lab10;

/**
 * 
 * @author duncantasker
 *
 */

public class Rectangle extends Shape{
	
	private double length;
	private double height;
	
	/**
	 * 
	 * @param length length of rectangle
	 * @param height height of rectangle
	 * @param xLocation x coordinate of shape
	 * @param yLocation y coordinate of shape
	 */
	public Rectangle(double length, double height, double xLocation, double yLocation) {
		super(xLocation, yLocation);
		this.length = length;
		this.height = height;
	}
	
	/**
	 * @return area of rectangle
	 */
	public double area() {
		return length * height;
	}

	/**
	 * @return perimeter of rectangle
	 */
	public double perimeter() {
		return (2*length) + (2*height);
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}
}
