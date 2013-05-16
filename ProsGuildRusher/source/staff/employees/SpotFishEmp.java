package source.staff.employees;
import frameWork.event.Event;

import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.NPC;

import source.Attributes;
import source.userInterface.Paint;

public class SpotFishEmp extends Event{

	@Override
	public boolean condition() {
		return (Players.getLocal().getInteracting() == null || Attributes.fishSpot == null);
	}

	@Override
	public void execute() {
		super.execute();
		Paint.status = "Looking for Fish";
		Attributes.fishSpot = NPCs.getNearest(new Filter<NPC>() {
			@Override
			public boolean accept(NPC n) {
				return (n.getId() == Attributes.fishNpcId && Attributes.DOCK_AREA.contains(n.getLocation()));
			}
		});
		
	}

	

}
