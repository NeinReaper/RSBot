package source.event.events;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import frameWork.event.Event;
import source.Attributes;
import source.userInterface.Paint;

public class BankEvent extends Event{
	@Override
	public boolean condition() {
		return (Inventory.isFull()) && Attributes.BANK_AREA.contains(Players.getLocal());
				
	}
	@Override
	public void execute() {
		super.execute();
		if(Bank.open()) {
			Paint.status = "opening bank";
			if(Bank.depositInventory()) {
				Paint.status = "Depositing Fish";
				if(Bank.close()) {
					Paint.status = "Closing Bank";
				}
			}
				
		}

	}
}