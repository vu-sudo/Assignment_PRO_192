package Model;

public class MarketingManager extends Employee implements ModelInterface{
	
	private double sales;
	private long commissionSalary;

	public MarketingManager(String id, String name, Integer age, String email, String address, Long salary) {
		super(id, name, age, email, address, salary);
		// TODO Auto-generated constructor stub
	}



	public double getSales() {
		return sales;
	}



	public void setSales(double sales) {
		this.sales = sales;
	}



	public long getCommissionSalary() {
		return commissionSalary;
	}



	public void setCommissionSalary(long commissionSalary) {
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
