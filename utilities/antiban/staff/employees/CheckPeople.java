package antiban.staff.employees;
import java.awt.Point;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.interactive.Player;
import frameWork.staff.WaitingStaff;
import antiban.AntiBan;

public class CheckPeople extends WaitingStaff {
	
	private Area viewArea;
	
	public CheckPeople(Area area){
		viewArea = area;
	}

	@Override
	public boolean condition() {
		return (super.condition() && AntiBan.checkPeople);
	}

	@Override
	public void execute() {
		super.execute();
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
