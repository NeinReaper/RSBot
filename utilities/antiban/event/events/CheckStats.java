package antiban.event.events;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import frameWork.event.DelayedEvent;

import antiban.AntiBan;

public class CheckStats extends DelayedEvent {
	
	private WidgetChild fishChild = Widgets.get(320,34);

	public boolean check() {
		return AntiBan.checkStats;
	}

	public void loop() {
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
