package source.staff;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.Player;
import frameWork.staff.Manager;
import frameWork.staff.Staff;
import source.Attributes;

public class FishingManager extends Manager{
	public FishingManager(Staff[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		Player p;
		return ((Game.isLoggedIn() && !Attributes.showGui) && ((p = Players.getLocal())!= null) &&(p.getInteracting() == null) && (Attributes.DOCK_AREA.contains(p) && !Inventory.isFull()));
	}
}
