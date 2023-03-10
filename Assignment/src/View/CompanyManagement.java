package View;

import Controller.CompanyService;

//VuVu
public class CompanyManagement extends Menu{
	private CompanyService service = new CompanyService();
	
	static String[] menu = {
			"Display all employee.",
			"Delete a employee by id.",
			"Update info a employee by id.",
			"Find employee by salary.",
			"Sort list of employee.",
			"Enter list a employee.",
			"Save list of employees to file.",
			"Export three older employee with highest salary.",
			"EXIT PROGRAM..."
			};
	
	public CompanyManagement() {
		super("COMPANY EMPLOYEES MANAGEMENT", menu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(int n) {
		switch(n) {
		case 1: System.out.println("1"); break; //Display all employee.
		case 2: System.out.println("2"); break; //Delete a employee by id
		case 3: System.out.println("3"); break; //Update info a employee by id.
		case 4: System.out.println("4"); break; //Find employee by salary.
		case 5: System.out.println("5"); break; //Sort list of employee.
		case 6: System.out.println("6"); break; //Enter list a employee.
		case 7: System.out.println("7"); break; //Save list of employees to file.
		case 8: System.out.println("8"); break; //Export three older employee with highest salary.
		case 9: System.out.println("Program end! \nThank you for using my program");
		default: System.exit(0);
		}
	}
	
}
