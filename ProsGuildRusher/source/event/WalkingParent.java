package source.event;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;

import source.Attributes;

import frameWork.event.Event;
import frameWork.event.ParentEvent;
public class WalkingParent extends ParentEvent {

	public WalkingParent(Event[] employees) {
		super(employees);
	}

	@Override
	public boolean condition() {
		return (Game.isLoggedIn() && !Attributes.showGui && Players.getLocal().getAnimation() == -1);
	}

}
