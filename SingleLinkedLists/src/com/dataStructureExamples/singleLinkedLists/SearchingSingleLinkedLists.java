package com.dataStructureExamples.singleLinkedLists;

import com.dataStructureExamples.singleLinkedLists.node.Node;


/**
 * The SearchingSingleLinkedLists class.
 * <p>
 * This class is a runnable program and is designed
 * to demonstrate the steps that are involved with
 * traversing through a single linked list to search
 * for the item that we are looking for. 
 * <p>
 * The linked list itself is constructed in a lazy manner, 
 * however the purpose of this class is rather to demonstrate
 * how we recursively and iteratively search a single linked list.
 * 
 * @author Sze Yick
 */
public class SearchingSingleLinkedLists {

	/**
	 * The program main.
	 * @param args - command line arguments.
	 */
	public static void main(String[] args) {
		Node head = buildLinkedList();
		
		// Printing the output for the searched names by searching lists
		// iteratively and recurisvely.
		System.out.println("Name exists in the list - " + iterativeSearchSingleLinkedList(head, "Dave"));
		System.out.println("Name exists in the list - " + recursiveSearchSingleLinkedList(head, "Sue"));
		
		System.out.println("Name exists in the list - " + iterativeSearchSingleLinkedList(head, "Gary"));
		System.out.println("Name exists in the list - " + recursiveSearchSingleLinkedList(head, "Steve"));
	}

	/**
	 * A convenience method to build a simple single
	 * linked list. 
	 * 
	 * The structure for this list follows the examples from
	 * the Single Linked Lists tutorial located at -
	 * 
	 * The structure of the list is the following -
	 * 
	 * head -> John -> Sue -> Dave -> null
	 * 
	 * @return the constructed linked list as a {@link Node}
	 */
	public static Node buildLinkedList() {
		// Create our individual nodes.
		Node john = new Node("John");
		Node sue = new Node("Sue");
		Node dave = new Node("Dave");
		
		// Connect the nodes John -> Sue -> Dave
		john.setNext(sue);
		sue.setNext(dave);
		
		// Return the node "John" as the head of our list.
		return john;
	}
	
	/**
	 * Searching a Single Linked List through iteration.
	 * 
	 * @param head - the head or start of our linked list.
	 * @param item - the item which we are to search for.
	 * @return <code>true</code> if we find the name in our list, 
	 * <code>false</code> otherwise.
	 */
	public static boolean iterativeSearchSingleLinkedList(Node head, String name) {
		
		boolean isFound = false; // flag to indicate if we have found our name or not.
		Node currentNode = head; // reference to the current node we are looking at. 
		
		// We iterate through our linked list, until we have no more nodes to 
		// look at (Condition #2)
		while (currentNode != null) {
			// If the current node contains the name we are looking for
			// then we have found the name in our list and can return true
			// to indicate that we have found it. Because we have found it
			// we can also break out of this loop. (Condition #1)
			if (currentNode.getName().equals(name)) {
				isFound = true;
				break;
			}
			
			// If we have not found it we need to continue searching in the
			// next node.
			currentNode = currentNode.getNext();
		}
		return isFound;
	}

	/**
	 * Searching through a Single Linked List recursively. The
	 * idea with recursion is that we reduce the size of the input
	 * each time it calls itself.
	 * 
	 * @param head - the head or start of our linked list.
	 * @param name - the name that we are searching for.
	 * @return <code>true</code> if the name is in 
	 */
	public static boolean recursiveSearchSingleLinkedList(Node head, String name) {
		
		// If the current head is null, it means we've
		// reached the end of our list. (Condition #2)
		if (head == null) {
			return false;
		}
		
		// If the current node contains the name we're
		// looking for, we can return true (Condition #1)
		if (head.getName().equals(name)) {
			return true;
		}
		else {
			// If we've not satisfied either condition, we must call the
			// method again but with the next node, reducing the list size.
			return recursiveSearchSingleLinkedList(head.getNext(), name);
		}
	}
}
