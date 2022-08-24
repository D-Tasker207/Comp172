package tester;

public class FormulaTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,6,7,8,10,11,20,25,30,50,303,650,806};
		int lo = 0, hi = arr.length-1, x = 30;
		
		int pos1 = lo + ((x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]));
		int pos2 = lo + (((hi-lo) / (arr[hi]-arr[lo]))*(x-arr[lo]));
		
		System.out.println(pos1 + " " + pos2);
	}

}
