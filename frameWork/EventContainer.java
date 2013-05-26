package frameWork;
import java.util.ArrayList;
import frameWork.event.*;

public class EventContainer extends ArrayList<Event>{
	private Janitor janitor;
	private static final int DEFAULT_CLEANUP_TIME = 360000;//1 hour
	public static boolean shutDown = false;
	
	/**
	 * Contains an arraylist of type Event
	 * submits the default staff object to itself (garbage collection system)
	 */
	public EventContainer(){
		janitor = new Janitor(this, DEFAULT_CLEANUP_TIME);
		janitor.setForceRemain(true);
		submit(janitor);
	}
	
	/**
	 * loops through all the staff objects and executes them
	 */
	public synchronized void employ(){
		if(!shutDown){
			for(Event s : toArray(new Event[size()])){
				synchronized(s){
					if(s != null){
						if(!shutDown &&s.condition()) {
							s.execute();
							if(s instanceof SynchronizedEvent){
								((SynchronizedEvent)s).join();
							}
						}	
					}
				}
			}
		}
	}
	
	/**
	 * submits the trainees to be executed
	 * @param trainees to be scheduled for execution
	 */
	public void submit(Event... trainees){
		for(Event t : trainees){
			if(t != null) {
				add(t);
			}
		}
	}	

	/**
	 * Utilizes the garbage collection system, this will wait until garbage is to be collected
	 * just incase it still may need to be executed once more
	 *  
	 */
	public void revoke(Event... staff){
		for(Event s : staff){
			if(s != null){
				s.setForceCollect(true);
			}
		}
	}
	
	public void revoke(int id){
		Event s = get(id);
		revoke(s);
	}
	
	public void collectGarbage() {
		shutDown = true;
		for(Event s : this){
			if(s != null){
				revoke(s);
			}
		}
		janitor.loop();
	}
	
	public void updateGarbage(){
		janitor.loop();
	}
	
}
