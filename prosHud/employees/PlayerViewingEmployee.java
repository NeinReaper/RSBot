package employees;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.Player;

import frameWork.staff.Staff;

import source.resources.ScriptAttributes;

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
			}
		}
	}

	@Override
	public boolean activate() {
		return (ScriptAttributes.highLightPlayers || ScriptAttributes.displayNames);
	}
}
