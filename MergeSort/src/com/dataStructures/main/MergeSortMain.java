package com.dataStructures.main;

/**
 * The MergeSortMain.
 * <p>
 * This class is responsible for demonstrating the merge sort.
 * <p>
 * @author szeyick
 */
public class MergeSortMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int array[] = new int[] {9, 8 ,7 ,6 ,5, 4, 3, 2, 1};
		
		System.out.println("The array before sorting.");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		mergeSort.mergeSort(array);
		
		System.out.println("The array after sorting.");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
