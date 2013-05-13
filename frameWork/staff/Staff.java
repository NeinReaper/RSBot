package frameWork.staff;

import org.powerbot.game.api.util.Timer;

public abstract class Staff{
	protected long timeIdle, startTime, lastProcess;
	private long garbageTime = 21600000;//21600000 = 6 hours(default)
	private boolean forceCollect = false, forceRemain = false;
	private Timer garbageCollection;
	
	/**
	 * Event which can be executed if a condition is met
	 * contains its own system of garbage collection, modified by the user
	 */
	public Staff(){
		timeIdle = 0;
		startTime = System.currentTimeMillis();
		garbageCollection = new Timer(garbageTime);
	}
	public void execute() {
		timeIdle = 0;
		lastProcess = System.currentTimeMillis();
		process();
	}
	
	public boolean condition() {
		return activate();//need this open condition for future updates
	}
	
	public boolean isGarbage(){
		return (!forceRemain && ((garbageCollection == null && lastProcess > garbageTime/2) || forceCollect));
	}
	
	public void setForceCollect(boolean b){
		forceCollect = b;
	}
	
	public void setForceRemain(boolean b){
		forceRemain = b;
	}
	
	public void setGarbageTime(long time){
		garbageTime = time;
	}
	
	public abstract boolean activate();
	public abstract void process();
	
}
