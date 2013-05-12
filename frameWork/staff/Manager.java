package frameWork.staff;

import frameWork.StaffContainer;

public abstract class Manager extends Staff{
	private StaffContainer container;
	public Manager(Staff[] employees){
		container = new StaffContainer();
		container.submit(employees);
	}
	
	public void execute(){
		container.employ();
	}
}
