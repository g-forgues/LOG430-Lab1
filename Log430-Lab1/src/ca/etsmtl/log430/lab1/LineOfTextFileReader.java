package ca.etsmtl.log430.lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * This class provides the methods that allow the caller to open an existing
 * file and read one line of input (to end-of-line) from the file.
 *
 * @author A.J. Lattanze, CMU
 * @version 1.3, 2012-Feb-02
 */

/* Modification Log
 **************************************************************************************
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 *  
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS. 
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 **************************************************************************************/
public class LineOfTextFileReader {

	private File inputFile = null;
	private BufferedReader inFile = null;

	public boolean openFile(String pathName) {

		boolean result;
		inputFile = new File(pathName);

		// Open input file. The input file is a field oriented and
		// space-separated.
		// The fields and expected formats are listed above in the header

		// Check to ensure that the inputFile exists
		if (!inputFile.exists()) {

			result = false;

		} else {
			try {

				// Create a buffered reader the file

				inFile = new BufferedReader(new InputStreamReader(
						new FileInputStream((inputFile))));

				result = true;

			} // try

			catch (Exception Error) {

				result = false;

			} // catch

		} // if

		return (result);

	} // OpenFile

	public String readLineOfText() {

		String lineOfText = null;

		// Read a line of text from the input file and convert it to upper case

		try {

			lineOfText = inFile.readLine();

		} // try

		catch (Exception Error) {

			try {

				throw (Error);

			} // try

			catch (Exception e) {

				// We are in real trouble if we get here.

			} // catch

		} // catch

		return (lineOfText);

	} // ReadLineOfText

	public boolean closeFile() {

		boolean result = true;

		// Close the input file
		try {

			inFile.close();

		} // try

		catch (Exception Error) {

			result = false;

		} // catch

		return (result);

	} // ReadLineOfText

} // LineOfTextFileReader