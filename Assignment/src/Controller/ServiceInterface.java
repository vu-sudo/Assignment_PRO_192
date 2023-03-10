package Controller;

import java.util.ArrayList;
import java.util.function.Predicate;

import Model.Employee;

public interface ServiceInterface {
	public void loadData(String fname); //Vu
	public void writeData (); // Vu
	public void exportEmployeeList(); //Dung
	public void exportEmployeeList(ArrayList<Employee> list); //Dung
	public void deleteEmployeeById(Predicate<Employee> employee);//Hoang
	public void updateEmployeeInfo(Predicate<Employee> employee); //Hoang
	public ArrayList<Employee> findEmployeeBySalary(Predicate<Employee> employee);//Hoang
	public void sortListByName(); //Binh
	public void sortListBySalary();//Binh
	public void enterListOfEmployee(); //Khanh
	public void exportOlderEmployee(); //Hoang
}
