package antiban.staff;
import frameWork.staff.Manager;
import frameWork.staff.Staff;
import antiban.AntiBan;
public class AntiBanManager extends Manager{
	public AntiBanManager(Staff[] employees) {
		super(employees);
	}

	@Override
	public boolean activate() {
		return AntiBan.useAntiBan;
	}
}
