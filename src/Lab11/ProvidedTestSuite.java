package Lab11;

import Lab07.Product;

/**
 * 
 * @author duncantasker
 *
 */
public class ProvidedTestSuite {
	/**
	 * 
	 * test class for betterbag class
	 */
	public static void main(String[] args) {
		Bag<String> StringBag = new Bag<>();
		
		System.out.println(StringBag.getRandomItem() + ", Should be null");
		
		StringBag.addToBag("bread");
		StringBag.addToBag("cheese");
		StringBag.addToBag("coffee");
		
		System.out.println(StringBag.getNumItems() + ", should be 3");
		System.out.println(StringBag.getRandomItem() + ", should be bread, cheese, or coffee");
		
		
		Bag<Product> ProductBag = new Bag<>();
		
		System.out.println(ProductBag.getRandomItem() + ", Should be null");
		
		Product item = new Product("cola", 1.09, 6);
		ProductBag.addToBag(item);
		item = new Product("rice", 3.95, 1);
		ProductBag.addToBag(item);
		item = new Product("gum", 4.49, 1);
		ProductBag.addToBag(item);
		item = new Product("apples", 6.99, 12);
		ProductBag.addToBag(item);

		System.out.println(ProductBag.getNumItems() + ", should be 4");
		System.out.println(ProductBag.getRandomItem().getName() + ", should be cola, rice, gum, or apples");
		
	}
}
