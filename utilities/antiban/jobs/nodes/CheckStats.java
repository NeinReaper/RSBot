package antiban.jobs.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import antiban.AntiBan;

import employment.jobManagement.abstracts.WaitingNode;
public class CheckStats extends WaitingNode {
	
	private WidgetChild fishChild = Widgets.get(320,34);

	public boolean condition() {
		return AntiBan.checkStats;
	}

	public void process() {
		if(Tabs.STATS.open()) {
			Task.sleep(Random.nextInt(50, 500));
			if(fishChild.validate()) {
				if(fishChild.hover()) {
					Task.sleep(Random.nextInt(300, 500));
				}
			}
		}
	}
}
