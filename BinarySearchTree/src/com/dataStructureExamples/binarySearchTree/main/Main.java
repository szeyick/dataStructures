package com.dataStructureExamples.binarySearchTree.main;

import com.dataStructureExamples.binarySearchTree.BinarySearchTree;

/**
 * The {@link Main} class.
 * <p>
 * This class is runnable and demonstrates the various
 * features of a binary search tree including -
 * <ol>
 * <li>Preorder, Inorder and Post order traversal.</li>
 * <li>Inserting an item into a BST (building BST's). </li>
 * <li>Searching for an item in the BST.</li>
 * <li>Removing an item from the BST. </li>
 * </ol>
 * <p>
 * @author szeyick
 */
public class Main {

	/**
	 * The program main.
	 * @param args - The command line arguement.
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = buildTree();

		printTreeOrder(bst);
		searchForItem(bst);
		removeItem(bst);
	}

	/**
	 * Build a binary search tree by creating the 
	 * {@link BinarySearchTree} object and then inserting
	 * a group of items into the tree. 
	 * <p>
	 * @return - A constructed binary search tree.
	 */
	private static BinarySearchTree buildTree() {
		BinarySearchTree bst = new BinarySearchTree();
		
		// Create the tree structure by inserting values.
		bst.insertItem(8);
		bst.insertItem(3);
		bst.insertItem(10);
		bst.insertItem(1);
		bst.insertItem(6);
		bst.insertItem(7);
		bst.insertItem(4);
		bst.insertItem(14);
		bst.insertItem(13);
		return bst;
	}
	
	/**
	 * Remove an item from the binary search tree.
	 * <p>
	 * @param bst - The binary search tree to remove item from.
	 */
	private static void removeItem(BinarySearchTree bst) {
		// Print the current structure of the tree (pre-order)
		System.out.print("BST Values (Before Removal) - "); 
		bst.printTreePreOrder();
		bst.removeItemFromTree(4);
		System.out.println();
		System.out.print("BST Values (After Removal) - "); 
		bst.printTreePreOrder();
		
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Search for various items in the binary search tree to determine
	 * if they exist.
	 * @param bst - The binary search tree to search.
	 */
	private static void searchForItem(BinarySearchTree bst) {
		System.out.println("Searching for items...");
		printMessage(bst.isValueInTree(99), 99);
		printMessage(bst.isValueInTree(8), 8);
		System.out.println();
		System.out.println();
	}
	
	private static void printMessage(boolean isItemInTree, int searchValue) {
		if (isItemInTree) {
			System.out.println("Item exists in the BST - " + searchValue);
		}
		else {
			System.out.println("Item not found in the BST - " + searchValue);
		}
	}
	
	/**
	 * Print the inorder, preorder and post order traversals of 
	 * the BST.
	 * @param bst - The binary search tree to print.
	 */
	private static void printTreeOrder(BinarySearchTree bst) {
		System.out.print("Inorder Traversal -- ");
		bst.printTreeInOrder();
		System.out.println();
		System.out.println("----------------------");
		System.out.print("Pre Order Traversal -- ");
		bst.printTreePreOrder();
		System.out.println();
		System.out.println("----------------------");
		System.out.print("Post Order Traversal -- ");
		bst.printPostOrder();
		System.out.println();
		System.out.println("----------------------");	
		System.out.println();
		System.out.println();
	}
}
