package managers;
import frameWork.staff.Manager;
import frameWork.staff.Staff;
import source.resources.ScriptAttributes;

public class TileViewingManager extends Manager{

	public TileViewingManager(Staff[] employees) {
		super(employees);
	}
	@Override
	public boolean condition() {
		return ((!ScriptAttributes.showGui && ScriptAttributes.viewMouseTile));
	}

}
