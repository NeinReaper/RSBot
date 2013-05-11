package source.branches;
import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import source.resources.Attributes;

public class WalkingAndBanking extends Branch{

	public WalkingAndBanking(Node[] arg0) {
		super(arg0);
	}

	@Override
	public boolean branch() {
		return ((Game.isLoggedIn() && !Attributes.showGui)) 
				
				&& (((Inventory.isFull() || Bank.isOpen())
						&& Attributes.BANK_AREA.contains(Players.getLocal()))
				
				|| ((Players.getLocal().getAnimation() == -1) 
						&& (Inventory.isFull() 
								&& !Attributes.BANK_AREA.contains(Players.getLocal())) 
									|| (!Inventory.isFull() 
											&& !Attributes.DOCK_AREA.contains(Players.getLocal()))));
	}


}
