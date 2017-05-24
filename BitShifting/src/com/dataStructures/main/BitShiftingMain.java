package com.dataStructures.main;

/**
 * The BitShiftingMain.
 * <p>
 * This class is responsible for demonstrating how to programatically
 * shift bits.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class BitShiftingMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		byte value = -23;
		System.out.println("The current value is: " + value);
		
		byte rightShiftValue = (byte) (value >> 1);
		System.out.println("The shifted to the right value is: " + rightShiftValue);

		byte leftShiftValue = (byte) (value << 1);
		System.out.println("The shifted to the left value is: " + leftShiftValue);

		int myValue = 2;
		System.out.println("Value should be 4: " + (myValue << 1));
		
		int shift2 = 1 << 2; // 4
		System.out.println("The shift value is 4: " + shift2);
		System.out.println("The value is 6: " + (myValue | shift2));
		System.out.println("The value is 0: " + (myValue & shift2));
		
		int shift3 = 1 << 3; // 8
		System.out.println("The shift value is 8: " + shift3);		
		System.out.println("The XOR value is 0: " + (8 ^ shift3));
	}

}
