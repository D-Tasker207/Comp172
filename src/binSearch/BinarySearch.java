package binSearch;

import java.util.ArrayList;

public class BinarySearch {
		
	public static <T extends Comparable<T>> int Search(ArrayList<T> arr, T tgt,int start, int end) {
		//base case, if arr is smaller than 1
		if (start > end) {
			return -1;
		}
				
		//find the middle of current selection
		int mid = (start + end) / 2;
		
		//if middle of arr equals target then exit
		if (arr.get(mid).compareTo(tgt) == 0) {
			return mid;
		}
		//if middle of arr is less than tgt then call on second half of array
		if (arr.get(mid).compareTo(tgt) < 0){
			return Search(arr, tgt, mid+1, end);
		}
		//if middle of arr is greater than tgt then call on first half of array
		if (arr.get(mid).compareTo(tgt) > 0){
			return Search(arr, tgt, start, mid-1);
		}
		return -1;
	}
}
