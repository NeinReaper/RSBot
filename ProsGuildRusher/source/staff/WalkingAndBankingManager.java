package source.staff;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import frameWork.staff.Manager;
import frameWork.staff.Staff;

import source.Attributes;

public class WalkingAndBankingManager extends Manager {

	public WalkingAndBankingManager(Staff[] employees) {
		super(employees);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean condition() {
		return ((Game.isLoggedIn() && !Attributes.showGui))
				&& (((Inventory.isFull() || Bank.isOpen()) && Attributes.BANK_AREA
						.contains(Players.getLocal())) || ((Players.getLocal()
						.getAnimation() == -1)
						&& (Inventory.isFull() && !Attributes.BANK_AREA
								.contains(Players.getLocal())) || (!Inventory
						.isFull() && !Attributes.DOCK_AREA.contains(Players
						.getLocal()))));
	}

}
