package View;

import Controller.CompanyService;
import Model.Employee;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//VuVu
public class CompanyManagement extends Menu{
	private CompanyService service = new CompanyService();
	
	static String[] menu = {
			"Load data from file.",
			"Display all employee.",
			"Delete a employee by id.",
			"Update info a employee by id.",
			"Find employee by range of salary.",
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
			loadFile();
			break;
		case 2:
			Display();
			break; //Display all employee.
		case 3: 
			service.deleteEmployeeById();
			break; //Delete a employee by id
		case 4: 
			service.updateEmployeeInfo();
			break; //Update info a employee by id.
		case 5: 
			findBySalaryRange();
			break; //Find employee by salary.
		case 6: 
			Sort();
			break; //Sort list of employee.
		case 7: 
			EnterListOfEmployee(); 
			break; 
		case 8: 
			service.writeData();
			break; 
		case 9: 
			exportOlderEmpoyeeList();
			break; //Export three older employee with highest salary.
		case 10: System.out.println("Program end! \nThank you for using my program");
		default: System.exit(0);
		}
	}
	
	public void Display() {
		service.exportEmployeeList();
	}
	public void loadFile() {
		String path = Paths.get("").toAbsolutePath().toString();
		service.loadData(path + "/src/Controller/employeeSource.txt");
		System.out.println("LOAD FILE SUCESSFULLY!");
	}
	public void Sort() {
		if(service.returnList().isEmpty()) {
			System.out.println("EMPTY LIST! CAN'T NOT PERFORM SORT");
		} else {
			System.out.println("EMPLOYEE LIST BEFORE SORTED BY NAME AND SALARY:");
			service.exportEmployeeList();
			System.out.println("\nEMPLOYEE LIST AFTER SORTED BY NAME AND SALARY:");
			service.sortListByNameandSalary();
			service.exportEmployeeList();	
		}
	}
	
	public void findBySalaryRange() {
		Long minSalary = Validation.InputLong("Enter min salary: ", 0, 1000000000);
		Long maxSalar = Validation.InputLong("Enter max salary: ", 0, 1000000000);
		
		ArrayList<Employee> temp = service.findEmpployeeBySalaryRange(minSalary, maxSalar);
		if(temp.isEmpty()) {
			System.out.println("HAVE NO EMPLOYEE IN THIS RANGE OF SALARY!");
		} else {
			service.exportEmployeeList(temp);
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
