package source.event.events;
import frameWork.event.Event;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;
import source.Attributes;
import source.userInterface.Painter;
import walking.WalkingUtil;
public class WalkingEvent extends Event {
	public static boolean start = true;
	public static Tile[] path;
	@Override
	public boolean condition() {
		return (Inventory.isFull() && !Attributes.BANK_AREA.contains(Players.getLocal())) 
				|| (!Inventory.isFull() && !Attributes.D_AREA.contains(Players.getLocal()));
	}

	@Override
	public void execute() {
		super.execute();
		if (!Inventory.isFull()) {
			WalkingUtil.walk(true, Attributes.BANKING_PATH);
			Painter.status = "Walking";
		}

		else {
			if(path == null){
				double d1 = Calculations.distanceTo(Attributes.BANKING_PATH_1[0]),
						d2 = Calculations.distanceTo(Attributes.BANKING_PATH[0]);
				if(d1 < d2) {
					path = Attributes.BANKING_PATH_1;
				} else {
					path = Attributes.BANKING_PATH;
				}
				
			}
			WalkingUtil.walk(false, path);
			Painter.status = "Walking";

		}

	}

}
