package ca.etsmtl.log430.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This utility class contains methods that allow callers to perform various
 * I/O operations at the command line.
 *
 * @author A.J. Lattanze
 * @version 1.3, 2012-Feb-02
 */

/* Modification Log
 ****************************************************************************
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 *  
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS. 
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 ****************************************************************************/

public class Termio {

	/**
	 * Reads a string from the keyboard and returns it to the caller
	 * 
	 * @return The string from the keyboard and returns it to the caller
	 */
	public String keyboardReadString() {

		BufferedReader myReader = new BufferedReader(new InputStreamReader(
				System.in));

		String stringItem = "";

		try {

			stringItem = myReader.readLine();

		} catch (IOException exc) {

			System.out
					.println("Read Error in Termio.KeyboardReadString method");

		} // try/catch

		return stringItem;

	} // keyboardReadString

	/**
	 * Reads a single character from the keyboard and returns it to the caller.
	 */
	public char keyboardReadChar() {

		BufferedReader myReader = new BufferedReader(new InputStreamReader(
				System.in));

		char charItem = ' ';

		try {

			charItem = (char) myReader.read();

		} catch (IOException exc) {

			System.out.println("Read Error in Termio.KeyboardReadChar method");

		} // try/catch

		return charItem;

	} // keyboardReadChar

	/**
	 * Determines if the input string represents a number. If an integer is
	 * passed (for example 4), then the program will assume that it is a
	 * floating point number (for example 4.0).
	 * 
	 * @param stringItem
	 * @return true if the string represents a numeric value, false otherwise.
	 */
	public boolean isNumber(String stringItem) {

		try {

			Float.valueOf(stringItem);

		} catch (NumberFormatException exc) {

			return false;

		} // try/catch

		return true;

	} // isNumber

	/**
	 * If the input string represents a number, convert it to a float and return
	 * it to the caller, otherwise a NumericFormatException is raised and a
	 * message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return The input string as a float.
	 */
	public float toFloat(String stringItem) {

		Float floatItem = new Float(0.0);

		try {

			floatItem = Float.valueOf(stringItem);

		} catch (NumberFormatException exc) {

			System.out.print("Error converting " + stringItem);
			System.out.print(" to a floating point number::");
			System.out.println(" Termio.ToFloat method.");

		} // try/catch

		return floatItem.floatValue();

	} // toFloat

	/**
	 * If the input string represents number, convert it to a double and return
	 * it to the caller. Otherwise, a NumericFormatException is raised and a
	 * message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return The input string as a double.
	 */
	public double toDouble(String stringItem) {
		Float floatItem = null;
		try {

			floatItem = Float.valueOf(stringItem);

		} catch (NumberFormatException exc) {

			System.out.print("Error converting " + stringItem);
			System.out.print(" to a floating point number::");
			System.out.println(" Termio.ToDouble method.");

		} // try/catch

		return floatItem.doubleValue();

	} // toDouble

	/**
	 * If the input string represents number, convert it to an integer and
	 * return it to the caller. Otherwise, a NumericFormatException is raised
	 * and a message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return The input string as an integer.
	 */
	public int toInteger(String stringItem) {

		Integer integerItem = null;

		try {

			integerItem = Integer.valueOf(stringItem);

		} catch (NumberFormatException exc) {

			System.out.print("Error converting " + stringItem);
			System.out.print(" to an integer number::");
			System.out.println(" Termio.ToInteger method.");

		} // try/catch

		return integerItem.intValue();

	} // toInteger

} // Termio class