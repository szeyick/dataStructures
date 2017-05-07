package com.dataStructures.main;

import java.util.LinkedList;

/**
 * The HashTable.
 * <p>
 * This class represents the hash table data structure. This
 * hash table will have the following operations -
 * <p>
 * <p>
 * <ul>
 * <li>Put - Add an item into the has table.</li>
 * <li>Remove - Remove an item from the table.</li>
 * <li>Search - Search for an item in the table.</li>
 * </ul>
 * <p>
 * <b>Warning: </b>This hash table uses chaining to resolve
 * collisions.
 * @author szeyick
 */
public class HashTable {

	/**
	 * The underlying storage structure for the hash table.
	 */
	private LinkedList[] hashTable;
	
	/**
	 * The number of elements in the hash table.
	 */
	private int size;
	
	/**
	 * Constructor.
	 * @param size - The size of the hash table.
	 */
	public HashTable() {
		hashTable = new LinkedList[100];
		hashTable[0] = new LinkedList<TableElement>();
		size = 0;
	}
	
	/**
	 * Add an item to the hash table.
	 * @param key - The key associated to the employee.
	 * @param employee - The data to store in the table.
	 */
	public void put(String key, Employee employee) {
		int hashCode = computeHashCode(key);
		LinkedList<TableElement> list = hashTable[hashCode];
		if (list != null) {
			list.add(new TableElement(key, employee));
			size++;
		}
		else {
			list = new LinkedList<TableElement>();
			list.add(new TableElement(key, employee));
			hashTable[hashCode] = list;
			size++;
		}
	}
	
	/**
	 * Remove an item from the hash table.
	 * @param key - The key associated to the item to remove.
	 * @return the removed item from the table, null otherwise.
	 */
	public Employee remove(String key) {
		Employee employee = null;
		int hashCode = computeHashCode(key);
		LinkedList<TableElement> list = hashTable[hashCode];
		if (list != null) {
			int indexToRemove = -1;
			for (int index = 0; index < list.size(); index++) {
				TableElement tableElement = list.get(index);
				if (tableElement.key.equals(key)) {
					employee = tableElement.employee;
					indexToRemove = index;
					break;
				}
			}
			if (employee != null) {
				list.remove(indexToRemove);
				size--;
			}
		}
		return employee;
	}
	
	/**
	 * Search for an item in the hash table without removing.
	 * @param key - The key associated to the item we are searching for.
	 * @return the found item, null otherwise.
	 */
	public Employee get(String key) {
		Employee employee = null;
		int hashCode = computeHashCode(key);
		LinkedList<TableElement> list = hashTable[hashCode];
		if (list != null) {
			for (TableElement tableElement : list) {
				if (tableElement.key.equals(key)) {
					employee = tableElement.employee;
					break;
				}
			}
		}
		return employee;
	}
	
	/**
	 * @return - Number of elements in the hash table.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Compute a hash code that represents the index to the item.
	 * @param key - The key associated to the item.
	 * @return the hash code from the key.
	 */
	private int computeHashCode(String key) {
		int charSum = 0;
		for (int index = 0; index < key.length(); index++) {
			charSum += key.charAt(index);
		}
		return charSum % 97;
	}
	
	/**
	 * The TableElement.
	 * <p>
	 * This class is responsible for holding the key and object
	 * being stored in the table.
	 * <p>
	 * <b>Warning: </b>None.
	 * @author szeyick
	 */
	private class TableElement {
		
		/**
		 * The user added key.
		 */
		private String key;
		
		/**
		 * The employee data.
		 */
		private Employee employee;
		
		/**
		 * Constructor.
		 */
		public TableElement(String key, Employee employee) {
			this.key = key;
			this.employee = employee;
		}
	}
}
