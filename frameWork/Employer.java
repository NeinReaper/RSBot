package frameWork;

import java.util.concurrent.locks.Lock;

import frameWork.staff.Staff;
import frameWork.util.Random;

public class Employer extends Thread implements Runnable{
	private StaffContainer container;
	private boolean isRunning = false;
	private Thread myThread;
	private Lock myLock;
	public Employer(){
		container = new StaffContainer();
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
		
	public StaffContainer getContainer(){
		return container;
	}
	
	public void delay(int millis){
		try {
			Employer.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
