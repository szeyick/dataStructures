package com.dataStructures.main;

/**
 * The LinkedListMain.
 * <p>
 * This class is responsible for running the demo for a 
 * linked list.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class LinkedListMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.append(12);
		linkedList.append(13);
		linkedList.append(14);
		linkedList.append(15);
		
		linkedList.printList();
		System.out.println();
		
		linkedList.prepend(3);
		linkedList.prepend(2);
		linkedList.prepend(1);
		
		linkedList.printList();
		
		System.out.println();
		
		linkedList.delete(12);
		linkedList.printList();
		
		linkedList.delete(12);
		linkedList.delete(13);
		linkedList.delete(1);
		linkedList.delete(15);
		
		System.out.println();
		linkedList.printList();
		
		linkedList.delete(14);
		linkedList.delete(2);
		linkedList.delete(3);
		
		linkedList.printList();
		
		linkedList.append(100);
		linkedList.printList();
	}

}
