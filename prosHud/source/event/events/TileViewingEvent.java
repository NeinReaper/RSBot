package source.event.events;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.Player;
import frameWork.event.LoopEvent;
import source.resources.ScriptAttributes;
public class TileViewingEvent extends LoopEvent{
	private Tile tileIterator;
	
	@Override
	public int loop() {
		Player p = Players.getLocal();
		if(p!= null){
			//Walking.getc
			for(int xIterator = -52; xIterator < 52; xIterator++){
				for(int yIterator = 52; yIterator > -52; yIterator--){
					tileIterator = p.getLocation().derive(xIterator, yIterator);
					if(tileIterator.contains(Mouse.getLocation())) {
						ScriptAttributes.mouseTile = tileIterator;
					}
				}
			}
		}
		return Random.nextInt(100,200);
	}

	@Override
	public boolean condition() {
		return (!ScriptAttributes.mouseTile.contains(Mouse.getLocation()));
	}

}
