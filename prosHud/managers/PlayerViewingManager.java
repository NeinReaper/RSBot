package managers;
import frameWork.staff.Manager;
import frameWork.staff.Staff;
import source.resources.ScriptAttributes;

public class PlayerViewingManager extends Manager{

	public PlayerViewingManager(Staff[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.showGui && ScriptAttributes.viewPlayers);
	}


}
