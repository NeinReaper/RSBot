package antiban.jobs;
import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;

import antiban.AntiBan;
public class AntiBanBranch extends Branch {


	public AntiBanBranch(Node[] employees) {
		super(employees);
	}

	@Override
	public boolean branch() {
		return AntiBan.useAntiBan;
	}
}
