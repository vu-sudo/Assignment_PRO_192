package Controller;

import java.util.ArrayList;
import java.util.function.Predicate;

import Model.Employee;

public interface ServiceInterface {
	public void loadData(String fName); //Vu
	public void writeData (); // Vu
	public void exportEmployeeList(); //Dung
	public void exportEmployeeList(ArrayList<Employee> list); //Dung
	public void deleteEmployeeById();//Hoang
	public void updateEmployeeInfo(); //Hoang
	public ArrayList<Employee> findEmpployeeBySalaryRange(Long min, Long max);//Hoang
	public void sortListByNameandSalary();
	public ArrayList<Employee> exportOlderEmployee(); //Hoang
}
