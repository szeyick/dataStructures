package com.dataStructureExamples.singleLinkedListOO.main;

import com.dataStructureExamples.singleLinkedListOO.linkedList.SingleLinkedList;

/**
 * This program is a demonstration of a 
 * Single Linked List using OO concepts.
 * 
 * @author szeyick
 */
public class Main {

	/**
	 * The program start
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();

		// Inserting items into a list.
		list = insertItemsIntoList(list);
		
		// Printing the lists contents
		System.out.println("The contents of the list:");
		list.printListContents();
		System.out.println();
		
		// Search for items in the list.
		searchList(list);
	
		// Delete items from the list.
		deleteItemsFromList(list);
	}
	
	/**
	 * Insert items into both the head and tail of the linked list.
	 * @param list - The linked list
	 * @return - The updated list with contents.
	 */
	private static SingleLinkedList insertItemsIntoList(SingleLinkedList list) {
		
		list.insertItemIntoTail("Dave");
		list.insertItemIntoHead("Stuart");
		list.insertItemIntoTail("Jerry");
		
		return list;
	}
	
	/**
	 * Search for items both iteratively and recursively in the linked list.
	 * @param list - The linked list.
	 */
	private static void searchList(SingleLinkedList list) {
		System.out.println();
		System.out.println("Searching a List:");
		System.out.println("Does Jerry exist in the list: " + list.iterativeSearch("Jerry"));
		System.out.println("Does Phil exist in the list: " + list.recursiveSearch("Phil"));
		
		System.out.println("Does Bob exist in the list: " + list.iterativeSearch("Bob"));
		System.out.println("Does Dave exist in the list: " + list.recursiveSearch("Dave"));
		System.out.println();
	}
	
	/**
	 * Deleting items from the linked list.
	 * @param list - The linked list.
	 */
	private static void deleteItemsFromList(SingleLinkedList list) {
		System.out.println("Deleting items from list:");
		System.out.print("Before: ");
		list.printListContents();
		System.out.println();
		list.deleteItemFromList("Dave");
		list.deleteItemFromList("Jerry");
		System.out.print("After: ");
		list.printListContents();
	}
}
