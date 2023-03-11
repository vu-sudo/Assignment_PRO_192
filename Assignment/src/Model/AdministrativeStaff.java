package Model;

public class AdministrativeStaff extends Employee implements ModelInterface{

	public AdministrativeStaff(String id, String name, Integer age, String email, String address, Long salary) {
		super(id, name, age, email, address, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdministrativeStaff [getId()=" + getId() + ", getName()=" + getName() + ", getAge()=" + getAge()
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
