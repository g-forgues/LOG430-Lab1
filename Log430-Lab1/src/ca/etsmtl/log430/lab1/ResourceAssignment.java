package ca.etsmtl.log430.lab1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main class for assignment 1 for LOG430, Architecture logicielle.
 * 
 * <pre>
 * <b>Pseudo Code:</b>
 * 
 *   Instantiate lists
 *   do until done
 *     Present Menu
 *     if user choice = 1 then list resources
 *     if user choice = 2 then list projects
 *     if user choice = 3 then
 *        list resources
 *        ask user to select a resource (by ID)
 *        list projects assigned to that resource
 *     endif
 *     if user choice = 4 then
 *        list projects
 *        ask user to select a project (by ID)
 *        list resources assigned to that project
 *     endif
 *     if user choice = 5 then
 *        list resources
 *        ask user to select a resource (by ID)
 *        list projects
 *        ask user to select a project (by ID)
 *        assign project to resource (and vice versa)
 *     endif
 *     if user choice = x then you are done
 *   end do
 * </pre>
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.5, 2013-Sep-13
 */

/*
 * Modification Log
 * **************************************************************************
 * v1.5, R. Champagne, 2013-Sep-13 - Various refactorings for new lab.
 * 
 * v1.4, R. Champagne, 2012-May-31 - Various refactorings for new lab.
 * 
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 * 
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS.
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 * **************************************************************************
 */

public class ResourceAssignment {

	public static void main(String argv[]) {

		if (argv.length != 2) {
			System.out.println("\n\nIncorrect number of input parameters -"
					+ " correct usage:");
			System.out.println("\njava ResourceAssignment <project file name>"
					+ " <resource file name>");
		} else {

			// Declarations:

			boolean done; // Loop invariant
			char userChoice; // User's menu choice
			Project project = null; // A project object
			Resource resource = null; // A resource object
			int overcharge = 0; // An int to calculate how charged a resource is
			
			// Instantiates a menu object
			Menus menu = new Menus();

			// Instantiates a display object
			Displays display = new Displays();

			/*
			 * The following instantiations create a list of projects and
			 * resources. The pathname for the file containing course information
			 * is passed to the main program on the command line as the first
			 * argument (argv[0]). The pathname for the file containing resource
			 * information is passed to the main program on the command line as
			 * the second argument (argv[1]). An example resources file and projects
			 * file is provided as resources.txt and projects.txt
			 */

			ProjectReader projectList = new ProjectReader(argv[0]);
			ResourceReader resourceList = new ResourceReader(argv[1]);

			if ((projectList.getListOfProjects() == null)
					|| (resourceList.getListOfResources() == null)) {
				System.out
						.println("\n\n *** The projects list and/or the resources"
								+ " list was not initialized ***");
				done = true;
			} else {
				done = false;
			} // if

			while (!done) {

				userChoice = menu.mainMenu();
				switch (userChoice) {

				case '1':

					display.displayResourceList(resourceList.getListOfResources());
					break;

				case '2':

					display.displayProjectList(projectList.getListOfProjects());
					break;

				case '3':

					display.displayResourceList(resourceList.getListOfResources());
					resource = menu.pickResource(resourceList.getListOfResources());
					if (resource != null) {
						display.displayProjectsAssignedToResource(resource);
					} // if
					break;

				case '4':

					display.displayProjectList(projectList.getListOfProjects());
					project = menu.pickProject(projectList.getListOfProjects());

					if (project != null) {
						display.displayResourcesAssignedToProject(project);
					} // if
					break;

				case '5':

					display.displayResourceList(resourceList.getListOfResources());
					resource = menu.pickResource(resourceList.getListOfResources());
					
					
					if (resource != null) {
						display.displayProjectList(projectList.getListOfProjects());
						project = menu.pickProject(projectList.getListOfProjects());
						
						if (project != null) {
							
							overcharge = 0; //variable used to verify how busy an employee is for a set of dates
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Date newProjectStart = null;
							Date newProjectEnd = null;
							Date oldProjectStart = null;
							Date oldProjectEnd = null;
							boolean alreadyAssigned = false; //boolean used to determine if the project has already been assigned to the resource
							
							try {
								newProjectStart = formatter.parse(project.getStartDate());
								newProjectEnd = formatter.parse(project.getEndDate());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							resource.getProjectsAssigned().goToFrontOfList();

							Project projectAlreadyAssigned = resource.getProjectsAssigned().getNextProject();
							
							//loop that calculates the amount of work for the resource in the given set of dates
							while (projectAlreadyAssigned != null && !alreadyAssigned) {
								alreadyAssigned = false;
									try {
										oldProjectStart = formatter.parse(projectAlreadyAssigned.getStartDate());
										oldProjectEnd = formatter.parse(projectAlreadyAssigned.getEndDate());
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									if(projectAlreadyAssigned.getID().equalsIgnoreCase(project.getID()))
									{
										alreadyAssigned = true;
									}
									else
									{
										if ((newProjectStart.after(oldProjectStart) && newProjectStart.before(oldProjectEnd)) | (newProjectEnd.after(oldProjectStart) && newProjectEnd.before(oldProjectEnd)))
											{
												if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("H") == 0 )
												{
												overcharge += 100;
												} // if
												if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("M") == 0 )
												{
												overcharge += 50;
												} // if
												if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("L") == 0 )
												{
												overcharge += 25;
												} // if
											}
									}
								projectAlreadyAssigned = resource.getProjectsAssigned().getNextProject();
								
							} // while
							
							
							//Adds the load of work for the new project to the overcharge variable
							
							if(project.getPriority().compareToIgnoreCase("H") == 0 )
							{
							overcharge += 100;
							} // if
							if(project.getPriority().compareToIgnoreCase("M") == 0 )
							{
							overcharge += 50;
							} // if
							if(project.getPriority().compareToIgnoreCase("L") == 0 )
							{
							overcharge += 25;
							} // if
							
							//if statement to verify that the employee is not overcharged or is not already assigned to the project
							if(overcharge > 100 | alreadyAssigned)
							{
								System.out.println("Project could not be assigned to the resource selected because the resource is already overcharged or is already assigned to the project selected.");
							}
							else
							{
								project.assignResource(resource);
								resource.assignProject(project);
								System.out.println("Project assigned to selected resource.");
							}
							
					} // if
					}
					break;

				case '7':
					display.displayProjectList(projectList.getListOfProjects());
					
					//the reason I get the string from the terminal and not get the actual 'project' object from the project list is 
					//because the user can search for a project available in resources.txt but doesn't appear in projects.txt (EX: P004)
					String projectID = menu.pickProjectDisregardIfTheProjectExists(projectList.getListOfProjects());
					project = projectList.getListOfProjects().findProjectByID(projectID);
					
					display.displayResourcesAlreadyAssignedToProject(projectID, resourceList.getListOfResources());
					if (project != null) {
						display.displayResourcesAssignedToProject(project);
					} // if
				break;
				
				case 'X':

				case 'x':
					done = true;
				} // switch
			} // while
		} // if
	} // main
} // Class