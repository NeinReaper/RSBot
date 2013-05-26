package source.event;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.resources.ScriptAttributes;

public class CharacterViewingParent extends ParentEvent{

	public CharacterViewingParent(Event[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.showGui && ScriptAttributes.viewEntities);
	}


}
