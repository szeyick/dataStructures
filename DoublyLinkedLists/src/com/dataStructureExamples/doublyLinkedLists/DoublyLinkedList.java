package com.dataStructureExamples.doublyLinkedLists;

/**
 * The DoublyLinkedList class.
 * 
 * This class is an OO representation of
 * a Doubly Linked List. The main idea with
 * this implementation is to encapsulate the 
 * data contained within each node.
 * 
 * Instead of accessing the node data and values
 * directly, outside classes must invoke methods on 
 * the DoublyLinkedList object to perform the linked
 * list operations (search, insertion, deletion).
 * 
 * @author szeyick
 *
 */
public class DoublyLinkedList {

	/**
	 * The head of the doubly linked list.
	 */
	private Node head;
	
	/**
	 * Public method to delete an item from
	 * the doubly linked list.
	 * @param name - The name of the item to 
	 * remove.
	 * @return <code>true</code> if removal was
	 * successful, <code>false</code> otherwise.
	 */
	public boolean deleteFromList(String name) {
		Node nodeToRemove = search(head, name); // (1)
		if (nodeToRemove == null) {
			return false; // No item of such name to remove.
		}
		else {
			if (nodeToRemove == head) { // (**)
				// Removing the head means to only assign
				// the head to the next since there is no 
				// predecessor.
				head = nodeToRemove.next;
			}
			else {
				Node predecessorNode = nodeToRemove.predecessor; 
				Node nextNode = nodeToRemove.next; 
				// Join the predecessor and next nodes together.
				predecessorNode.next = nextNode; // (2)
				nextNode.predecessor = predecessorNode; // (3)
			}
			return true;
		}
	}
	
	/**
	 * Public method to insert an item
	 * into the doubly linked list.
	 * @param name - The name of the item to
	 * insert.
	 */
	public void insertIntoList(String name) {
		insert(name);
	}
	
	/**
	 * Method to insert an item into a doubly
	 * linked list.
	 * @param name - The name of the item to insert.
	 */
	private void insert(String name) {
		Node newNode = new Node(name); // (1)
		// If the list is empty then we make the 
		// new node as the head.
		if (head == null) { 
			head = newNode;
		}
		else {
			// Set the new node to point to the current head.
			newNode.next = head; 
			// Set the current head to point back to the new node.
			head.predecessor = newNode;
			// Set the new node as the head.
			head = newNode;
		}
	}
	
	/**
	 * Public method to search for an
	 * item in the doubly linked list.
	 * @param name - The item we're looking for.
	 * @return The found node, or null otherwise.
	 */
	public String searchList(String name) {
		Node foundNode = search(head, name);
		if (foundNode == null) {
			return null;
		}
		else {
			return foundNode.name;
		}
	}
	
	/**
	 * Method to search a doubly linked list.
	 * @param currentNode - The current node being inspected.
	 * @param name - The item we're looking for.
	 * @return The found node, or null if not found.
	 */
	private Node search(Node currentNode, String name) {
		if (currentNode == null) {
			return null; // The list is empty, return not found.
		}
		if (currentNode.name.equals(name)) {
			return currentNode; // We've found the node we're looking for.
		}
		else {
			// Continue searching the list, recursively call the search
			// method again with the next node as the argument.
			return search(currentNode.next, name);
		}
	}
	
	/**
	 * Print the contents of the list.
	 */
	public void printListContents() {
		Node current = head;
		while (current != null) {
			System.out.print(current.name + " -> " );
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	/**
	 * The Node class.
	 * 
	 * This class is represents the nodes in a
	 * doubly linked list.
	 *
	 */
	private class Node {
		
		/**
		 * The data that the node contains.
		 */
		public String name;
		
		/**
		 * A reference to the successor node.
		 */
		public Node next;
		
		/**
		 * A reference to the predecessor node.
		 */
		public Node predecessor;
		
		/**
		 * Constructor to initialise a new node.
		 * @param nameTmp - The name value for the node.
		 */
		public Node(String nameTmp) {
			this.name = nameTmp;
			this.next = null;
			this.predecessor = null;
		}
	}
}
