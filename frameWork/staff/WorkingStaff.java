package frameWork.staff;

public abstract class WorkingStaff extends Staff implements Runnable{
	private Thread myThread;
	private volatile boolean isRunning = false;
	public abstract void process();
	
	/**
	 * Executes if its thread has not been started
	 */
	@Override
	public void execute() {
		if(myThread == null || !myThread.isAlive()) {
			myThread = new Thread(this);
			myThread.start();
		}
	}
	
	/**
	 * calls process() within its runnable object
	 */
	public void run(){
		isRunning = condition();
		while(isRunning) {
			process();
		}
	}
	
	public boolean isRunning(){
		return isRunning;
	}
	
	public void shutDown(){
		isRunning = false;
	}
	
	/**
	 * delays the WorkingStaff
	 */
	public void delay(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
