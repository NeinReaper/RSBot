package deprecatedNodeSystem;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
public abstract class WaitingNode extends Node{
	private Timer waitTimer;
	private int waitingTime;
	
	public WaitingNode(){
		waitingTime = Random.nextInt(1800000, 5400000);//default: 30 - 90 mins
	}
	
	public WaitingNode(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	public abstract void process();
	public abstract boolean condition();
	
	@Override
	public boolean activate() {
		return ((waitTimer == null || (waitTimer != null && waitTimer.getRemaining() < waitingTime/10)) && condition());
	}
	@Override
	public void execute() {
			waitTimer = new Timer(waitingTime);
			process();
	}
}
