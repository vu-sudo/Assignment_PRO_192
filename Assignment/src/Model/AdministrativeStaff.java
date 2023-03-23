package Model;

public class AdministrativeStaff extends Employee implements ModelInterface{
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public AdministrativeStaff() {
		super();
	}

	public AdministrativeStaff(String role,String id, String name, Integer age, String email, String address, Long salary) {
		super(id, name, age, email, address, salary);
		this.role = role;
		this.calculateInCome();
	}

	@Override
	public String toString() {
		return "[ " +"Role: " + this.getRole() + ", Id=" + this.getId() + ", Name=" + this.getName() + ", Age=" + this.getAge()
				+ ", Email=" + this.getEmail() + ", Address=" + this.getAddress() + ", Salary=" + this.getSalary() + ", Income=" + this.getIncome() + " ]";
	}
	@Override
	public Long calculateInCome() {
		this.income = (long) 0;
		if (this.getSalary() < 9000000) this.income = this.getSalary();
		if (this.getSalary() >= 9000000 && this.getSalary() <= 15000000) this.income = (long) ((this.getSalary()-9000000)*0.9 + 9000000);
		if (this.getSalary() > 15000000) this.income = (long) ((this.getSalary()-15000000)*0.88+ 6000000*0.9 + 9000000);
		return this.income;
	}
}
