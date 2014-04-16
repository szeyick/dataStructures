package com.dataStructureExamples.linkedLists.node;

/**
 * The Node class represents a single node
 * in a linked structure.
 * 
 * A node acts as container to allow us to
 * store data.
 * 
 * @author Sze Yick.
 */
public class SingleLinkedListNode {

	/**
	 * The data that this node holds.
	 */
	private String name;

	/**
	 * The pointer to the next node.
	 */
	private SingleLinkedListNode nextNode;
	
	/**
	 * The constructor to initialise the new node.
	 * @param nameTmp - The name to store in this node.
	 */
	public SingleLinkedListNode(String nameTmp) {
		name = nameTmp;
		nextNode = null;
	}
	
	/**
	 * Getter method to return the data in the name field.
	 * @return The name in this node as a {@link String}
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method to return the next node. The node
	 * to be returned is the one that this node points to.
	 * @return The next node as a {@link SingleLinkedListNode}
	 */
	public SingleLinkedListNode getNext() {
		return nextNode;
	}

	/**
	 * Set the pointer for this node to point
	 * to another node, creating the link.
	 * @param nextNodeTmp - The node to connect to.
	 */
	public void setNext(SingleLinkedListNode nextNodeTmp) {
		nextNode = nextNodeTmp;
	}
}
