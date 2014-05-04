package com.dataStructureExamples.singleLinkedLists;

import com.dataStructureExamples.singleLinkedLists.node.Node;

/**
 * The DeleteNodeFromSingleLinkedList class.
 * <p>
 * This class is a runnable program and is designed
 * to demonstrate the steps that are involved with
 * inserting an item into a the end of a single linked
 * list.
 * <p>
 * The purpose of this class is to demonstrate the functions
 * required to remove an item from a single linked list without
 * delving into a OO structure for a linked list.
 * 
 * @author szeyick
 *
 */
public class DeleteNodeFromSingleLinkedList {

	/**
	 * The program main
	 * @param args - program arguments. 
	 */
	public static void main(String[] args) {
		Node linkedList = buildLinkedList();
		printListContents(linkedList);

		Node targetNode = recursiveSearchSingleLinkedList(linkedList, "Stuart");
		// Only continue to remove if there is a found node to remove.
		if (targetNode != null) {
			linkedList = connectPredecessorAndSuccessor(targetNode, linkedList);
		}
		
		// Print the list after the removal is complete.
		printListContents(linkedList);
	}
	
	/**
	 * Connect the predecessor and successor nodes together.
	 *
	 * The aim here is to connect the successor to the predecessors nextNode.
	 * 
	 * @param nodeToRemove - The node that we wish to remove.
	 * @return - The modified list without the removed item.
	 */
	public static Node connectPredecessorAndSuccessor(Node nodeToRemove, Node linkedList) {
		Node predecessor = findPredecessor(nodeToRemove, linkedList);
		
		// Predecessor can be null if the node to remove
		// is at the head of the list. In this case we need
		// to set the current nextNode to be the new head of
		// the list.
		if (predecessor == null) {
			linkedList = nodeToRemove.getNext();
		}
		else {
			// Otherwise we join the predecessor to the successor.
			predecessor.setNext(nodeToRemove.getNext());
		}
		return linkedList;
	}

	/**
	 * Find the predecessor node of a given node. 
	 * 
	 * @param targetNode - The target node.
	 * @param currentNode - The current node.
	 * @return The predecessor if found, null if empty
	 */
	public static Node findPredecessor(Node targetNode, Node currentNode) {

		// If there is no current node, the list is empty.
		if (currentNode == null) {
			return null;
		}
		// Check if the successor is the target node.
		if (targetNode.equals(currentNode.getNext())) {
			return currentNode;
		}
		else {
			// Continue through the list to find the predecessor.
			return findPredecessor(targetNode, currentNode.getNext());
		}
	}
	
	/**
	 * Searching through a Single Linked List recursively. The
	 * idea with recursion is that we reduce the size of the input
	 * each time it calls itself.
	 * 
	 * @param head - the head or start of our linked list.
	 * @param name - the name that we are searching for.
	 * @return the node that matches the search string parameter, or null.
	 */
	public static Node recursiveSearchSingleLinkedList(Node head, String name) {

		// If the current head is null, it means we've
		// reached the end of our list. (Condition #2)
		if (head == null) {
			return null;
		}

		// If the current node contains the name we're
		// looking for, we can return true (Condition #1)
		if (head.getName().equals(name)) {
			return head;
		}
		else {
			// If we've not satisfied either condition, we must call the
			// method again but with the next node, reducing the list size.
			return recursiveSearchSingleLinkedList(head.getNext(), name);
		}
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
	/**
	 * A convenience method to build a simple single
	 * linked list. 
	 * 
	 * The structure for this list follows the examples from
	 * the Single Linked Lists tutorial located at -
	 * 
	 * The structure of the list is the following -
	 * 
	 * head -> Jerry -> Dave -> Stuart -> null
	 * 
	 * @return the constructed linked list as a {@link Node}
	 */
	public static Node buildLinkedList() {
		// Create our individual nodes.
		Node jerry = new Node("Jerry");
		Node dave = new Node("Dave");
		Node stuart = new Node("Stuart");

		// Connect the nodes John -> Sue -> Dave
		jerry.setNext(dave);
		dave.setNext(stuart);

		// Return the node "John" as the head of our list.
		return jerry;
	}
}
