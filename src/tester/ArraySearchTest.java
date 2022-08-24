package tester;

import binSearch.BinarySearch;
import interpolationSearch.InterpolationSearch;
import linearSearch.LinearSearch;
import mergeSort.MergeSort;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraySearchTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		//ArrayList<Double> arr2 = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			arr1.add(randomize(-10000, 10000));
			//arr2.add(randomize(-10000,10000)/(double) randomize(1,10));
		}
		
		arr1 = MergeSort.Sort(arr1);
		
		//arr2 = MergeSort.Sort(arr2);
		
		System.out.println("Array = " + Arrays.toString(arr1.toArray()));
		
		int searchingNum = arr1.get(randomize(0, arr1.size()));
		System.out.println("Searching for: " + searchingNum);
		
		//double doubleSearchNum = arr2.get(randomize(0, arr2.size()));
		//System.out.println("Searching for double: " + doubleSearchNum);
		
		System.out.println(LinearSearch.Search(arr1, searchingNum, 0));
		
		System.out.println(BinarySearch.Search(arr1, searchingNum, 0, arr1.size()-1 ));
		
		System.out.println(InterpolationSearch.Search(arr1, searchingNum, 0, arr1.size()-1));
		
		//System.out.println(InterpolationSearch.Search(arr2, doubleSearchNum, 0, arr2.size()-1));
		
		
		
	}

	public static int randomize (int x,int y) {
        Random randomNum = new Random();
        int rand = randomNum.nextInt((y-x)+1)+x;
        return rand;
    }
}
