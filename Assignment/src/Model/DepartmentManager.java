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
	public Long calculateInCome() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
