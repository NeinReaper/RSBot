package managers;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.resources.ScriptAttributes;

public class PlayerViewingManager extends ParentEvent{

	public PlayerViewingManager(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.showGui && ScriptAttributes.viewPlayers);
	}


}
