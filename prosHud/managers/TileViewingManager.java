package managers;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.resources.ScriptAttributes;

public class TileViewingManager extends ParentEvent{

	public TileViewingManager(Event[] employees) {
		super(employees);
	}
	@Override
	public boolean condition() {
		return ((!ScriptAttributes.showGui && ScriptAttributes.viewMouseTile));
	}

}
