package source.event.events;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.Player;

import frameWork.event.Event;

import source.resources.ScriptAttributes;

public class PlayerViewingEvent extends Event{

	@Override
	public void execute() {
		super.execute();
		for(Player p : Players.getLoaded()) {
			if(p != null){
				if(p.getModel().contains(Mouse.getLocation()))
					ScriptAttributes.playerToDraw = p;
			}
		}
	}

	@Override
	public boolean condition() {
		return (ScriptAttributes.highLightPlayers || ScriptAttributes.displayNames);
	}
}
