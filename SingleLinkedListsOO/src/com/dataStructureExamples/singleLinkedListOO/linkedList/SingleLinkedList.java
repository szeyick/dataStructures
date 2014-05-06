package com.dataStructureExamples.singleLinkedListOO.linkedList;

/**
 * The SingleLinkedList class.
 * 
 * This class is an OO representation of
 * a Single Linked List. The main idea with
 * this implementation is to encapsulate the 
 * data contained within each node.
 * 
 * Instead of accessing the node data and values
 * directly, outside classes must invoke methods on 
 * the SingleLinkedList object to perform the linked
 * list operations (search, insertion, deletion).
 * 
 * @author szeyick
 *
 */
public class SingleLinkedList {

	/**
	 * Reference to the head of the Single Linked List.
	 */
	private Node head;
	
	/**
	 * Reference to the tail of the Single Linked List.
	 */
	private Node tail;
	
	/**
	 * The object constructor.
	 */
	public SingleLinkedList() {
		head = null;
		tail = null;
	}
	
	/**
	 * Delete an item from the linked list.
	 * @param name - The name of the node to remove.
	 * @return <code>true</code>if item has been removed successfully
	 * <code>false</code> otherwise.
	 */
	public boolean deleteItemFromList(String name) {
		boolean isRemoved = false;
		
		Node targetNode = recursiveSearchSingleLinkedList(head, name);
		// Only continue to remove if there is a found node to remove.
		if (targetNode != null) {
			connectPredecessorAndSuccessor(targetNode);
			isRemoved = true;
		}
		return isRemoved;
	}
	
	/**
	 * Connect the predecessor and successor nodes together.
	 *
	 * The aim here is to connect the successor to the predecessors nextNode.
	 * 
	 * @param nodeToRemove - The node that we wish to remove.
	 * @return - The modified list without the removed item.
	 */
	private void connectPredecessorAndSuccessor(Node nodeToRemove) {
		Node predecessor = findPredecessor(nodeToRemove, head);
		
		// Predecessor can be null if the node to remove
		// is at the head of the list. In this case we need
		// to set the current nextNode to be the new head of
		// the list.
		if (predecessor == null) {
			head = nodeToRemove.nextNode;
			// If the node to remove is the current tail we need to update the reference
			if (nodeToRemove.equals(tail)) {
				tail = head;
			}
		}
		else {
			// If the node to remove is the current tail we need to update the reference
			if (nodeToRemove.equals(tail)) {
				tail = predecessor;
			}
			// Otherwise we join the predecessor to the successor.
			predecessor.nextNode = nodeToRemove.nextNode;
		}

	}
	
	/**
	 * Find the predecessor node of a given node. 
	 * 
	 * @param targetNode - The target node.
	 * @param currentNode - The current node.
	 * @return The predecessor if found, null if empty
	 */
	private Node findPredecessor(Node targetNode, Node currentNode) {

		// If there is no current node, the list is empty.
		if (currentNode == null) {
			return null;
		}
		// Check if the successor is the target node.
		if (targetNode.equals(currentNode.nextNode)) {
			return currentNode;
		}
		else {
			// Continue through the list to find the predecessor.
			return findPredecessor(targetNode, currentNode.nextNode);
		}
	}
	
	/**
	 * Method to print the contents of the linked list.
	 */
	public void printListContents() {
		Node currentNode = head;
		// Iterate through the list and print
		while (currentNode != null) {
			System.out.print(currentNode.name + "-->");
			currentNode = currentNode.nextNode;
		}
		System.out.print("null");
	}
	
	/**
	 * Insert an item into a linked list.
	 * 
	 * @param head - The current head of the list.
	 * @param name - The item to insert into the new node.
	 * @return newNode - The new node, that is the head of the list.
	 */
	public void insertItemIntoHead(String name) {
		Node newNode = new Node(name); // Create the new item
		
		// Update the current head of the list to be the nextNode of
		// the newly created node.
		newNode.nextNode = head; 
		
		// Update the tail reference to the end of the list.
		tail = head;
		
		// Assign the newly created node as the head of the list.
		head = newNode;
	}
	
	/**
	 * Insert an item to the end of a linked list. 
	 * 
	 * We require a null check for the tail in the case
	 * for an empty list. 
	 * 
	 * @param name - The item to insert.
	 */
	public void insertItemIntoTail(String name) {
		Node newNode = new Node(name);

		// Insert the new node as the tails successor, if exists.
		if (tail != null) {
			tail.nextNode = newNode;
		}

		// Update the reference to the tail.
		tail = newNode;
		
		// Update reference to the head if list is empty.
		if (head == null) {
			head = tail;
		}
	}
	
	/**
	 * Iteratively search the linked list for a value.
	 * 
	 * @param name - The name of the item to search for.
	 * @return the {@link Node} if found, null otherwise.
	 */
	public boolean iterativeSearch(String name) {
		if (iterativeSearchSingleLinkedList(name) != null) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	/**
	 * Searching a Single Linked List through iteration.
	 * 
	 * @param item - the item which we are to search for.
	 * @return <code>true</code> if we find the name in our list, 
	 * <code>false</code> otherwise.
	 */
	private Node iterativeSearchSingleLinkedList(String name) {
		
		Node foundNode = null; // reference to the found node.
		Node currentNode = head; // reference to the current node we are looking at. 
		
		// We iterate through our linked list, until we have no more nodes to 
		// look at (Condition #2)
		while (currentNode != null) {
			// If the current node contains the name we are looking for
			// then we have found the name in our list and can return true
			// to indicate that we have found it. Because we have found it
			// we can also break out of this loop. (Condition #1)
			if (currentNode.name.equals(name)) {
				foundNode = currentNode;
				break;
			}
			
			// If we have not found it we need to continue searching in the
			// next node.
			currentNode = currentNode.nextNode;
		}
		return foundNode;
	}
	
	/**
	 * Recursively search the linked list for a value.
	 * @param name - The name of the item to search for.
	 * @return the {@link Node} if found, null otherwise.
	 */
	public boolean recursiveSearch(String name) {
		if (recursiveSearchSingleLinkedList(head, name) != null) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	/**
	 * Searching through a Single Linked List recursively. The
	 * idea with recursion is that we reduce the size of the input
	 * each time it calls itself.
	 * 
	 * @param currentNode - the head or start of our linked list.
	 * @param name - the name that we are searching for.
	 * @return <code>true</code> if the name is in 
	 */
	private Node recursiveSearchSingleLinkedList(Node currentNode, String name) {
		
		// If the current head is null, it means we've
		// reached the end of our list. (Condition #2)
		if (currentNode == null) {
			return null;
		}
		
		// If the current node contains the name we're
		// looking for, we can return true (Condition #1)
		if (currentNode.name.equals(name)) {
			return currentNode;
		}
		else {
			// If we've not satisfied either condition, we must call the
			// method again but with the next node, reducing the list size.
			return recursiveSearchSingleLinkedList(currentNode.nextNode, name);
		}
	}
	
	/**
	 * Inner class representation of the node
	 * object. The instance variables for the value
	 * and next node are only accessible directly by the 
	 * SingleLinkedList class.
	 * 
	 * @author szeyick
	 */
	private class Node {
		
		/**
		 * The name value associated with this node.
		 */
		public String name;
		
		/**
		 * Reference to the current nodes successor.
		 */
		public Node nextNode;
		
		/**
		 * Constructor to build the node
		 * @param nameTmp - The name to assign to this node.
		 */
		public Node (String nameTmp) {
			name = nameTmp;
		}
	}
}
