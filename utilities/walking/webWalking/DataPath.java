package walking.webWalking;
import java.util.ArrayList;

import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public class DataPath {
	private final Tile[] PATH;
	private final TilePath TILE_PATH;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public DataPath(final Tile[] path){
		this.PATH = path;
		TILE_PATH = Walking.newTilePath(PATH);
	}
	public DataPath(final Tile[] path, Obstacle... obstacles){
		this.PATH = path;
		for(Obstacle obstacle : obstacles){
			this.obstacles.add(obstacle);
		}
		TILE_PATH = Walking.newTilePath(PATH);
	}
	public Tile getNext(){
		return TILE_PATH.getNext();
	}
	public Tile getEnd(){
		return TILE_PATH.getEnd();
	}
	public Tile getFirst(){
		return TILE_PATH.getStart();
	}
	public Obstacle getObstacle(){
		for(Obstacle obstacle : obstacles){
			if(obstacle != null && obstacle.isOnScreen()){
				return obstacle;
			}
		}
		return null;
	}
	public void reverse(){
		TILE_PATH.reverse();
	}
	
	
}
