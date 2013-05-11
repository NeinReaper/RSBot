package source.branches;

import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.Player;

import source.resources.Attributes;

public class FishingBranch extends Branch{

	public FishingBranch(Node[] arg0) {
		super(arg0);
	}

	@Override
	public boolean branch() {
		Player p = Players.getLocal();
		return ((Game.isLoggedIn() && !Attributes.showGui) &&(p.getInteracting() == null) && (Attributes.DOCK_AREA.contains(p) && !Inventory.isFull()));
	}

	

}
