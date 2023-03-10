package Controller;

import java.util.ArrayList;
import java.util.function.Predicate;

import Model.Employee;

public interface ServiceInterface {
	public void loadData(String fname);
	public void writeData ();
	public void exportEmployeeList();
	public void exportEmployeeList(ArrayList<Employee> list);
	public void deleteEmployeeById(Predicate<Employee> employee);
	public void updateEmployeeInfo(Predicate<Employee> employee);
	public ArrayList<Employee> findEmployeeBySalary(Predicate<Employee> employee);
	public void sortListByName();
	public void sortListBySalary();
	public void enterListOfEmployee();
	public void exportOlderEmployee();
}
