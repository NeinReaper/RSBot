package source.staff.employees;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;

import frameWork.event.Event;
import source.Attributes;
import source.userInterface.Frame;
import source.userInterface.Paint;

public class InteractWithFishEmp extends Event{

	@Override
	public boolean condition() {
		return (Attributes.fishSpot != null && Attributes.DOCK_AREA.contains(Attributes.fishSpot.getLocation()) && (Players.getLocal().getInteracting() == null));
	}

	@Override
	public void execute() {
		super.execute();
		if(Attributes.fishSpot.interact(Frame.clickAction))
			Paint.status = "Fishing";
		else 	
			Camera.turnTo(Attributes.fishSpot);
	}

	

}
