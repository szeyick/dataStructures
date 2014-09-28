package com.dataStructureExamples.binarySearchTree;

/**
 * The {@link BinarySearchTree}
 * <p>
 * This class represents a BST. The
 * tree is constructed by creating an
 * instance of this class and then adding
 * new {@link Nodes} to it. 
 * 
 * @author szeyick
 */
public class BinarySearchTree {

	/**
	 * The root of the BST.
	 */
	private Node root;
	
	/**
	 * Constructor.
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * Method to print the contents of the tree.
	 */
	public void printTreeInOrder() {
		printInOrder(root);
	}
	
	/**
	 * Method to print the contents of the tree.
	 */
	public void printTreePreOrder() {
		printPreOrder(root);
	}
	
	/**
	 * Method to print the contents of the tree.
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	/**
	 * Method to print the in order traversal
	 * of the created tree. As the name suggests we
	 * traverse "in order" so since we know the relationships
	 * that each node has with its children, the in order traversal
	 * would be left child, current node, right child. 
	 * <p>
	 * @param currentNode - The current node 
	 * being inspected. 
	 */
	private void printInOrder(Node currentNode) {
		if (currentNode != null) {
			printInOrder(currentNode.leftChild);
			System.out.print(currentNode.value + " ");
			printInOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * Method to print the pre-order traversal
	 * of the created tree. With pre-order traversal, the
	 * order which we are aiming for is current node, left child
	 * and then right child. 
	 * <p>
	 * @param currentNode - The current node being inspected. 
	 */
	private void printPreOrder(Node currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.value + " ");
			printPreOrder(currentNode.leftChild);
			printPreOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * Method to print the post-order traversal
	 * of the create tree. With post-order traversal, the idea
	 * is to print a level of the tree at a time. The order in 
	 * which it will be performed would be, left child, right child
	 * and then the current node.
	 * <p>
	 * @param currentNode - The current node being inspected.
	 */
	private void printPostOrder(Node currentNode) {
		if (currentNode != null) {
			printPostOrder(currentNode.leftChild);
			printPostOrder(currentNode.rightChild);
			System.out.print(currentNode.value + " ");
		}
	}
	
	/**
	 * Remove an item from the BST.
	 * @param value - The value to delete.
	 * @return <code>true</code> if deletion was 
	 * successful, <code>false</code> otherwise.
	 */
	public boolean removeItemFromTree(int value) {
		return remove(root, root, value);
	}
	
	/**
	 * Remove an item from the BST
	 * @param currentNode - The current root node.
	 * @param value - The value to remove.
	 * @return <code>true</code> if item is removed, 
	 * <code>false</code> otherwise.
	 */
	private boolean remove(Node currentNode, Node parent, int value) {
		Node nodeToRemove = search(currentNode, value);
		Node parentNode = findParent(parent, nodeToRemove);
		
		if (nodeToRemove == null) {
			return false; // No node to remove.
		}
		// Case 3 - Node to remove has 2 children
		if (nodeToRemove.leftChild != null && nodeToRemove.rightChild != null) {
			Node min = findMin(nodeToRemove.rightChild); // Find the smallest node in the right tree.
			nodeToRemove.value = min.value; // Swap the values
			return remove(nodeToRemove.rightChild, nodeToRemove, min.value); // Remove the min value from the right tree 
		}
		// Case 1 - Node has no children
		if (nodeToRemove.leftChild == null && nodeToRemove.rightChild == null) {
			if (nodeToRemove == root) {
				root = null; // If removed node is the root node, then our tree will be empty.
				return true;
			}
			if (parentNode.leftChild == nodeToRemove) { // If the node to remove is the left child of the parent
				parentNode.leftChild = null; // No children so we can directly set to null.
			}
			else {
				parentNode.rightChild = null; // No children to replace to set to null.
			}
			return true;
		}
		// Case 2 - Node has 1 child (either left or right)
		if (nodeToRemove.leftChild != null) { // The left child is not null.
			if (nodeToRemove == root) {
				root = nodeToRemove.leftChild;
				return true;
			}
			if (parentNode.leftChild == nodeToRemove) { // If the node to remove is the left of the parent
				parentNode.leftChild = nodeToRemove.leftChild;
				return true;
			}
			else {
				parentNode.rightChild = nodeToRemove.leftChild;
			}
		}
		else {
			// Right child is not null
			if (nodeToRemove == root) {
				root = nodeToRemove.rightChild;
				return true;
			}
			if (parentNode.leftChild == nodeToRemove) {
				parentNode.leftChild = nodeToRemove.rightChild;
				return true;
			}
			else {
				parentNode.rightChild = nodeToRemove.rightChild;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to find the parent of a given node. 
	 * <p>
	 * @param currentNode - The current node.
	 * @param nodeToRemove - The node that we want to remove.
	 * @return - The parent of the node that we want to remove.
	 */
	private Node findParent(Node currentNode, Node nodeToRemove) {
		if (nodeToRemove == root) {
			return null;
		}
		if ((currentNode.leftChild == nodeToRemove) || (currentNode.rightChild == nodeToRemove)) {
			return currentNode;
		}
		if (nodeToRemove.value < currentNode.value) {
			return findParent(currentNode.leftChild, nodeToRemove);
		}
		else {
			return findParent(currentNode.rightChild, nodeToRemove);
		}
	}
	
	/**
	 * Find the node in the BST that contains
	 * the smallest item.
	 * @param currentNode - The current node inspected
	 * @return - the minimum node as a {@link Node}.
	 */
	private Node findMin(Node currentNode) {
		if (currentNode.leftChild == null) {
			return currentNode;
		}
		else {
			return findMin(currentNode.leftChild);
		}
	}
	
	/**
	 * Public method to insert an item into
	 * the BST.
	 * @param value - The value to insert.
	 * @return - <code>true</code> if item was
	 * inserted, <code>false</code> otherwise.
	 */
	public boolean insertItem(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		else {
			return insert(root, value);
		}
	}
	
	/**
	 * Recursively insert a value into the BST.
	 * @param currentNode - The current node inspected.
	 * @param value - The value to insert.
	 * @return <code>true</code> if item was inserted,
	 * <code>false</code> otherwise.
	 */
	private boolean insert(Node currentNode, int value) {
		if (currentNode.value == value) {
			return false; // Do not insert duplicate items
		}
		if (value < currentNode.value) {
			// Insert the item into the left subtree if the
			// current node has no left children.
			if (currentNode.leftChild == null) {
				currentNode.leftChild = new Node(value);
				return true;
			}
			else {
				// Otherwise continue down the tree.
				return insert(currentNode.leftChild, value);
			}
		}
		else {
			if (currentNode.rightChild == null) {
				currentNode.rightChild = new Node(value);
				return true;
			}
			else {
				return insert(currentNode.rightChild, value);
			}
		}
	}
	
	/**
	 * Public method to see if value exists
	 * in the BST.
	 * @param value - The value to search.
	 * @return - <code>true</code> if the value 
	 * exists, <code>false</code> otherwise.
	 */
	public boolean isValueInTree(int value) {
		Node foundNode = search(root, value);
		if (foundNode == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Method to recursively search the BST for a value.
	 * @param currentNode - The current node.
	 * @param value - The value to find.
	 * @return - The {@link Node} holding the value, null
	 * if not found. 
	 */
	private Node search(Node currentNode, int value) {
		if (currentNode == null) { // End of the tree, value
			return null;		   // is not found.
		}
		if (currentNode.value == value) {
			return currentNode; // The current node contains 
								// the value we want so return.
		}
		if (value < currentNode.value) {
			// The value we want is less than the value in the
			// current node, so search its left subtree (child).
			return search(currentNode.leftChild, value); 
		}
		else {
			return search(currentNode.rightChild, value);
		}
	}
	
	/**
	 * The {@link Node} class.
	 * <p>
	 * This class is responsible for providing
	 * the nodes for a binary search tree.
	 * </p> 
	 * @author szeyick
	 */
	private class Node {
		
		/**
		 * The value assigned to the node.
		 */
		public int value;
		
		/**
		 * Pointer reference to the left subtree.
		 */
		public Node leftChild;
		
		/**
		 * Pointer reference to the right subtree.
		 */
		public Node rightChild;
		
		/**
		 * Constructor.
		 * @param valueTmp - The value for this node.
		 */
		public Node(int valueTmp) {
			value = valueTmp;
			leftChild = null;
			rightChild = null;
		}
	}
}
