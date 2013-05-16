package source.event;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import source.Attributes;
import frameWork.event.Event;
import frameWork.event.ParentEvent;

public class BankingParent extends ParentEvent {

	public BankingParent(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		// TODO Auto-generated method stub
		return ((Game.isLoggedIn() && !Attributes.showGui) && (Inventory.isFull() || Bank.isOpen()) && Attributes.BANK_AREA.contains(Players.getLocal()));
	}

}
