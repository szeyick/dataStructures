package com.dataStructureExamples.doublyLinkedLists.main;

import com.dataStructureExamples.doublyLinkedLists.DoublyLinkedList;

/**
 * This program is a demonstration of a 
 * Doubly Linked List using OO concepts.
 * 
 * @author szeyick
 */
public class Main {

	public static void main(String[] args) {

		// Create the doubly linked list and insert an item.
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insertIntoList("Dave");
		
		// Search for an item in the list.
		String name = doublyLinkedList.searchList("Dave");
		if (name != null) {
			System.out.println("Name is found - " + name);
		}
		else {
			System.out.println("Name is not found - " + name);
		}
		
		// Insert more items into the list.
		doublyLinkedList.insertIntoList("Jerry");
		doublyLinkedList.insertIntoList("Stuart");
		
		// Print the list contents.
		doublyLinkedList.printListContents();
		
		// Delete items from the list.
		doublyLinkedList.deleteFromList("Stuart");
		doublyLinkedList.deleteFromList("Jerry");
		doublyLinkedList.deleteFromList("Frank");
		
		// Print the updated list contents.
		doublyLinkedList.printListContents();
	}

}
