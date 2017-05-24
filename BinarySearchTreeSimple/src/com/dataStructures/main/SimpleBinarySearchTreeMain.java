package com.dataStructures.main;

/**
 * The SimpleBinarySearchTreeMain.
 * <p>
 * This class provides a small demo on a simple binary search tree. We
 * insert items, search for items and print in post-order, pre-order and in-order.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class SimpleBinarySearchTreeMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node root = new Node(10);
		root.insert(5);
		root.insert(15);
		root.insert(8);
		
		System.out.println("Does 8 exist in the tree - " + root.contains(8));
		System.out.println("Does 100 exist in the tree - " + root.contains(100));
		
		System.out.print("Printing elements in order - ");
		root.printInOrder();
		System.out.println();
		
		System.out.print("Printing elements in pre order - ");
		root.printPreOrder();
		
		System.out.println();
		System.out.print("Printing elements in post order - ");
		root.printPostOrder();
	}
}
