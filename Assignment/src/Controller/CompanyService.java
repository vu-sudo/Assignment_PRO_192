package Controller;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
				if(l[0].equals("Department Manager")) {
					employeeList.add(new DepartmentManager(l[1], l[2], Integer.parseInt(l[3]), l[4], l[5], Long.parseLong(l[6]), Long.parseLong(l[7])));
					
				} else if (l[0].equals("Marketing staff")) {
					employeeList.add(new MarketingStaff(l[1], l[2], Integer.parseInt(l[3]), l[4], l[5],Long.parseLong(l[6]), Integer.parseInt(l[7]), Double.parseDouble(l[8])));
					
				} else if (l[0].equals("Administrative staff")) {
					employeeList.add(new AdministrativeStaff(l[1], l[2], Integer.parseInt(l[3]), l[4], l[5], Long.parseLong(l[6])));
				}
			}
		} catch (Exception e) {
			System.err.println("Load file error!");
		}
	}
	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exportEmployeeList() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exportEmployeeList(ArrayList<Employee> list) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmployeeById(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		System.out.println("Enter ID:");
		String id = scan.nextLine();
		for(int i = 0; i<employeeList.size();i++) {
			if(id.equalsIgnoreCase(employeeList.get(i).getId())) {
				employeeList.remove(employeeList.get(i));
			}
		}
	}
	@Override
	public void updateEmployeeInfo(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Employee> findEmployeeBySalary(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		ArrayList<Employee> temp = new ArrayList<>();
		System.out.println("Enter salary:");
		Long salary = scan.nextLong();
		for(int i = 0; i< employeeList.size();i++) {
			if(salary.equals(employeeList.get(i).getSalary()))  {
				temp.add(employeeList.get(i));
			}
		}
		return temp;
	}
	@Override
	public void sortListByName() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sortListBySalary() {
		// TODO Auto-generated method stub
		
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
