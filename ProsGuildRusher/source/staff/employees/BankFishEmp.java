package source.staff.employees;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import frameWork.staff.Staff;
import source.Attributes;
import source.userInterface.Paint;

public class BankFishEmp extends Staff{
	@Override
	public boolean activate() {
		return (Inventory.isFull()) && Attributes.BANK_AREA.contains(Players.getLocal());
				
	}
	@Override
	public void execute() {
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
