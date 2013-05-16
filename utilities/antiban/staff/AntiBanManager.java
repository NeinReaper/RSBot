package antiban.staff;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import antiban.AntiBan;
public class AntiBanManager extends ParentEvent{
	public AntiBanManager(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		return AntiBan.useAntiBan;
	}
}
