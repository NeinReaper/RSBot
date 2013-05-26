package source.event.events;
import frameWork.event.Event;
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
		return !Players.getLocal().isMoving() && (Inventory.isFull() && !Attributes.BANK_AREA.contains(Players.getLocal())) 
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
				if(Attributes.D_AREA_1.contains(Players.getLocal().getLocation())){
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
