package Model;

public class DepartmentManager extends Employee implements ModelInterface{
	private Long responsibleSalary;
	private String rule;

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Long getResponsibleSalary() {
		return responsibleSalary;
	}

	public void setResponsibleSalary(Long responsibleSalary) {
		this.responsibleSalary = responsibleSalary;
	}


	
	public DepartmentManager(String rule,String id, String name, Integer age, String email, String address, Long salary,
			Long responsibleSalary) {
		super(id, name, age, email, address, salary);
		this.rule = rule;
		this.responsibleSalary = responsibleSalary;
		this.calculateInCome();
	}

	@Override
	public String toString() {
		return  "Rule: " + this.getRule() + ", Id=" + this.getId() + ", Name=" + this.getName() + ", Age()="
				+ this.getAge() + ", Email=" + this.getEmail() + ", Address=" + this.getAddress() + ", Salary="
				+ this.getSalary() + ", Responsible salary=" + responsibleSalary +", Income=" + this.getIncome() + "]";
	}
	
	@Override
	public Long calculateInCome() {
		Long realSalary = (this.getSalary() + this.getResponsibleSalary());
		this.income = (long) 0;
		if (realSalary < 9000000) this.income = realSalary;
		if (realSalary >= 9000000 && realSalary <= 15000000) this.income = (long) (realSalary*0.9);
		if (realSalary > 15000000) this.income = (long) (realSalary*0.88);
		return this.income;
	}
}
