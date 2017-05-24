package com.dataStructures.main;

/**
 * The Node.
 * <p>
 * This class is responsible for holding data for
 * a single element. It is used for both stacks and
 * queues and functions like a linked list as it contains
 * references to its successor nodes.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class Node {

	/**
	 * The value stored in this node.
	 */
	private int value;
	
	/**
	 * A reference to the next node.
	 */
	private Node nextNode;
	
	/**
	 * Constructor.
	 * @param value - The value to add to this node.
	 */
	public Node(int value) {
		this.value = value;
	}
	
	/**
	 * @return the value stored in the node.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * @return - the successor node.
	 */
	public Node getNextNode() {
		return nextNode;
	}
	
	/**
	 * @param nextNode - the successor node to set.
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
