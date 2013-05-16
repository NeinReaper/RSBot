package frameWork.event;

import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;

public class DelayedEvent extends Event{
	private Timer waitTimer;
	private int waitingTime;
	public DelayedEvent(){
		waitingTime = Random.nextInt(1800000, 5400000);//default: 30 - 90 mins
	}
	
	public DelayedEvent(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	@Override
	public boolean condition() {
		return ((waitTimer == null || (waitTimer != null && waitTimer.getRemaining() < waitingTime/10)));
	}
	
	@Override
	public void execute() {
		super.execute();
		waitTimer = new Timer(waitingTime);
	}
	

}
