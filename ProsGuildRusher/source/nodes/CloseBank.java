package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import source.resources.Attributes;
import source.userInterface.Paint;

public class CloseBank extends Node{

	@Override
	public boolean activate() {
		return (Bank.isOpen() && !Inventory.contains(Attributes.fishId));
	}

	@Override
	public void execute() {
		if(Bank.close())
			Paint.status = "closing bank";
	}

	

}
