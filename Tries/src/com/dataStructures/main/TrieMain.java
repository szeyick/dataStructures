package com.dataStructures.main;

/**
 * The TrieMain.
 * <p>
 * This is the program main for demonstrating how a
 * trie works.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class TrieMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node trie = new Node();
		trie.addNode("hello", 0);
		trie.addNode("help", 0);
		trie.addNode("special", 0);
		trie.addNode("space", 0);
		trie.addNode("spatula", 0);
		
		System.out.println("Do these words exist - ");
		System.out.println("hello - " + trie.wordExists("hello", 0));
		System.out.println("hell - " + trie.wordExists("hell", 0));
		System.out.println("space - " + trie.wordExists("space", 0));
		System.out.println("spa - " + trie.wordExists("spa", 0));
		System.out.println("sparrow - " + trie.wordExists("sparrow", 0));
	}

}
