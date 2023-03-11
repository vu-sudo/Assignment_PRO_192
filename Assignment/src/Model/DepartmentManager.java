package Model;

public class DepartmentManager extends Employee implements ModelInterface{
	private Long responsibleSalary;

	public Long getResponsibleSalary() {
		return responsibleSalary;
	}

	public void setResponsibleSalary(Long responsibleSalary) {
		this.responsibleSalary = responsibleSalary;
	}


	
	public DepartmentManager(String id, String name, Integer age, String email, String address, Long salary,
			Long responsibleSalary) {
		super(id, name, age, email, address, salary);
		this.responsibleSalary = responsibleSalary;
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
