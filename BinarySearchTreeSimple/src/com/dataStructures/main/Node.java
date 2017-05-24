package com.dataStructures.main;

/**
 * The node.
 * <p>
 * This class represents an individual node in a binary search tree. It
 * is responsible for holding the value, and passing on instructions
 * to its children.
 * <p>
 * <b>Warning: </b> This is a simple example of a binary search tree and
 * does not contain a delete function.
 * <p>
 * @author szeyick
 */
public class Node {

	/**
	 * Node reference to the left child.
	 */
	private Node leftChild;
	
	/**
	 * Node reference to the right child.
	 */
	private Node rightChild;
	
	/**
	 * The value held by the node.
	 */
	private int value;
	
	/**
	 * Constructor.
	 * @param value - The value assigned to the node.
	 */
	public Node(int value) {
		this.value = value;
	}
	
	/**
	 * Insert a value to the node.
	 * @param valueToInsert - The value to insert.
	 */
	public void insert(int valueToInsert) {
		if (valueToInsert <= this.value) {
			if (leftChild != null) {
				// Traverse down the tree if the current node already has a child.
				leftChild.insert(valueToInsert);
			}
			else {
				// Insert the value as the current nodes left child if it doesn't have one.
				leftChild = new Node(valueToInsert);
			}
		}
		else {
			if (rightChild != null) {
				rightChild.insert(valueToInsert);
			}
			else {
				rightChild = new Node(valueToInsert);
			}
		}
	}
	
	/**
	 * Evaluate if a value is in the tree.
	 * @param valueToFind - The value to look for.
	 * @return <code>true</code> if the value exists, <code>false</code> otherwise.
	 */
	public boolean contains(int valueToFind) {
		if (valueToFind == this.value) {
			return true; // The current node contains the value we are lookign for.
		}
		else if (valueToFind < this.value) {
			if (leftChild != null) {
				return leftChild.contains(valueToFind);
			}
			else {
				return false;
			}
		}
		else {
			if (rightChild != null) {
				return rightChild.contains(valueToFind);
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * Traverse the node inorder and print the values. An inorder
	 * traversal is, left node, root node and right node.
	 */
	public void printInOrder() {
		if (leftChild != null) {
			leftChild.printInOrder();
		}
		System.out.print(this.value + " ");
		if (rightChild != null) {
			rightChild.printInOrder();
		}
	}
	
	/**
	 * Traverse the node in preorder and print the values. A preorder
	 * traversal is root node, left node, right node.
	 */
	public void printPreOrder() {
		System.out.print(this.value + " ");
		if (leftChild != null) {
			leftChild.printPreOrder();
		}
		if (rightChild != null) {
			rightChild.printPreOrder();
		}
	}
	
	/**
	 * Traverse the node in post order and print the values. A post order
	 * traversal is the left node, then right node, then the root node.
	 */
	public void printPostOrder() {
		if (leftChild != null) {
			leftChild.printPostOrder();
		}
		if (rightChild != null) {
			rightChild.printPostOrder();
		}
		System.out.print(this.value + " ");
	}
}
