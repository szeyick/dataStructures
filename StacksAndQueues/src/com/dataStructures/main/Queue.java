package com.dataStructures.main;

/**
 * The Queue.
 * <p>
 * This is a data structure that encapsulates the functionality
 * of a simple queue.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class Queue {

	/**
	 * A reference to the head of the queue where items will be removed from.
	 */
	private Node head;
	
	/**
	 * A reference to the tail of the queue where items will be added to.
	 */
	private Node tail;
	
	/**
	 * @return <code>true</code> if tail is null as it means that the queue is empty. 
	 * <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * @return the value at the front of the queue.
	 */
	public int peek() {
		if (head == null) {
			return -1;
		}
		return head.getValue();
	}

	/**
	 * @return the value at the front of the queue whilst also
	 * removing the item from the queue.
	 */
	public int dequeue() {
		if (head == null) {
			tail = null;
			return -1;
		}
		int value = head.getValue();
		head = head.getNextNode(); // The new head is the next node in the list.
		return value;
	}
	
	/**
	 * Add an item to the queue.
	 * @param value - The value to add to the queue.
	 */
	public void enqueue(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		tail.setNextNode(newNode); // Point the current tail to the new item.
		tail = newNode; // The new item becomes the new tail.
	}
}
