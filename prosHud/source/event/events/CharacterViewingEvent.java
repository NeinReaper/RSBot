package source.event.events;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.Character;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.interactive.Player;
import frameWork.event.LoopEvent;
import source.resources.ScriptAttributes;

public class CharacterViewingEvent extends LoopEvent{
	@Override
	public int loop() {
		for(NPC n : NPCs.getLoaded()){
			if(!ScriptAttributes.characters.contains(n)) {
				ScriptAttributes.characters.add(n);
			}	
		}
		for(Player p : Players.getLoaded()){
			if(!ScriptAttributes.characters.contains(p)){
				ScriptAttributes.characters.add(p);
			}
		}
		for(Character e : ScriptAttributes.characters){
			if(e.getLocation().contains(Mouse.getLocation())){
				ScriptAttributes.eToDraw = e;
			}
		}
		return Random.nextInt(400,500);
	}

	@Override
	public boolean condition() {
		return (ScriptAttributes.highLightEntities || ScriptAttributes.displayNames);
	}

}
