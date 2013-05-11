package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import source.resources.Attributes;
import source.userInterface.Frame;
import source.userInterface.Paint;

public class InteractWithFish extends Node{

	@Override
	public boolean activate() {
		return (Attributes.fishSpot != null && Attributes.DOCK_AREA.contains(Attributes.fishSpot.getLocation()) && (Players.getLocal().getInteracting() == null));
	}

	@Override
	public void execute() {
		if(Attributes.fishSpot.interact(Frame.clickAction))
			Paint.status = "Fishing";
		else	
			Camera.turnTo(Attributes.fishSpot);
	}

	

}
