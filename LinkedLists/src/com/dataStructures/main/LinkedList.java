package com.dataStructures.main;

/**
 * The LinkedList.
 * <p>
 * This class is responsible for encapsulating the
 * linked list nodes to limit access to external
 * objects. This is an implementation of a singly
 * linked list.
 * <p>
 * @author szeyick
 */
public class LinkedList {

	/**
	 * The beginning of the list.
	 */
	private Node head;
	
	/**
	 * The end of the list.
	 */
	private Node tail;
	
	/**
	 * Add a value to the end of the linked list.
	 * @param value - The value to add.
	 */
	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			// Base case if the list is empty.
			head = newNode;
			tail = newNode;
		}
		else {
			tail.nextNode = newNode; // The current tail node is updated to point to the new node.
			tail = newNode; // The new node becomes the new tail.
		}
	}
	
	/**
	 * Add a value to the start of the linked list.
	 * @param value - The value to add.
	 */
	public void prepend(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
			head.nextNode = tail;
		}
		else {
			newNode.nextNode = head;
			head = newNode;
		}
	}
	
	/**
	 * @return the last value in the list.
	 */
	public int getTailValue() {
		if (tail == null) {
			return -1;
		}
		return tail.value;
	}
	
	/**
	 * @return the head value.
	 */
	public int getHeadValue() {
		if (head == null) {
			return -1;
		}
		return head.value;
	}
	/**
	 * Delete a value from the linked list.
	 * @param value - The value to delete.
	 */
	public void delete(int value) {
		if (head == null) {
			return;
		}
		if (head.value == value) {
			if (head == tail) {
				tail = head.nextNode;
			}
			head = head.nextNode; // Special case if the element we want to remove is the head.
		}
		else {
			Node currentNode = head;
			while (currentNode != null) {
				if (currentNode.nextNode != null && (currentNode.nextNode.value == value)) {
					break;
				}
				currentNode = currentNode.nextNode;
			}
			if (currentNode != null) {
				currentNode.nextNode = currentNode.nextNode.nextNode;
				if (currentNode.nextNode == tail) {
					tail = currentNode;
				}
			}
		}
	}
	
	/**
	 * Print the contents of the linked list.
	 */
	public void printList() {
		if (head == null) {
			System.out.println("List Empty");
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
	
	/**
	 * The Node.
	 * <p> 
	 * This class is responsible for holding the data for a
	 * single element in a linked list. 
	 * <p>
	 * <b>Warning: </b>None.
	 */
	private class Node {
		
		/**
		 * The value contained in the node.
		 */
		private int value;
		
		/**
		 * A reference to the next node in the list.
		 */
		private Node nextNode;
		
		/**
		 * Constructor.
		 * @param value - The value to set to the node.
		 */
		public Node(int value) {
			this.value = value;
		}
	}
}
