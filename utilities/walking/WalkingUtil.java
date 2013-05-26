package walking;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public class WalkingUtil {
	public static void walk(boolean reverse, final Tile[] PATH) {
		TilePath path = Walking.newTilePath(PATH);
		if(reverse){
			path.reverse();
		}
		path.traverse();
		Task.sleep(500);
	}
	public static void walk(boolean reverse, final TilePath PATH) {
		final TilePath temp = PATH;
		if(reverse){
			temp.reverse();
		} 
		temp.traverse();
		do{
			Task.sleep(100);
		} while(temp.getNext() != null && Calculations.distanceTo(temp.getNext()) > 5);
	}
	

}
