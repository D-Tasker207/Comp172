package Lab07;

/**
 * Purpose:  this utility class receives the name of a coin and returns its dollar value.
 * The class uses static final properties and static methods as there is no need to create an object to
 * use the class
 */

public class Coin {
    private static final double nickel = 0.05;
    private static final double dime = 0.10;
    private static final double quarter = 0.25;
    private static final double unrecognized = 0.0;

/**
 * Purpose:  determine the type of coin and return the value as a fraction of 100
 * @param cointType a string representing the coin
 * @returns the value as a fraction of a dollar
 */
    public static double value(String coinType) {
        double coinValue;
        if (coinType.equalsIgnoreCase("nickel")) {
            coinValue = nickel;
        } else if (coinType.equalsIgnoreCase("dime")) {
            coinValue = dime;
        } else if (coinType.equalsIgnoreCase("quarter")) {
            coinValue = quarter;
        } else {
            coinValue = unrecognized;
        }
        return coinValue;
    }
}
