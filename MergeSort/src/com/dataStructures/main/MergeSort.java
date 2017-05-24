package com.dataStructures.main;

/**
 * The MergeSort.
 * <p>
 * This class contains an implementation of merge sort.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class MergeSort {

	/**
	 * The entry into the object.
	 * @param array - The array to sort.
	 * @return the sorted array.
	 */
	public int[] mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length -1);
		return array;
	}

	/**
	 * The driver for the recursion in the merge sort algorithm.
	 * @param array - The array that we want to sort.
	 * @param tmp - The temporary array to copy the elements into.
	 * @param leftStartIndex - The start point of the left portion of the array.
	 * @param rightStart - The right point of the right portion of the array.
	 */
	private void mergeSort(int[] array, int[] tmp, int leftStartIndex, int rightEndIndex) {
		if (leftStartIndex >= rightEndIndex) {
			return; // Break the recursion when the left side index is larger than the right side.
		}
		int middleIndex = (leftStartIndex + rightEndIndex) / 2; // Find the middle of the array to split.
		mergeSort(array, tmp, leftStartIndex, middleIndex); // Break the array down the left side.
		mergeSort(array, tmp, middleIndex + 1, rightEndIndex); // Break the array down the right side.
		mergeHalves(array, tmp, leftStartIndex, rightEndIndex);
	}

	/**
	 * Merge the two halves of the array together.
	 * @param array - The array that we want to sort.
	 * @param tmp - The temporary array to copy the elements into.
	 * @param leftStartIndex - The start point of the left portion of the array.
	 * @param rightEndIndex - The right point of the right portion of the array.
	 */
	private void mergeHalves(int[] array, int[] tmp, int leftStartIndex, int rightEndIndex) {
		int leftEndIndex = (leftStartIndex + rightEndIndex) / 2; // The midpoint of the sub-array.
		int rightStartIndex = leftEndIndex + 1; // The start of the right index (middle + 1)
		int size = (rightEndIndex - leftStartIndex) + 1; // The size of the sub-array to merge.

		// Indices representing where we are in the current left or right sub-array.
		int currentLeftIndex = leftStartIndex; 
		int currentRightIndex = rightStartIndex;
		int currentIndex = leftStartIndex;

		// Loop through the current left and right sub-arrays until one is empty.
		while (currentLeftIndex <= leftEndIndex && currentRightIndex <= rightEndIndex) {
			if (array[currentLeftIndex] <= array[currentRightIndex]) {
				tmp[currentIndex] = array[currentLeftIndex];
				currentLeftIndex++;
			}
			else {
				tmp[currentIndex] = array[currentRightIndex];
				currentRightIndex++;
			}
			currentIndex++;
		}
		// One of the two halves will be empty so copy the elements into the temporary array.
		while (currentLeftIndex <= leftEndIndex) {
			tmp[currentIndex] = array[currentLeftIndex];
			currentIndex++;
			currentLeftIndex++;
		}
		while (currentRightIndex <= rightEndIndex) {
			tmp[currentIndex] = array[currentRightIndex];
			currentIndex++;
			currentRightIndex++;
		}
		// Copy the elements in the temporary array back into the main array.
		int currentLeft = 0;
		while (currentLeft < size) {
			array[leftStartIndex] = tmp[leftStartIndex];
			leftStartIndex++;
			currentLeft++;
		}
	}
}
