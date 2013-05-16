package source.event;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import frameWork.event.Event;
import frameWork.event.ParentEvent;

import source.Attributes;

public class WalkingParent extends ParentEvent {

	public WalkingParent(Event[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean condition() {
		return (Game.isLoggedIn() && !Attributes.showGui) 
						&& (((Players.getLocal().getAnimation() == -1)
						&& (Inventory.isFull() 
						&& !Attributes.BANK_AREA.contains(Players.getLocal())) 
						|| (!Inventory.isFull() 
						&& !Attributes.DOCK_AREA.contains(Players.getLocal()))));
	}

}
