package interpolationSearch;

import java.util.ArrayList;

public class InterpolationSearch {
	
	public static <T extends Number & Comparable<T> >int Search(ArrayList<T> arr, T tgt, int start, int end) {
		//base case if arr is smaller than 1 then return -1
		if (start > end) {
			return -1;
		}
		
		//calculate position based off interpolation of data
		int pos = (int) (start + (((tgt.doubleValue() - arr.get(start).doubleValue()) * (end - start)) / (arr.get(end).doubleValue() - arr.get(start).doubleValue())));
		
		//if pos equals tgt return pos
		if (arr.get(pos).compareTo(tgt) == 0) {
			return pos;
		}
		//if pos is les than tgt call on pos + 1 to end of array
		if (arr.get(pos).compareTo(tgt) < 0) {
			return Search(arr, tgt, pos + 1, end);
		}
		//if pos is greater than tgt call on start of array to pos - 1 
		if (arr.get(pos).compareTo(tgt) > 0) {
			return Search(arr, tgt, start, pos - 1);
		}
		return -1;
	}
}
