package frameWork.staff;

public abstract class WorkingStaff extends Staff implements Runnable {
	private Thread myThread;
	private volatile boolean isRunning = false;

	public abstract void loop();

	/**
	 * Executes if its thread has not been started
	 */
	@Override
	public void execute() {
		super.execute();
		if (myThread == null || !myThread.isAlive()) {
			myThread = new Thread(this);
			myThread.start();
		}
	}

	/**
	 * calls process() within its runnable object
	 */
	public void run() {
		isRunning = condition();
		while (isRunning) {
			loop();
		}
	}

	public void join() {
		try {
			myThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void shutDown() {
		isRunning = false;
	}

	/**
	 * delays the WorkingStaff
	 */
	public void delay(long millis) {
		try {
			myThread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
