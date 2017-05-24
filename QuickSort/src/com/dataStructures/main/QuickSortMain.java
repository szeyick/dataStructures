package com.dataStructures.main;

/**
 * The QuickSortMain.
 * <p>
 * This is the program main for the quick sort. It is responsible
 * for providing a demonstration of how quicksort works.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class QuickSortMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] array = new int[] {9, 8, 7, 6, 5, 5, 5, 4, 3, 2, 1};
		
		System.out.println("Array before QuickSort");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		quickSort.quickSort(array);
		System.out.println("Array after QuickSort");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
