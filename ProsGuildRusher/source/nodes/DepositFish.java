package source.nodes;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.widget.Bank;

import source.userInterface.Paint;

public class DepositFish extends Node {

	@Override
	public boolean activate() {
		return Bank.isOpen();
	}

	@Override
	public void execute() {
		if(Bank.depositInventory())
			Paint.status = "Depositing Fish";
	}

}
