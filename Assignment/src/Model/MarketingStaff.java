package Model;

public class MarketingStaff extends Employee implements ModelInterface{
	
	private Integer sales;
	private Double commissionSalary;


	public MarketingStaff(String id, String name, Integer age, String email, String address, Long salary,
		
		Integer sales, Double commissionSalary) {
		super(id, name, age, email, address, salary);
		this.sales = sales;
		this.commissionSalary = commissionSalary;
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
		return "MarketingManager [sales=" + sales + ", commissionSalary=" + commissionSalary + ", getSales()="
				+ getSales() + ", getCommissionSalary()=" + getCommissionSalary() + ", calculateInCome()="
				+ calculateInCome() + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress() + ", getSalary()=" + getSalary()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}


	@Override
	public Long calculateInCome() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
