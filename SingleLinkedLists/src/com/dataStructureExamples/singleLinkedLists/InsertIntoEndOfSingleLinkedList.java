package com.dataStructureExamples.singleLinkedLists;

import com.dataStructureExamples.singleLinkedLists.node.Node;

/**
 * The InsertIntoEndOfSingleLinkedList class.
 * <p>
 * This class is a runnable program and is designed
 * to demonstrate the steps that are involved with
 * inserting an item into a the end of a single linked
 * list.
 * <p>
 * The program does not accept user input, as it is 
 * merely to demonstrate the method to insert an item
 * into the end of a list. 
 * 
 * @author Sze Yick
 */
public class InsertIntoEndOfSingleLinkedList {

	/**
	 * @param args - The program arguments.
	 */
	public static void main(String[] args) {

		// Our initial empty list.
		Node head = null;
		Node tail = null;
		
		// Initial insert will be to set up the head and tail
		tail = insertItemIntoTail(null, "Stuart");
		head = tail;
		
		tail = insertItemIntoTail(tail, "Dave");
		tail = insertItemIntoTail(tail, "Jerry");
		
		printListContents(head);
	}
	
	/**
	 * Insert an item to the end of a linked list. 
	 * 
	 * We require a null check for the tail in the case
	 * for an empty list. 
	 * 
	 * @param currentTail - The current reference to the last node.
	 * in the list.
	 * @param name - The item to insert.
	 * @return newNode - The new node, that is the tail of the list.
	 */
	private static Node insertItemIntoTail(Node currentTail, String name) {
		Node newNode = new Node(name); // Create the new item.
		
		// Update the nextNode of the current end to point to our
		// new node. 
		if (currentTail != null) {
			currentTail.setNext(newNode);
		}
		
		// Return the newly created node, this now becomes the end of our list.
		return newNode;
	}
	
	/**
	 * Recursively print the contents of the linked list.
	 * 
	 * If we reach the end of the list, return. Otherwise
	 * print the contents of the current node, and call the
	 * method again and pass in the nextNode as the new argument.
	 * 
	 * @param node - The current node.
	 */
	private static void printListContents(Node node) {
		if (node == null) {
			System.out.print("null");
			System.out.println();
			return; // If we're at the end of the list, return.
		}
		else {
			// Otherwise print and call method again with nextNode.
			System.out.print(node.getName() + "-->");
			printListContents(node.getNext());
		}
	}

}
