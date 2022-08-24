package mergeSort;

import java.util.ArrayList;

public class MergeSort {
		
	//public interface for merge sort
	public static <T extends Comparable<T>> ArrayList<T> Sort(ArrayList<T> A) {
		
		return mergeSplit(A);
	}

	//splitting arrays into half arrays
	private static <T extends Comparable<T>> ArrayList<T> mergeSplit(ArrayList<T> A) {
		//base case, if input array is only one element, exit
		if (A.size() <= 1) {
			return A;
		}
		
		//create two child arrays of the left and right halves of the input array, if input array length is odd favor left array
		ArrayList<T> left = new ArrayList<T>();
		ArrayList<T> right = new ArrayList<T>();
		
		//Add first half of array to the left array, then add the rest to the right array
		for (int i = 0; i < A.size(); i++) {
			if (i < (int) Math.ceil(A.size()/2.0)) {
				left.add(A.get(i));
			}
			else {
				right.add(A.get(i));
			}
		}
			
		//split the left half into halves
		left = mergeSplit(left);
		//split the right half into halves
		right = mergeSplit(right);
		
		//merge the left and right halves together
		return mergeJoin(left, right);
	}
	
	//joining the two half arrays back into one ordered arrays
	private static <T extends Comparable<T>> ArrayList<T> mergeJoin(ArrayList<T> left, ArrayList<T> right) {
		//create new array of combined lengths of left and right arrays
		ArrayList<T> result = new ArrayList<T>();
		
		//create index variables for left and right arrays
		int i = 0, j = 0;
		//iterate through the length of result array
		for (int k = 0; k < left.size()+right.size(); k++) {
			//if i is not oob of left array, and (the right index is oob or left index is less than right index), add left to result array, else add right result to array
			if (i < left.size() && (j == right.size() || (left.get(i).compareTo(right.get(j)) < 0))) {
				result.add(left.get(i));
				i++;
			}
			else {
				result.add(right.get(j));
				j++;
			}
		}
		return result;
	}
}
