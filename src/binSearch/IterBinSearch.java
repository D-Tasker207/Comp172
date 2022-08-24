package binSearch;

public class IterBinSearch {
	public int binSearch(int[] arr, int tgt, int start, int end) {
		boolean searching = true;
		int mid = 0;
		while(searching) {
			mid = (start + end) / 2;
			if (tgt == arr[mid]) {
				searching = false;
			}
			else if (tgt > arr[mid]) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
			
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,7,8,9,10,11};
		
		IterBinSearch search1 = new IterBinSearch();
		System.out.println(search1.binSearch(arr1, 7, 0, arr1.length-1));
	}
}