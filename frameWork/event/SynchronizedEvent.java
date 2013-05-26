package frameWork.event;

public abstract class SynchronizedEvent extends LoopEvent{
	public void join() {
		try {
			myThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
