/**
 * Assignment 1, ETS course LOG430 - Architecture logicielle. The purpose of
 * this assignment is to introduce object-oriented implementations in the
 * context of layered architectures.<br><br>
 * 
 * The application is a contrived project management system. It is a menu
 * driven system that allows the following options:
 * 
 * <pre>
 *    1) List resources (humans to be allocated to projects)
 *    2) List projects
 *    3) List projects currently assigned to a resource
 *    4) List resources currently assigned to a project
 *    5) Assign a resource to a project
 *    X) Exit.
 * </pre>
 * 
 * Structurally, the system is roughly divided into three layers:
 * 
 * <blockquote>
 *  1) Presentation Layer<br>
 *  2) Business Rule Layer<br>
 *  3) File I/O Layer<br>
 * </blockquote>
 * 
 * Dynamically, the main program initializes the primary objects
 * and dispatches commands at the user's request. When the program is started,
 * the resource objects are initialized from a file (<tt>resources.txt</tt> is an
 * example). The format of this file is listed in the
 * {@link ca.etsmtl.log430.lab1.ResourceReader ResourceReader} class header.
 * The project objects are initialized from another file (<tt>projects.txt</tt> is
 * an example). The format of this file is listed in the
 * {@link ca.etsmtl.log430.lab1.ProjectReader ProjectReader} class header.<br><br>
 * 
 * <b>Running the program:</b><br><br>
 * 
 * <blockquote>
 * <tt>java ResourceAssignment &lt;ProjectDataFile&gt; &lt;ResourceDataFile&gt;</tt><br><br>
 * 
 * <b>With the supplied example files:</b><br><br>
 * 
 * <tt>java ResourceAssignment projects.txt resources.txt</tt><br><br>
 * </blockquote>
 *
 * @author A.J. Lattanze - CMU - 1999
 * @author Roger Champagne - ETS - 2002-2013
 * @version 2013-Sep-13
 */
package ca.etsmtl.log430.lab1;