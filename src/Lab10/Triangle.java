package Lab10;

/**
 * 
 * @author duncantasker
 *
 */
public class Triangle extends Shape{

	private double sideA;
	private double sideB;
	private double sideC;
	
	/**
	 * 
	 * @param sideA first side of triangle
	 * @param sideB second side of triangle
	 * @param sideC third side of triangle
	 * @param xLocation x coordinate of shape
	 * @param yLocation y coordinate of shape
	 */
	public Triangle(double sideA, double sideB, double sideC, double xLocation, double yLocation) {
		super(xLocation, yLocation);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	/**
	 * 
	 * @return if the shape is a valid triangle
	 */
	public boolean isATriangle() {
		if((sideA + sideB > sideC) && (sideB+sideC > sideA) && (sideA + sideC > sideB)) {
			return true;
		}
		return false;
	}

	/**
	 * @return area of triangle
	 */
	public double area() {
		double p = this.perimeter()/2;
		return Math.sqrt(p * (p-sideA) * (p-sideB) * (p-sideC));
	}

	/**
	 * @return perimeter of triangle
	 */
	public double perimeter() {
		return sideA + sideB + sideC;
	}

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}
}
