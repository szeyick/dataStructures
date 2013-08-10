package com.dataStructureExamples.arrays.dynamicArray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit Test for the DynamicArray class
 * 
 * This test covers the various methods within the DynamicArray class
 * to ensure that the correct values are returned.
 * 
 * @author szeyick
 */
public class DynamicArrayTest {

	/**
	 * The class to be tested.
	 */
	private static DynamicArray dynamicArray;
	
	  /**
	   * Set up the test
	   */
	@BeforeClass
	  public static void testSetup() {
		dynamicArray = new DynamicArray();
	  }

	/**
	 * Test that the array is created correctly.
	 */
	@Test
	public void testCreateArray() {
		assertNull("Expected no array to be returned", dynamicArray.getArray());
		dynamicArray.createArrayWithSize(5);
		assertEquals("Expected array with capacity of 5 to be created", 5, dynamicArray.getArrayCapacity());
		assertEquals("Expected array to be empty with no items", 0, dynamicArray.getLogicalSize());
	}
	
	/**
	 * Test the we can insert items to the end of the array.
	 */
	@Test
	public void testInsertAtEnd() {
		dynamicArray.insertAtEnd(10);
		int[] array = dynamicArray.getArray();
		assertEquals("Expected item at the end of the array to be equal", 10, array[0]);
		
		dynamicArray.insertAtEnd(20);
		array = dynamicArray.getArray();
		assertEquals("Expected item at the end of the array to be equal", 10, array[0]);
		assertEquals("Expected item at the end of the array to be equal", 20, array[1]);
	}
	
	/**
	 * Test that we can remove items from the end of the array.
	 */
	@Test
	public void testRemoveFromEnd() {
		assertEquals("Expected to have same number of items in the array", 2, dynamicArray.getLogicalSize());
		dynamicArray.removeFromEnd();
		assertEquals("Expected to have same number of items in the array", 1, dynamicArray.getLogicalSize());
		
		int[] array = dynamicArray.getArray();
		assertEquals("Expected item in index 0 to be the same", 10, array[0]);
	}
	
	/**
	 * Test that we can insert an item to any index in the array.
	 */
	@Test
	public void testInsertItemIntoIndex() {
		assertEquals("Expected array capacity to be the same", 5, dynamicArray.getArrayCapacity());
		assertEquals("Expected to have same number of items in the array", 1, dynamicArray.getLogicalSize());
		
		dynamicArray.insertItemIntoIndex(30, 0);
		assertEquals("Expected to have same number of items in the array", 2, dynamicArray.getLogicalSize());
		int[] array = dynamicArray.getArray();
		assertEquals("Expected item in index 0 to be the same", 30, array[0]);
		assertEquals("Expected item in index 1 to be the same", 10, array[1]);
		
		assertFalse("Expected unable to be inserted at index larger than the logical size", dynamicArray.insertItemIntoIndex(20, 10));
	}
	
	/**
	 * Test that we can remove an item from any index in the array.
	 */
	@Test
	public void testRemoveItemFromIndex() {
		assertEquals("Expected array capacity to be the same", 5, dynamicArray.getArrayCapacity());
		assertEquals("Expected to have same number of items in the array", 2, dynamicArray.getLogicalSize());
		
		dynamicArray.removeItemFromIndex(0);
		int[] array = dynamicArray.getArray();
		assertEquals("Expected to have same number of items in the array", 1, dynamicArray.getLogicalSize());
		assertEquals("Expected item in index 0 to be the same", 10, array[0]);
	}
}
