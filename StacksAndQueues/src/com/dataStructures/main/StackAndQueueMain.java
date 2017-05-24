package com.dataStructures.main;

/**
 * The StackAndQueueMain.
 * <p>
 * This is the program main for this project that
 * demonstrates in a simple example, how stacks and 
 * queues work.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class StackAndQueueMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("Item at the top of the stack (5) - " + stack.peek());
		System.out.println("Popped item off the stack (5) - " + stack.pop());
		System.out.println("Popped item off the stack (4) - " + stack.pop());
		System.out.println("Popped item off the stack (3) - " + stack.pop());
		System.out.println("Popped item off the stack (2) - " + stack.pop());
		System.out.println("Popped item off the stack (1) - " + stack.pop());
		System.out.println("Popped item off the stack (-1 Empty) - " + stack.pop());
		
		stack.push(100);
		System.out.println("Item at the top of the stack (100) - " + stack.peek());
		
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Item at the head of the queue (1) - " + queue.peek());
		System.out.println("Removed item from queue (1) - " + queue.dequeue());
		System.out.println("Removed item from queue (2) - " + queue.dequeue());
		System.out.println("Removed item from queue (3) - " + queue.dequeue());
		System.out.println("Removed item from queue (4) - " + queue.dequeue());
		System.out.println("Removed item from queue (5) - " + queue.dequeue());
		System.out.println("Queue is empty (-1) - " + queue.dequeue());
		queue.enqueue(100);
		System.out.println("Item at the head of the queue (100) - " + queue.peek());
	}
}
