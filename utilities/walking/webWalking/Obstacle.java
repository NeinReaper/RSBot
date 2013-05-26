package walking.webWalking;

import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Obstacle {
	public int sceneObjectId;
	private SceneObject object;
	private String action;
	public Obstacle(int sceneObjectId, String action){
		this.sceneObjectId = sceneObjectId;
		this.action = action;
	}
	public boolean isOnScreen(){
		object = SceneEntities.getNearest(sceneObjectId);
		return  (object != null && object.isOnScreen());
	}
	public boolean interact(String action){
		return (object != null && object.interact(action));
	}
	public boolean click(boolean rightClick){
		return (object != null && object.click(rightClick));
	}
	public String getAction(){
		return action;
	}
}
