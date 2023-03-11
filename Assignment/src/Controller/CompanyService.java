package Controller;

import java.util.ArrayList;
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

public class CompanyService implements ServiceInterface{

	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static final Scanner scan = new Scanner(System.in);
	
	public CompanyService() {
		super();
		String path = Paths.get("").toAbsolutePath().toString();
		loadData(path + "/src/Controller/employeeSource.txt" );
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
			FileWriter wf = new FileWriter("StoreEmployeeData.txt");
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
		// TODO Auto-generated method stub
		for (Employee ls : employeeList) {
			System.out.println(ls.toString());
		}
	}
	
	@Override
	public void deleteEmployeeById(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		for(Employee i : employeeList) {
			if(employee.test(i)) {
				employeeList.remove(i);
			}
		}
	}
	@Override
	public void updateEmployeeInfo(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		//Hoang test push
		
	}
	@Override
	public ArrayList<Employee> findEmployeeBySalary(Predicate<Employee> employee) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee i : employeeList) {
			if (employee.test(i)) temp.add(i);
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
		 for (int i = 0; i < employeeList.size(); i++) {
	            System.out.println(employeeList.get(i).toString());
	        }
		
	}
	@Override
	public void sortListBySalary() {
		Collections.sort(employeeList, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}

		}  );
		 for (int i = 0; i < employeeList.size(); i++) {
	            System.out.println(employeeList.get(i).toString());
	        }
		
	}
	@Override
	public void enterListOfEmployee() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exportOlderEmployee() {
		// TODO Auto-generated method stub
		
	}
}
