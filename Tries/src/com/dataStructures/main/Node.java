package com.dataStructures.main;

import java.util.HashMap;
import java.util.Map;

/**
 * The Node.
 * <p>
 * This node class is used to represent a trie.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class Node {

	/**
	 * A collection of the nodes children.
	 */
	private Map<String, Node> children;

	/**
	 * Constructor.
	 */
	public Node() {
		children = new HashMap<>();
	}
	
	/**
	 * Perform a look up to see if the current node has a child
	 * that is keyed by the character.
	 * @param character - The character to find the child of.
	 * @return the child node representing the character, null otherwise.
	 */
	private Node getNode(String character) {
		return children.get(character);
	}
	
	/**
	 * Set the node as a child of this node.
	 * @param character - The character to key the node.
	 * @param childNode - The child node to set.
	 */
	private void setNode(String character, Node childNode) {
		children.put(character, childNode);
	}
	
	/**
	 * Add a character to the trie.
	 * @param substring - The substring to add.
	 * @param index - The index of the character.
	 */
	public void addNode(String word, int index) {
		if (index == word.length()) {
			return; // return when all the letters have been added
		}
		String character = String.valueOf(word.charAt(index));
		Node childNode = getNode(character);
		if (childNode == null) {
			childNode = new Node();
			setNode(character, childNode);
		}
		childNode.addNode(word, index + 1);
	}
	
	/**
	 * Determine if the word exists in the trie.
	 * @param word - The word to find.
	 * @param index - The current index within the word.
	 * @return <code>true</code> if the word exists in the trie, <code>false</code> otherwise.
	 */
	public boolean wordExists(String word, int index) {
		if (index == word.length()) {
			return true; // Word exists if we get to the end.
		}
		String character = String.valueOf(word.charAt(index));
		Node childNode = getNode(character);
		if (childNode == null) {
			return false; // Word doesn't exist.
		}
		else {
			return childNode.wordExists(word, index + 1);
		}
	}
}