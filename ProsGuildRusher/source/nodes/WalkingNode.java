package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import source.resources.Attributes;

import walking.WalkingUtil;

public class WalkingNode extends Node{

	@Override
	public boolean activate() {
		return ((Players.getLocal().getAnimation() == -1) 
					&& (Inventory.isFull() 
						&& !Attributes.BANK_AREA.contains(Players.getLocal())) 
							|| (!Inventory.isFull() 
									&& !Attributes.DOCK_AREA.contains(Players.getLocal())));
	}

	@Override
	public void execute() {
		if(!Inventory.isFull())
			WalkingUtil.walk(true, Attributes.BANKING_PATH);
		else {
			WalkingUtil.walk(false, Attributes.BANKING_PATH);
		}
		
	}

}
