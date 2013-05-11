package antiban.jobs.nodes;
import java.awt.Point;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.interactive.Player;

import antiban.AntiBan;

import employment.jobManagement.abstracts.WaitingNode;

public class CheckPeople extends WaitingNode {
	
	private Area viewArea;
	
	public CheckPeople(Area area){
		viewArea = area;
	}

	public boolean condition() {
		return AntiBan.checkPeople;
	}

	public void process() {
		Player p = Players.getNearest(new Filter<Player>(){

			@Override
			public boolean accept(Player temp) {
				return (temp != null && viewArea.contains(temp));
			}

		});
		if(p != null && viewArea.contains(p)){
			Mouse.apply(p, new Filter<Point>() {
				public boolean accept(final Point point) {
					if(Mouse.click(false))
						Task.sleep(Random.nextInt(500,1500));
					return true;
				}
			});
		}
	}

}
