package Lab11;

import java.util.ArrayList;

import randNum.RandNum;

/**
 * 
 * @author duncantasker
 *
 * @param <T> object type of bag
 */
public class Bag<T> {
	
	private ArrayList<T> bagContents;
	
	/**
	 * constructor instantiates the arraylist
	 */
	public Bag() {
		bagContents = new ArrayList<>();
	}
	
	/**
	 * add item to the end of the arraylist
	 * @param item item to be added
	 */
	public void addToBag(T item) {
		bagContents.add(item);
	}
	
	/**
	 * get the number of items in the arraylist
	 * @return number of items in arraylist
	 */
	public int getNumItems() {
		return bagContents.size();
	}
	
	/**
	 * get a random item from the arraylist
	 * @return returns random item in arraylist
	 */
	public T getRandomItem() {
		if (bagContents.size() > 0) {
			int itemNum = RandNum.genRandNum(0, bagContents.size()-1);
			T item = bagContents.get(itemNum);
			bagContents.remove(itemNum);
			return item;
		}
		else return null;
	}
}