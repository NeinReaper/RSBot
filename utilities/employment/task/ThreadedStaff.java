package employment.task;

public abstract class ThreadedStaff extends Staff implements Runnable{
	private Thread myThread;
	@Override
	public void execute() {
		if(myThread == null || !myThread.isAlive()) {
			myThread = new Thread(this);
			myThread.start();
		}
			
		
	}
	public void run(){
		while(condition()) {
			process();
		}
	}
	public abstract void process();
}
