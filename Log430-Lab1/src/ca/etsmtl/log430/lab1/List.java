package ca.etsmtl.log430.lab1;

import java.util.Vector;

/**
 * This is the base class that is used to construct the various list objects
 * used in this application. The storage mechanism used is the Java Vector
 * found in the java.util package.
 * 
 * A vector object is declared and several generic operations are defined for
 * the List class.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.4, 2013-Sep-13
 */

/* Modification Log
 **************************************************************************************
 * v1.4, R. Champagne, 2013-Sep-13 - Various refactorings to make classe
 *       independant of future changes..
 * 
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 *  
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS. 
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 **************************************************************************************/

public class List {

	/**
	 * The list of items. Allocates 25 elements initially and will extend the
	 * vector by elements of 5.
	 */
	private Vector<Object> itemList;
	
	/**
	 * Used to index elements in the list.
	 */
	int vectorIndex; 

	public List() {

		itemList = new Vector<Object>(25, 5);
		vectorIndex = 0;

	} // Constructor

	/**
	 * Uses the Vector.add method to append the Object to the end of the list.
	 * Casting from Object to specific class is handled in the classes that
	 * extend this class.
	 * 
	 * @param item
	 */
	public void appendItemToList(Object item) {

		itemList.add(item);

	} // Append Item

	/**
	 * Gets the Object from the list that is currently being pointed to by
	 * vectorIndex. Casting from Object to specific class is handled in the
	 * classes that extend this class.
	 * 
	 * @return The Object from the list that is currently being pointed to by
	 * vectorIndex
	 */
	public Object getItemFromList() {

		Object item;

		// Each time we get an item we increment the vectorIndex
		// If we go out of the Vector bounds, then we will catch
		// in the the catch clause below and return a null object

		try {

			item = itemList.get(vectorIndex);
			vectorIndex++;
			return (item);

		} // try

		catch (ArrayIndexOutOfBoundsException error) {

			return ((Object) null);

		} // if

	} // Append Item

	/**
	 * Sets vectorIndex back to zero, thereby pointing at the front of the list.
	 */
	void goToFrontOfList() {

		vectorIndex = 0;

	} // goToFrontOfList

} // List Class
