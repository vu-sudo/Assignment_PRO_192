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
		
	}
	@Override
	public void updateEmployeeInfo(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Employee> findEmployeeBySalary(Predicate<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
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
	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateEmployeeInfo() {
		// TODO Auto-generated method stub
		
	}
	
	

}
