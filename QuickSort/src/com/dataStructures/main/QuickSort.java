package com.dataStructures.main;

/**
 * The QuickSort.
 * <p>
 * This class is responsible for containing the algorithm for
 * quicksort.
 * <p>
 * @author szeyick
 */
public class QuickSort {

	/**
	 * @param array - The array to be sorted.
	 */
	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * Recursively perform a quicksort.
	 * @param array - The array to be sorted.
	 * @param left - The current left array index.
	 * @param right - The current right array index (end).
	 */
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return; // Base case when the left index is larger than the right index.
		}
		int pivotValue = array[(left + right) / 2]; // Select the middle element as the pivot value.
		int partitionIndex = partition(array, left, right, pivotValue);
		quickSort(array, left, partitionIndex - 1);
		quickSort(array, partitionIndex, right);
	}
	
	/**
	 * Move the array elements around so that all elements larger than the pivot are on the right
	 * and all elements smaller than the pivot are to the left. Looping through the left and right
	 * sides will not cause the array to overrun, as it will eventually hit the pivot value where it
	 * cannot be equal to.
	 * @param array - The array to be sorted.
	 * @param left - The left array index.
	 * @param right - The right array index (end)
	 * @param pivotValue - The value of the pivot element.
	 * @return the index where the partition value sits.
	 */
	private int partition(int[] array, int left, int right, int pivotValue) {
		int leftIndex = left;
		int rightIndex = right;
		while (leftIndex <= rightIndex) {
			while (array[leftIndex] < pivotValue) {
				leftIndex++; // Search the left portion of the array for a value larger than the partition.
			}
			while (array[rightIndex] > pivotValue) {
				rightIndex--; // Search the right portion of the array for a value smaller than the partition.
			}
			if (leftIndex <= rightIndex) {
				// Swap the values if the indices are still on the correct sides of each other.
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}
	
	/**
	 * Swap the values in the left and right index around.
	 * @param array - The array to swap.
	 * @param left - The left index to swap.
	 * @param right - The right index to swap.
	 */
	private void swap(int[] array, int left, int right) {
		int leftValue = array[left];
		int rightValue = array[right];
		array[left] = rightValue;
		array[right] = leftValue;
	}
}