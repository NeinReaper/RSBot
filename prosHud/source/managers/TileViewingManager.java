package source.managers;

import source.resources.ScriptAttributes;
import employment.task.Manager;
import employment.task.Staff;

public class TileViewingManager extends Manager{

	public TileViewingManager(Staff[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean condition() {
		return ((!ScriptAttributes.showGui && ScriptAttributes.viewMouseTile));
	}

}
