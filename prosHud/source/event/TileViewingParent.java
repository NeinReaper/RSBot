package source.event;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.resources.ScriptAttributes;

public class TileViewingParent extends ParentEvent{

	public TileViewingParent(Event[] employees) {
		super(employees);
	}
	@Override
	public boolean condition() {
		return ((!ScriptAttributes.showGui && ScriptAttributes.viewMouseTile));
	}

}
