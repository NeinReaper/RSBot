package source.branches;
import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import source.resources.Attributes;

public class WalkingBranch extends Branch{

	public WalkingBranch(Node[] arg0) {
		super(arg0);
	}

	@Override
	public boolean branch() {
		return ((Game.isLoggedIn() && !Attributes.showGui) && ((Game.isLoggedIn() && !Attributes.showGui) && (Players.getLocal().getAnimation() == -1) && (Inventory.isFull() && !Attributes.BANK_AREA.contains(Players.getLocal())) || (!Inventory.isFull() && !Attributes.DOCK_AREA.contains(Players.getLocal()))));
	}


}
