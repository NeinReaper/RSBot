package source.employees;
import org.powerbot.game.api.methods.input.Mouse;

import source.resources.ScriptAttributes;
import employment.task.Staff;

public class TileViewingEmployee extends Staff{
	@Override
	public void execute() {
		for(int xIterator = -52; xIterator < 52; xIterator++){
			for(int yIterator = 52; yIterator > -52; yIterator--){
				ScriptAttributes.tileIterator = ScriptAttributes.myPlayer.getLocation().derive(xIterator, yIterator);
				if(ScriptAttributes.tileIterator.contains(Mouse.getLocation())) {
					ScriptAttributes.mouseTile = ScriptAttributes.tileIterator;
				}
			}
		}
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.mouseTile.contains(Mouse.getLocation()));
	}

}
