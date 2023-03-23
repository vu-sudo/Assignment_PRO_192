package Model;

public class DepartmentManager extends Employee implements ModelInterface{
	private Long responsibleSalary;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getResponsibleSalary() {
		return responsibleSalary;
	}

	public void setResponsibleSalary(Long responsibleSalary) {
		this.responsibleSalary = responsibleSalary;
	}

	public DepartmentManager(String role,String id, String name, Integer age, String email, String address, Long salary,
			Long responsibleSalary) {
		super(id, name, age, email, address, salary);
		this.role = role;
		this.responsibleSalary = responsibleSalary;
		this.calculateInCome();
	}

	@Override
	public String toString() {
		return  "[ " + "Role: " + this.getRole() + ", Id=" + this.getId() + ", Name=" + this.getName() + ", Age="
				+ this.getAge() + ", Email=" + this.getEmail() + ", Address=" + this.getAddress() + ", Salary="
				+ this.getSalary() + ", Responsible salary=" + responsibleSalary +", Income=" + this.getIncome() + " ]";
	}
	
	@Override
	public Long calculateInCome() {
		Long realSalary = (this.getSalary() + this.getResponsibleSalary());
		this.income = (long) 0;
		if (realSalary < 9000000) this.income = realSalary;
		if (realSalary >= 9000000 && realSalary <= 15000000) this.income = (long) ((realSalary-9000000)*0.9 + 9000000);
		if (realSalary > 15000000) this.income = (long) ((realSalary-15000000)*0.88 + 6000000 *0.9 + 9000000);
		return this.income;
	}
}
