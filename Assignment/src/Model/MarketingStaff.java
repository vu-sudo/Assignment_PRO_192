package Model;

public class MarketingStaff extends Employee implements ModelInterface{
	
	private Integer sales;
	private Double commissionSalary;
	private String rule;

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}



	public MarketingStaff(String rule,String id, String name, Integer age, String email, String address, Long salary,	Integer sales, Double commissionSalary) {
		super(id, name, age, email, address, salary);
		this.sales = sales;
		this.commissionSalary = commissionSalary;
		this.calculateInCome();
	}

	public double getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Double getCommissionSalary() {
		return commissionSalary;
	}

	public void setCommissionSalary(Double commissionSalary) {
		this.commissionSalary = commissionSalary;
	}

	@Override
	public String toString() {
		return "Rule: " + this.getRule() + ", Id=" + this.getId() + ", Name=" + this.getName() + ", Age=" + this.getAge()
				+ ", Email=" + this.getEmail() + ", Address=" + this.getAddress() + ", Salary=" + this.getSalary()
				+ ", Sales" + sales + ", Commission Salary" + commissionSalary +", Income=" + this.getIncome() +"]";
	}


	@Override
	public Long calculateInCome() {
		Long realSalary = (long) (this.getSalary() + this.getSales()*this.getCommissionSalary());
		this.income = (long) 0;
		if (realSalary < 9000000) this.income = realSalary;
		if (realSalary >= 9000000 && realSalary <= 15000000) this.income = (long) (realSalary*0.9);
		if (realSalary > 15000000) this.income = (long) (realSalary*0.88);
		return this.income;
	}
	
}
