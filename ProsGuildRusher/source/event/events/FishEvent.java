package source.event.events;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;

import frameWork.event.Event;
import source.Attributes;
import source.userInterface.Frame;
import source.userInterface.Paint;

public class FishEvent extends Event{

	@Override
	public boolean condition() {
		return (Attributes.fishSpot != null && Attributes.DOCK_AREA.contains(Attributes.fishSpot.getLocation()) && (Players.getLocal().getInteracting() == null));
	}

	@Override
	public void execute() {
		super.execute();
		try{
			if(Attributes.fishSpot.interact(Frame.clickAction)) {
				Paint.status = "Fishing";
			} else {
				Camera.turnTo(Attributes.fishSpot);
			}
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		

	}



}
