package source.event;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.resources.ScriptAttributes;

public class PlayerViewingParent extends ParentEvent{

	public PlayerViewingParent(Event[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.showGui && ScriptAttributes.viewPlayers);
	}


}
