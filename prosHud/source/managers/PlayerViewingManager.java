package source.managers;

import source.resources.ScriptAttributes;
import employment.task.Manager;
import employment.task.Staff;

public class PlayerViewingManager extends Manager{

	public PlayerViewingManager(Staff[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean condition() {
		// TODO Auto-generated method stub
		return (!ScriptAttributes.showGui && ScriptAttributes.viewPlayers);
	}


}
