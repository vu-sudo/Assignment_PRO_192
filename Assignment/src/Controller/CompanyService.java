package Controller;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;

import Model.Employee;

public class CompanyService implements ServiceInterface{

	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static final Scanner scan = new Scanner(System.in);
	@Override
	public void loadData(String fname) {
		// TODO Auto-generated method stub
		
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
		Collections.sort(employeeList, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		
		}  );
		 for (int i = 0; i < employeeList.size(); i++) {
	            System.out.println(employeeList.get(i).toString());
	        }
		
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
