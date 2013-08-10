package com.dataStructureExamples.arrays.dynamicArray;


/**
 * Dynamic array class represented as a data structure.
 * 
 * The storage for the dynamic array in this example still uses
 * a basic array, but we encapsulate the behaviour of the logical size
 * and the capacity of the array.
 * 
 * Furthermore, we can also encapsulate the resize methods within the dynamic
 * array object, hiding the implementation from outside classes.
 * 
 * @author Sze Yick
 *
 */
public class DynamicArray {

	/**
	 * The logical size of the dynamic array
	 */
	private int logicalSize;
	
	/**
	 * The capacity of the dynamic array
	 */
	private int capacity;
	
	/**
	 * The array to store the items in
	 */
	private int[] array;
	
	/**
	 * Constructor for the dynamic array.
	 * Initialise values to 0;
	 */
	public DynamicArray() {
		logicalSize = 0;
		capacity = 0;
		array = null;
	}
	
	/**
	 * Create an array with a specified capacity.
	 * @param capacity the size of which to create the array
	 */
	public void createArrayWithSize(int capacityTmp) {
		array = new int[capacityTmp];
		capacity = capacityTmp;
	}
	
	/**
	 * Insert an item at the end of the array.
	 * @param dynamicArray - the array to insert the item into.
	 * @param itemToInsert - the item to insert.
	 * @param capacity - the capacity of the array.
	 * @param logicalSize - the logical size of the array.
	 * @return - the array with the inserted item.
	 */
	public void insertAtEnd(int itemToInsert) {
		//If the logical size reaches the capacity, we need to resize
		if (logicalSize == capacity) {
			capacity = capacity * 2;
			//Resize the array by a factor of 2 and copy the array contents over
			resizeArrayAndCopyItems(capacity);
		}
		array[logicalSize] = itemToInsert;
		logicalSize++;
	}
	
	/**
	 * Resize the new array and copy the items over to the new array.
	 * @param newCapacity - the new capacity of our array.
	 */
	private void resizeArrayAndCopyItems(int newCapacity) {
		int[] newArray = new int[newCapacity];
		//Copy the items from the old array over to the new array.
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		//Assign the new array to the reference pointer to the old array 
		//to free up the memory.
		array = newArray;
	}
	
	/**
	 * Remove an item from the end of the array
	 */
	public void removeFromEnd() {
		//Be careful not to let the logical size go below 0. If it does, we'll cause
		//an out of bounds exception.
		if (logicalSize >= 0) {
			logicalSize--;
		}
		
		//If capacity is half the logical size we will resize
		if ((logicalSize / capacity) == 2) {
			capacity = logicalSize;
			resizeArrayAndCopyItems(capacity);
		}
	}
	
	/**
	 * Insert an item into a particular index of the array
	 * @param itemToInsert - the item to insert.
	 * @param indexToInsert - the index to insert the item into.
	 * @return <code>true</code> if item has been inserted, <code>false</code> otherwise.
	 */
	public boolean insertItemIntoIndex(int itemToInsert, int indexToInsert) {
		boolean isItemInserted = false;
		//Only insert items if its within the range of the array
		if (indexToInsert <= logicalSize && indexToInsert >= 0) {
			if ((logicalSize + 1) > capacity) {
				//If logicalSize + 1 is greater than the capacity we'll need to resize the array first
				capacity = capacity * 2;
				resizeArrayAndCopyItems(capacity);
			}
			
			//Shift the items from indextToInsert to logicalSize 1 to the right.
			shiftArrayItemsRight(indexToInsert, logicalSize);
			array[indexToInsert] = itemToInsert;
			logicalSize++;
			isItemInserted = true;
		}
		return isItemInserted;
	}
	
	/**
	 * Shift array items across to the right from an index to another.
	 * @param fromIndex - the index to shift from
	 * @param toIndex - the index to shift to
	 */
	private void shiftArrayItemsRight(int fromIndex, int toIndex) {
		//Shift items across to the right by 1
		int itemInCurrentIndex = array[fromIndex];
		for (int i = fromIndex + 1; i <= toIndex; i++) {
			int itemInNextIndex = array[i];
			array[i] = itemInCurrentIndex;
			itemInCurrentIndex = itemInNextIndex;
		}
	}
	
	/**
	 * Remove an item from the given index in the array
	 * @param indexToRemove - the index of the item to remove.
	 * @return <code>true</code> if the item has been removed, false otherwise.
	 */
	public boolean removeItemFromIndex(int indexToRemove) {
		boolean isItemRemoved = false;
		//Only remove items if its within the range of the array
		if (indexToRemove < logicalSize && indexToRemove >= 0) {
			//Shift items 1 to the left, the item in the current logical size is
			//A copy, so just reduce the logical size. We'll resize if required.
			shiftArrayItemsLeft(indexToRemove, logicalSize);
			removeFromEnd();
			isItemRemoved = true;
		}
		return isItemRemoved;
	}
	
	/**
	 * Shift array items across to the left from an index to another
	 * @param fromIndex - the index to shift from.
	 * @param toIndex - the index to shift to.
	 */
	private void shiftArrayItemsLeft(int fromIndex, int toIndex) {
		//Shift items across to the left by 1
		for (int i = fromIndex + 1; i < toIndex; i++) {
			array[i-1] = array[i];
		}
	}
	
	/**
	 * Get the logical size of the array
	 * @return the logical size.
	 */
	public int getLogicalSize() {
		return logicalSize;
	}
	
	/**
	 * Get the capacity of the array
	 * @return the capacity.
	 */
	public int getArrayCapacity() {
		return capacity;
	}
	
	/**
	 * Get the array;
	 * @return array.
	 */
	public int[] getArray() {
		return array;
	}
	
	
	/**
	 * Print the contents of the array.
	 */
	public void printArrayContents() {
		if (logicalSize == 0) {
			System.out.println("Array is empty");
		}
		else {
			System.out.println("Array contents are: ");
			for (int i = 0; i < logicalSize; i++) {
				System.out.print(array[i] + " ");
			}			
		}
		System.out.println();
	}
}
