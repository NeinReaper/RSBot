package employment.task;

import java.util.ArrayList;

import org.powerbot.game.api.util.Random;

public class Employer extends Thread implements Runnable{
	private ArrayList<Staff> container;
	private volatile boolean running = true;
	private Thread myThread;
	public Employer() {
		container = new ArrayList<Staff>();
		myThread = new Thread(((Thread)this));
		myThread.start();
	}
	@Override
	public void run() {
		while(running) {
			for(Staff employee : container){
				if(employee.condition()) {
					employee.execute();
				}
			}
			delay(Random.nextInt(50,100));
		}
		shutdown();
	}
	public void shutdown(){
		running = false;
	}
	public void submit(Staff... trainee){
		for(Staff t : trainee){
			if(t != null) {
				container.add(t);
			}
		}
	}
	public static void delay(long millis){
		try {
			Employer.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
