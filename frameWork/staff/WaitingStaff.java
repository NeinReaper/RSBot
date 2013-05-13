package frameWork.staff;

import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;

public abstract class WaitingStaff extends Staff{
	private Timer waitTimer;
	private int waitingTime;
	public WaitingStaff(){
		waitingTime = Random.nextInt(1800000, 5400000);//default: 30 - 90 mins
	}
	
	public WaitingStaff(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	@Override
	public boolean activate() {
		return ((waitTimer == null || (waitTimer != null && waitTimer.getRemaining() < waitingTime/10)) && check());
	}
	
	@Override
	public void process() {
			waitTimer = new Timer(waitingTime);
			loop();
	}
	
	public abstract void loop();
	public abstract boolean check();

}
