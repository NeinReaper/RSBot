package source.employees;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.Player;

import source.resources.ScriptAttributes;
import employment.task.Staff;

public class PlayerViewingEmployee extends Staff{

	@Override
	public void execute() {
		for(Player p : Players.getLoaded()) {
			if(p != null){
				if(p.contains(Mouse.getLocation()))
					ScriptAttributes.playerToDraw = p;
				else {
					ScriptAttributes.playerToDraw = null;
					ScriptAttributes.logger.logg("PlayerViewingEmployee.execute", "player = null");
				}
					
				//(ScriptAttributes.displayNames)
					
			}
		}
	}

	@Override
	public boolean condition() {
		return (ScriptAttributes.highLightPlayers || ScriptAttributes.displayNames);
	}

	

}
