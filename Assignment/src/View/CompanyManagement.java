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
		// TODO Auto-generated method stub
		
	}
	
}
