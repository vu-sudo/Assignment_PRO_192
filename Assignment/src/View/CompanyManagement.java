package View;

import Controller.CompanyService;
import Model.Employee;

import java.util.ArrayList;
import java.util.Scanner;

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
	}

	@Override
	public void execute(int n) {
		switch(n) {
		case 1:
			Display();
			break; //Display all employee.
		case 2: 
			service.deleteEmployeeById();
			break; //Delete a employee by id
		case 3: 
			service.updateEmployeeInfo();
			break; //Update info a employee by id.
		case 4: System.out.println("4"); break; //Find employee by salary.
		case 5: 
			Sort();
			break; //Sort list of employee.
		case 6: 
			EnterListOfEmployee(); 
			break; 
		case 7: 
			service.writeData();
			break; 
		case 8: 
			exportOlderEmpoyeeList();
			break; //Export three older employee with highest salary.
		case 9: System.out.println("Program end! \nThank you for using my program");
		default: System.exit(0);
		}
	}
	
	public void Display() {
		service.exportEmployeeList();
	}
	public void Sort() {
		if(service.returnList().isEmpty()) {
			System.out.println("EMPTY LIST! CAN'T NOT PERFORM SORT");
		} else {
			String[] eMenu = {
					"Sort list by name.",
					"Sort list by salary",
			};

			Menu m = new Menu("CHOOSE SORT OPTION", eMenu) {
				@Override
				public void execute(int n) {
					switch(n) {
						case 1:
							System.out.println("EMPLOYEE LIST BEFORE SORTED BY NAME:");
							service.exportEmployeeList();
							System.out.println("\nEMPLOYEE LIST AFTER SORTED BY NAME:");
							service.sortListByName();
							service.exportEmployeeList();
							break;
						case 2:
							System.out.println("EMPLOYEE LIST BEFORE SORTED BY SALARY:");
							service.exportEmployeeList();
							System.out.println("\nEMPLOYEE LIST AFTER SORTED BY SALARY:");
							service.sortListBySalary();
							service.exportEmployeeList();
							break;
						default:
							System.out.println("BACK TO MAIN MENU!");
							return;
					}
				}
				
			};
			m.run();
		}
	}
	public void exportOlderEmpoyeeList() {
		ArrayList<Employee> temp = null;
		temp = service.exportOlderEmployee();
		if (temp.isEmpty()) {
			System.out.println("HAVE NO OLDER EMPLOYEE WITH HIGH SALARY!");
		} else {
			service.exportEmployeeList(temp);
			temp.clear();
		}
	}
	public void EnterListOfEmployee() {
		Scanner sc = new Scanner(System.in);
		String[] eMenu = {
			"Administrative Staff",
			"Marketing Staff",
			"Department Manager"
		};
		Menu m = new Menu("TYPE OF EMPLOYEES", eMenu) {
			public void execute(int n) {
				switch(n) {
				case 1:
					System.out.println("Number of employees: ");
					int number = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < number; i++) {
						service.enterAdministrativeStaff();
					}
					break;
				case 2: 
					System.out.println("Number of employees: ");
					number = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < number; i++) {
						service.enterMarketingStaff();
					}
					break;
				case 3:
					System.out.println("Number of employees: ");
					number = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < number; i++) {
						service.enterManager();
					}
					break; 
				default:
					System.out.println("BACK TO MAIN MENU!");
					return;
				}
			}
		};
		m.run();
	}
}
