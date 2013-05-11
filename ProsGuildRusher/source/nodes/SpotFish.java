package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.NPC;
import source.resources.Attributes;
import source.userInterface.Paint;

public class SpotFish extends Node{

	@Override
	public boolean activate() {
		return (Players.getLocal().getInteracting() == null || Attributes.fishSpot == null);
	}

	@Override
	public void execute() {
		Paint.status = "Looking for Fish";
		Attributes.fishSpot = NPCs.getNearest(new Filter<NPC>() {
			@Override
			public boolean accept(NPC n) {
				return (n.getId() == Attributes.fishNpcId && Attributes.DOCK_AREA.contains(n.getLocation()));
			}
		});
		
	}

	

}
