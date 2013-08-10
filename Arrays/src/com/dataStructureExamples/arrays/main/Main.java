package com.dataStructureExamples.arrays.main;

import java.util.Scanner;

import com.dataStructureExamples.arrays.dynamicArray.DynamicArray;

/**
 * Main class that runs the program.
 * 
 * @author szeyick
 *
 */
public class Main {

	private static DynamicArray dynamicArray;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		dynamicArray = new DynamicArray();
		dynamicArray.createArrayWithSize(1);
		userSelection();
	}
	
	/**
	 * Menu options for user interaction with the program
	 */
	private static void userSelection() {
		while (true) {
			Utilities.menu();
			int menuOption = new Scanner(System.in).nextInt();
			int valueToInsert;
			int indexInput;
			
			switch (menuOption) {
			case 1:
				System.out.print("Enter the value of the item to add: ");
				valueToInsert = new Scanner(System.in).nextInt();
				dynamicArray.insertAtEnd(valueToInsert);
				System.out.println();
				break;
			case 2:
				System.out.print("Removing item from the end of array...");
				dynamicArray.removeFromEnd();
				System.out.println();
				break;
			case 3:
				System.out.print("Enter the value of the item to add: ");
				valueToInsert = new Scanner(System.in).nextInt();
				System.out.print("Enter the index of item to insert: ");
				indexInput = new Scanner(System.in).nextInt();
				boolean itemInserted = dynamicArray.insertItemIntoIndex(valueToInsert, indexInput);
				System.out.println("Item has been inserted: " + itemInserted);
				System.out.println();
				break;
			case 4:
				System.out.print("Enter the index of item to remove: ");
				indexInput = new Scanner(System.in).nextInt();
				boolean itemRemoved = dynamicArray.removeItemFromIndex(indexInput);
				System.out.println("Item has been removed: " + itemRemoved);
				System.out.println();
				break;
			case 5:
				System.out.println("The logical size of the array: " + dynamicArray.getLogicalSize());
				System.out.println("The capacity of the array: " + dynamicArray.getArrayCapacity());
				System.out.println();
				break;
			case 6:
				System.out.println("The contents of the array");
				dynamicArray.printArrayContents();
				System.out.println();
				break;
			case 7:
				System.exit(0);
			default:
				System.err.println("Invalid Menu Option");
				System.out.println();
				break;
			}
		}
	}

}
