package frameWork.staff;

import frameWork.StaffContainer;

public abstract class ContainingStaff extends WorkingStaff{
	private StaffContainer container;
	/*
	 * Has a container of staffs, which will only be executed from this staff, not the main container
	 */
	public ContainingStaff(Staff...staffs){
		container = new StaffContainer();
		submit(staffs);
	}
	@Override
	public void process() {
		container.employ();
	}

	public void submit(Staff...staffs){
		container.submit(staffs);
	}
	public void revoke(Staff...staffs){
		container.revoke(staffs);
	}
}
