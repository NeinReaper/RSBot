package antiban;
import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.wrappers.Area;

import antiban.jobs.AntiBanBranch;
import antiban.jobs.nodes.CheckPeople;
import antiban.jobs.nodes.CheckStats;

import source.resources.Attributes;
public class AntiBan {
	public static boolean useAntiBan, checkStats, checkPeople;
	public Branch myBranch;
	public AntiBan(boolean use, boolean stats, boolean people, Area checkPeopleArea) {
		useAntiBan = use;
		checkStats = stats;
		checkPeople = people;
		myBranch = new AntiBanBranch(new Node[]{new CheckStats(), new CheckPeople(checkPeopleArea)});
		
	}
}
