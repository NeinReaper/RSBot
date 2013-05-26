package source.event.events;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import source.resources.ScriptAttributes;

import frameWork.event.LoopEvent;
public class AreaViewingEvent extends LoopEvent{
	private Tile c = ScriptAttributes.clickedTile, m = ScriptAttributes.mouseTile;
	@Override
	public int loop() {
		
		ScriptAttributes.areaToDraw = new Area(c, m);
		return Random.nextInt(50, 150);
	}

	@Override
	public boolean condition() {
		c = ScriptAttributes.clickedTile;
		m = ScriptAttributes.mouseTile;
		return (c != null && m != null && c.isOnScreen());
	}

}
