package com.dataStructures.main;

/**
 * The Employee.
 * <p>
 * This class functions as a container to store information
 * about an individual employee.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class Employee {

	/**
	 * The ID.
	 */
	private String id;
	
	/**
	 * Employee first name.
	 */
	private String firstname;
	
	/**
	 * Employee surname.
	 */
	private String surname;
	
	/**
	 * Constructor.
	 * @param id - Employee ID.
	 * @param firstname - The employee first name.
	 * @param surname - The employee surname.
	 */
	public Employee(String id, String firstname, String surname) {
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
	}
	
	/**
	 * @return the employee id.
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * @return the employee first name.
	 */
	public String getFirstName() {
		return firstname;
	}
	
	/**
	 * @return the employee surname.
	 */
	public String getSurname() {
		return surname;
	}
}
