package com.dataStructures.main;

/**
 * The HashTableMain.
 * <p>
 * This is the program main for the hash table example. In this
 * example, a hash table will be created and a few elements added
 * and removed.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class HashTableMain {

	/**
	 * The program main.
	 * @param args - command line arguments.
	 */
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		
		Employee employee1 = new Employee("123456789", "John", "Citizen");
		Employee employee2 = new Employee("987654321", "Sarah", "Montague");
		Employee employee3 = new Employee("132432", "Bill", "Pompom");
		Employee employee4 = new Employee("266446663", "lliB", "Troll");
		
		hashTable.put("John", employee1);
		hashTable.put("Sarah", employee2);
		hashTable.put("Bill", employee3);
		hashTable.put("lliB", employee4);
		
		printEmployeeInfo(hashTable.get("Sarah"));
		System.out.println();
		printEmployeeInfo(hashTable.get("Donald"));
		System.out.println();
		System.out.println("Number of elements in the hashtable: " + hashTable.getSize());
		
		hashTable.remove("Bill");
		System.out.println("Number of elements in the hashtable: " + hashTable.getSize());
		printEmployeeInfo(hashTable.get("Bill"));
		printEmployeeInfo(hashTable.get("lliB"));
	}
	
	/**
	 * @param employee - The employee info.
	 */
	private static void printEmployeeInfo(Employee employee) {
		if (employee != null) {
			System.out.println("Employee ID: " + employee.getID());
			System.out.println("Employee First Name: " + employee.getFirstName());
			System.out.println("Employee Surname: " + employee.getSurname());
		}
		else {
			System.out.println("Employee does not exist");
		}
	}
}
