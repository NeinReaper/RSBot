package walking.webWalking;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.wrappers.interactive.Player;
public class Walker {
	private Player myPlayer;
	private DataPath path;
	private Database dataBase;
	public Walker(Player myPlayer){
		this.myPlayer = myPlayer;
		dataBase = new Database();
	}
	public boolean walk(boolean reverse){
		if(path == null){
			path = getNearestPath();
		} else {
			if(reverse){
				path.reverse();
			}
			Obstacle temp = path.getObstacle();
			if(temp != null){
				if(temp.click(false)){
					do{
						Task.sleep(100);
					} while(!myPlayer.isIdle());
				}
			}
			return path.getNext().clickOnMap();
		}
		return false;
	}
	private DataPath itPath;
	public DataPath getNearestPath(){
		for(int i = 0; i < dataBase.size(); i++){
			if(dataBase.get(i) != null){
				itPath = dataBase.get(i);
			}
			if(dataBase.get(i+1) != null){
				double d1 = Calculations.distanceTo(dataBase.get(i+1).getFirst()),
						d2 = Calculations.distanceTo(itPath.getFirst());
				if(d1 < d2){
					itPath = dataBase.get(i+1);
				}
			}
		}
		return itPath;
		
	}
}
