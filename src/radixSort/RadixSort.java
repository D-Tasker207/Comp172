package radixSort;

import java.util.Arrays;

public class RadixSort {
	
	private static int getMax(int[] a, int n) {
		//find the maximum element of array
		int max = a[1];
		for(int i=1;i<n;i++) {
			if (max<a[i]) {
				max = a[i];
			}
		}
		return max;
	}
	
	private static void countingSort(int[] a, int n, int place) {
		int[] output = new int[n+1];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		//calculate count of each 
		for (int i = 0; i<n; i++) {
			count[(a[i]/place) % 10]++;
		}
		
		//calculate something im not entirely sure
		for (int i = 1; i < 10; i++) {
			count[i] += count[i-1];
		}
		
		//actually sort
		for (int i = n-1; i >= 0; i--) {
			output[count[(a[i]/place) % 10]-1] = a[i];
			count[(a[i] / place) % 10]--;
		}
		
		//copying output back into the input parameter a
		for (int i = 0; i<n; i++) {
			a[i]=output[i];
		}
	}
	
	//public interface
	public static void Sort(int[] a, int n) {
		int max = getMax(a, n);
		
		for (int place = 1; max / place > 0; place *= 10) {
			countingSort(a, n, place);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,12,4,5,14,128,292,56,124,254,230,9};
		Sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
