package com.dataStructures.main;

/**
 * The Stack.
 * <p>
 * This class is responsible for encapsulating the 
 * functionality of a stack.
 * <p>
 * <b>Warning; </b>None.
 * @author szeyick
 */
public class Stack {

	/**
	 * A reference to the node at the top of the stack.
	 */
	private Node top;
	
	/**
	 * @return <code>true</code> if the top is null as it signifies that the
	 * stack is empty, <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * @return the value at the top of the stack.
	 */
	public int peek() {
		if (top == null) {
			return -1;
		}
		return top.getValue();
	}
	
	/**
	 * Push a value onto the stack.
	 * @param value - The value to push.
	 */
	public void push(int value) {
		Node newNode = new Node(value);
		if (top == null) {
			top = newNode;
		}
		else {
			// The new node points to the previous top element.
			newNode.setNextNode(top);
			top = newNode;
		}
	}
	
	/**
	 * @return the popped value off the stack.
	 */
	public int pop() {
		if (top == null) {
			return -1;
		}
		int value = top.getValue();
		if (top.getNextNode() != null) {
			// Current top's next node points to the item below it in the stack.
			top = top.getNextNode();
		}
		else {
			top = null;
		}
		return value;
	}
}
