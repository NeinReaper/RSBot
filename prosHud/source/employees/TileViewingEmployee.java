package source.employees;
import org.powerbot.game.api.methods.input.Mouse;

import source.resources.ScriptAttributes;
import employment.task.Staff;

public class TileViewingEmployee extends Staff{
	@Override
	public void execute() {
		for(int xIterator = -104; xIterator < 104; xIterator++) {
			for(int yIterator = 104; yIterator >= -104; yIterator--) {
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
