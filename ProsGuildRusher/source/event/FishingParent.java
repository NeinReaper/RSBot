package source.event;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.Player;

import frameWork.event.Event;
import frameWork.event.ParentEvent;
import source.Attributes;

public class FishingParent extends ParentEvent{
	public FishingParent(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		Player p;
		return ((Game.isLoggedIn() && !Attributes.showGui) && ((p = Players.getLocal())!= null) &&(p.getInteracting() == null) && (!Inventory.isFull()));
	}
}
