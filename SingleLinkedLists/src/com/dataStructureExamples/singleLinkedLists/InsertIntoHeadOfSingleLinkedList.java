package com.dataStructureExamples.singleLinkedLists;

import com.dataStructureExamples.singleLinkedLists.node.Node;

/**
 * The InsertIntoHeadOfSingleLinkedList class.
 * <p>
 * This class is a runnable program and is designed
 * to demonstrate the steps that are involved with
 * inserting an item into a single linked list
 * <p>
 * The program does not accept user input, as it is 
 * merely to demonstrate the method to insert an item
 * into the list. 
 * 
 * @author Sze Yick
 */
public class InsertIntoHeadOfSingleLinkedList {

	/**
	 * @param args - Program arguments
	 */
	public static void main(String[] args) {
		
		// Our initial empty list.
		Node head = null;
		
		// Insert some items into the list and update the head.
		head = insertItemIntoList(head, "Stuart");
		head = insertItemIntoList(head, "Dave");
		
		// Print the current contents of our list.
		printListContents(head);

		// Insert another item into the list and update the head.
		head = insertItemIntoList(head, "Jerry");

		// Again print the current contents of our list.
		printListContents(head);
		
		// Insert an item to the end of our list.
		
	}
	
	/**
	 * Insert an item into a linked list.
	 * 
	 * @param head - The current head of the list.
	 * @param name - The item to insert into the new node.
	 * @return newNode - The new node, that is the head of the list.
	 */
	private static Node insertItemIntoList(Node head, String name) {
		Node newNode = new Node(name); // Create the new item
		
		// Update the current head of the list to be the nextNode of
		// the newly created node.
		newNode.setNext(head); 
		
		// Return the newly created node with the updated nextNode reference.
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
