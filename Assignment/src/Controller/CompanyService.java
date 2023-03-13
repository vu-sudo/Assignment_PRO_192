package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

import Model.AdministrativeStaff;
import Model.DepartmentManager;
import Model.MarketingStaff;
import Model.Employee;
import View.Validation;

public class CompanyService implements ServiceInterface{

	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static final Scanner scan = new Scanner(System.in);
	
	public CompanyService() {
		super();
		String path = Paths.get("").toAbsolutePath().toString();
		loadData(path + "/src/Controller/employeeSource.txt" );
	}
	
	public ArrayList<Employee> returnList() {
		return employeeList;
	}
	
	@Override
	public void loadData(String fName) {
		File f = new File(fName);
		if(!f.exists()) throw new RuntimeException("File is not exist");
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
			while((line = br.readLine()) != null) {
				String[] l = line.split(";");
				if(l[0].equals("Department manager")) {
					employeeList.add(new DepartmentManager(l[0], l[1], l[2], Integer.parseInt(l[3]), l[5], l[4], Long.parseLong(l[6]), Long.parseLong(l[7])));
					
				} else if (l[0].equals("Marketing staff")) {
					employeeList.add(new MarketingStaff(l[0], l[1], l[2], Integer.parseInt(l[3]), l[5], l[4],Long.parseLong(l[6]), Integer.parseInt(l[7]), Double.parseDouble(l[8])));
					
				} else if (l[0].equals("Administrative staff")) {
					employeeList.add(new AdministrativeStaff(l[0], l[1], l[2], Integer.parseInt(l[3]), l[5], l[4], Long.parseLong(l[6])));
				}
			}
		} catch (Exception e) {
			System.err.println("Load file error!");
		}
	}
	@Override
	public void writeData() {
		try {
			String path = Paths.get("").toAbsolutePath().toString();
			FileWriter wf = new FileWriter(path + "/src/Controller/StoreEmployeeData.txt");
			for (Employee item: employeeList) {
				wf.write(item + System.lineSeparator());
			}
			wf.close();
			System.out.println("Successfully wrote to the file!");
		}	catch(IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	@Override
	public void exportEmployeeList() {
		for (Employee ls: employeeList) {
			System.out.println(ls.toString());
		}
		
	}
	@Override
	public void exportEmployeeList(ArrayList<Employee> list) {
		for (Employee ls : list) {
			System.out.println(ls.toString());
		}
	}
	
	@Override
	public void deleteEmployeeById() {
		if(employeeList.isEmpty()) {
			System.out.println("Empty list. No remove can be performed!");
		} else {
			String eID = Validation.inputStr("Input ID to delete employee: ");
			Employee employee = this.search(eID);
			if (employee == null) {
				System.out.println("Employee " + eID + " does not exist!");
			} else {
				employeeList.remove(employee);
				System.out.println("Employee " + eID + " has been removed");
			}
		}
	}
	@Override
	public void updateEmployeeInfo() {
		if(employeeList.isEmpty()) {
			System.out.println("Empty list");
		} else {
			String id = Validation.inputStr("Input ID to update employee: ");
			Employee employees = this.search(id);
			if (employees == null) {
				System.out.println("Employee " + id + " doesn't exist!");
			} else {
					//Update name
					String oldName = employees.getName();
					String msg = "Old name: " + oldName + ", new name: ";
					String newName = Validation.inputNonBlankStr(msg);
					newName.toUpperCase();
					employees.setName(newName);
					//Update age
					Integer oldAge = employees.getAge();
					msg = "Old age: " + oldAge + ", new age <above 18>: ";
					Integer newAge = Validation.InputInt(msg, 18, 100);
					employees.setAge(newAge);
					//Update email
					String oldEmail = employees.getEmail();
					msg = "Old email: " + oldEmail + ", new email: ";
					String newEmail = Validation.inputPattern(msg,"^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
					employees.setEmail(newEmail);
					//Update address
					String oldAddress = employees.getAddress();
					msg = "Old address: " + oldAddress + ", new address: ";
					String newAddress = Validation.inputNonBlankStr(msg);
					employees.setAddress(newAddress);
					//Update salary
					Long oldSalary = employees.getSalary();
					msg = "Old salary: " + oldSalary + ", new salary: ";
					Long newSalary = Validation.InputLong(msg, 0, 1000000000);
					employees.setSalary(newSalary);
					
					if (employees instanceof MarketingStaff) {
						MarketingStaff mktStaff = (MarketingStaff) employees;
						Integer oldSales = mktStaff.getSales();
						msg = "Old sales: " + oldSales + ", new sales: ";
						Integer newSales = Validation.InputInt(msg, 0, 1000000);
						mktStaff.setSales(newSales);
						//Update commission
						Double oldCommission = mktStaff.getCommissionSalary();
						msg = "Old commission salary: " + oldCommission + ", new commission salary: ";
						Double newCommission = Validation.InputDouble(msg, 0.0, 100000.0);
						mktStaff.setCommissionSalary(newCommission);
					}
					if (employees instanceof DepartmentManager) {
						DepartmentManager manager = (DepartmentManager) employees;
						Long oldResponsible = manager.getResponsibleSalary();
						msg = "Old responsibile salary: " + oldResponsible + ", new responsible salary: ";
						Long newResponsible = Validation.InputLong(msg, 0, 1000000000);
						manager.setResponsibleSalary(newResponsible);
					}
				}
			}
		}
		
	@Override
	public ArrayList<Employee> findEmpployeeBySalaryRange(Long minSalary, Long maxSalary) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee item: employeeList) {
			if(item.getIncome() >= minSalary && item.getIncome() <= maxSalary) {
				temp.add(item);
			}
		}
		return temp;
	}
	@Override
	public void sortListByName() {
		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}  );
	}
	@Override
	public void sortListBySalary() {
		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getIncome().compareTo(o1.getIncome());
			}

		}  );
	}
	public Employee search(String code) {
		code = code.trim().toUpperCase();
		for(Employee ls : employeeList) {
			if (ls.getId().equals(code))
				return ls;
		}
		return null;
	}
	
	public boolean isCodeDuplicated (String code) {
		code = code.trim().toUpperCase();
		return search(code) != null;
	}


	public void enterAdministrativeStaff() {
		String newId;
		String newName;
		Integer newAge;
		String newAddress;
		String newEmail;
		Long newSalary;
		boolean codeDuplicated = false;
		do {
			newId = Validation.inputPattern("ID: <pattern D0>", "[dD][\\d]{1}");
			newId = newId.trim().toUpperCase();
			codeDuplicated = isCodeDuplicated(newId);
			if (codeDuplicated) {
				System.out.println("ID is duplicated");
			}
		}
		while (codeDuplicated == true);
		newName = Validation.inputNonBlankStr("Name of employee: ");
		newName = newName.toUpperCase();
		newAge = Validation.InputInt("Age <above 18>: ", 18, 100);
		newAddress = Validation.inputNonBlankStr("Address: ");
		newEmail = Validation.inputPattern("Email: ","^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
		newSalary = Validation.InputLong("Salary: ", 0, 1000000000);
		Employee administrative = new AdministrativeStaff("Administrative Staff", newId, newName, newAge, newAddress, newEmail, newSalary);
		employeeList.add(administrative);
	}
	
	public void enterMarketingStaff() {
		String newId;
		String newName;
		Integer newAge;
		String newAddress;
		String newEmail;
		Long newSalary;
		Integer newSales;
		Double newCommission;
		boolean codeDuplicated = false;
		do {
			newId = Validation.inputPattern("ID: <pattern D0>", "[dD][\\d]{1}");
			newId = newId.trim().toUpperCase();
			codeDuplicated = isCodeDuplicated(newId);
			if (codeDuplicated) {
				System.out.println("ID is duplicated");
			}
		}
		while (codeDuplicated == true);
		newName = Validation.inputNonBlankStr("Name of employee: ");
		newName = newName.toUpperCase();
		newAge = Validation.InputInt("Age <above 18>: ", 18, 100);
		newAddress = Validation.inputNonBlankStr("Address: ");
		newEmail = Validation.inputNonBlankStr("Email: ");
		newSalary = Validation.InputLong("Salary: ", 0, 1000000000);
		newSales = Validation.InputInt("Sales: ", 0, 1000000);
		newCommission = Validation.InputDouble("Commission: ", 0.0, 100000.0);
		Employee marketing = new MarketingStaff("Marketing Staff", newId, newName, newAge, newAddress, newEmail, newSalary, newSales, newCommission);
		employeeList.add(marketing);
	}
	
	public void enterManager() {
		String newId;
		String newName;
		Integer newAge;
		String newAddress;
		String newEmail;
		Long newSalary;
		Long newResponsibleSalary;
		boolean codeDuplicated = false;
		do {
			newId = Validation.inputPattern("ID: <pattern D0>", "[dD][\\d]{1}");
			newId = newId.trim().toUpperCase();
			codeDuplicated = isCodeDuplicated(newId);
			if (codeDuplicated) {
				System.out.println("ID is duplicated");
			}
		}
		while (codeDuplicated == true);
		newName = Validation.inputNonBlankStr("Name of employee: ");
		newName = newName.toUpperCase();
		newAge = Validation.InputInt("Age <above 18>: ", 18, 100);
		newAddress = Validation.inputNonBlankStr("Address: ");
		newEmail = Validation.inputNonBlankStr("Email: ");
		newSalary = Validation.InputLong("Salary: ", 0, 1000000000);
		newResponsibleSalary = Validation.InputLong("Responsible salary", 0, 1000000000);
		Employee manager = new DepartmentManager("Department Manager", newId, newName, newAge, newAddress, newEmail, newSalary, newResponsibleSalary);
		employeeList.add(manager);
	}
	
	@Override
	public ArrayList<Employee> exportOlderEmployee() {
		Set<Employee> setList = new HashSet<>();
		ArrayList<Employee> olderEmployee = new ArrayList<>();
		this.sortListBySalary();
		
		for(Employee i: employeeList) {
			if(i.getAge()>=60) {
				for(int j = 0; j<3; j++) {
					setList.add(i);
				}
			}
		}
		olderEmployee.addAll(setList);
		setList.clear();
		return olderEmployee;
	}

}
