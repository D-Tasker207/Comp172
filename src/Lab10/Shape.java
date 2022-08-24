package Lab10;

/**
 * 
 * @author duncantasker
 *
 */
public abstract class Shape {
	
	protected double[] location = new double[2];
	
	/**
	 * @param xLocation x coordinate of shape
	 * @param yLocation y coordinate of shape
	 */
	public Shape(double xLocation, double yLocation) {
		this.location[0] = xLocation;
		this.location[1] = yLocation;
	}

	/**
	 * 
	 * @return area of shape
	 */
	public abstract double area();
	
	/**
	 * 
	 * @return perimeter of shape
	 */
	public abstract double perimeter();
	
	/**
	 * 
	 * @return distance from origin of the shape
	 */
	public double getDistance() {
		return Math.sqrt(Math.pow(location[0],2) + Math.pow(location[1], 2));
	}
	/**
	 * 
	 * @return array with x and y coordinates of shape
	 */
	public double[] getLocation() {
		return location;
	}
}
