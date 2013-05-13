package source.staff.employees;
import frameWork.staff.Staff;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import source.Attributes;
import walking.WalkingUtil;

public class WalkingEmp extends Staff{

	@Override
	public boolean activate() {
		return ((Players.getLocal().getAnimation() == -1) 
					&& (Inventory.isFull() 
						&& !Attributes.BANK_AREA.contains(Players.getLocal())) 
							|| (!Inventory.isFull() 
									&& !Attributes.DOCK_AREA.contains(Players.getLocal())));
	}

	@Override
	public void execute() {
		if(!Inventory.isFull())
			WalkingUtil.walk(true, Attributes.BANKING_PATH);
		else {
			WalkingUtil.walk(false, Attributes.BANKING_PATH);
		}
		
	}

}
