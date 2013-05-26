package source.event.events;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import frameWork.event.Event;
import source.Attributes;
import source.userInterface.Frame;
import source.userInterface.Painter;
public class FishEvent extends Event{

	@Override
	public boolean condition() {
		return (Attributes.fishSpot != null && (Players.getLocal().getInteracting() == null));
	}

	@Override
	public void execute() {
		super.execute();
		try{
			if(Attributes.fishSpot.isOnScreen() && Attributes.fishSpot.interact(Frame.clickAction)) {
				Painter.status = "Fishing";
				do{
					Task.sleep(500);
				} while(Players.getLocal().isMoving());
				
				WalkingEvent.path = null;
			} else {
				Camera.turnTo(Attributes.fishSpot);
			}


		} catch(NullPointerException e){
			e.printStackTrace();
		}
	}
}
