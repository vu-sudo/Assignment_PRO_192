package Model;

public class DepartmentManager extends Employee implements ModelInterface{
	private long responsibleSalary;

	public long getResponsibleSalary() {
		return responsibleSalary;
	}

	public void setResponsibleSalary(long responsibleSalary) {
		this.responsibleSalary = responsibleSalary;
	}

	public DepartmentManager(String id, String name, Integer age, String email, String address, Long salary) {
		super(id, name, age, email, address, salary);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DepartmentManager [responsibleSalary=" + responsibleSalary + ", getResponsibleSalary()="
				+ getResponsibleSalary() + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress() + ", getSalary()="
				+ getSalary() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
	@Override
	public Long calculateInCome() {
		// TODO Auto-generated method stub
		return null;
	}
}
