package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import source.resources.Attributes;

import walking.WalkingUtil;

public class WalkBack extends Node{

	@Override
	public boolean activate() {
		return ((!Inventory.isFull()));
	}

	@Override
	public void execute() {
		WalkingUtil.walk(true, Attributes.BANKING_PATH);
		
	}

}
