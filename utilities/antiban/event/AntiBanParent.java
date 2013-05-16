package antiban.event;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import antiban.AntiBan;
public class AntiBanParent extends ParentEvent{
	public AntiBanParent(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		return AntiBan.useAntiBan;
	}
}
