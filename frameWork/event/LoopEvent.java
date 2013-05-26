package frameWork.event;

public abstract class LoopEvent extends Event implements Runnable {
	protected Thread myThread;
	private volatile boolean isRunning = false;

	public abstract int loop();

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
			try {
				Thread.sleep(loop());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	public boolean isRunning() {
		return isRunning;
	}

	public void shutDown() {
		isRunning = false;
	}
}
