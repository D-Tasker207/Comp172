package linearSearch;

import java.util.ArrayList;

public class LinearSearch {
	
	public static <T extends Comparable<T>> int Search(ArrayList<T> arr, T tgt, int start) {
		//iterate through the array from start to either end of array
		for(int i = start; i < arr.size(); i++) {			
			//if current index equals tgt then return index
			if (arr.get(i).compareTo(tgt) == 0) {
				return i;
			}
		}
		return -1;
	}
}
