package frameWork.staff;
public abstract class Staff{
	protected long timeIdle;//21600000 = 6 hours(default)
	private long garbageTime = 10000, startTime;
	private boolean isGarbage = false, forceCollect = false;
	
	/**
	 * Event which can be executed if a condition is met
	 * contains its own system of garbage collection, modified by the user
	 */
	public Staff(){
		timeIdle = 0;
		startTime = System.currentTimeMillis();
	}
	
	public boolean condition() {
		if(activate()) {
			timeIdle = 0;
			isGarbage = false;
			return true;
		}
		timeIdle = System.currentTimeMillis()-startTime;
		return false;
	}
	
	public boolean isGarbage(){
		isGarbage = timeIdle > garbageTime;
		return (isGarbage || forceCollect);
	}
	
	public void forceCollect(){
		forceCollect = true;
	}
	
	public void setGarbageTime(long time){
		garbageTime = time;
	}
	
	public abstract boolean activate();
	public abstract void execute();
}
