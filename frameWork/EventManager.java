package frameWork;
import org.powerbot.game.api.util.Random;

import frameWork.event.Event;

public class EventManager extends Thread implements Runnable{
	private EventContainer container;
	private boolean isRunning = false;
	private Thread myThread;
	public EventManager(){
		container = new EventContainer();
		//myLock = new ThreadLock;
	}
	@Override
	public void run(){
		try{
			while(isRunning){
				container.employ();
				delay(Random.nextInt(50, 150));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			shutDown();
		}
		
	}
	
	public void startUp(){
		isRunning = true;
		myThread = new Thread(this);
		myThread.start();
	}
	
	public void shutDown(){
		container.collectGarbage();
		isRunning = false;
		myThread = null;
	}
	
	public boolean isRunning(){
		return isRunning;
	}
		
	public EventContainer getContainer(){
		return container;
	}
	
	public void delay(int millis){
		try {
			EventManager.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
