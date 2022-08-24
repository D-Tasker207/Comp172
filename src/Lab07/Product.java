package Lab07;


/**
 * Objects of this class represent specific products in the vending machine inventory
 */

public class Product {

    private String name;
    private int quantity;
    private double price;

    /**
     * initialize the values for the product
     * @param name name of product
     * @param quantity number of product in machine
     * @param price price of product
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * accessor for product name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * accessor for product quantity in machine
     * @return quantity of product
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * accessor for product price
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * add the desired number to the current quantity if an already existing product
     * @param numberOfCans quantity to add
     */
    public void increaseQuantity(int numberOfProduct) {
        this.quantity = this.quantity + numberOfProduct;
    }

    /**
     * change the price of a product
     * @param newPrice the new price of the product
     */
    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * reduce inventory by one after a purchase
     * @return true if there was product to dispense. false otherwise
     */
    public boolean decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
            return true;
        }
        return false;
    }

    /**
     * create a string with information of the product
     * @return the string
     */
    public String toString() {
        return this.name + " - $" + this.price + " (" + this.quantity + " left)";
    }
}
