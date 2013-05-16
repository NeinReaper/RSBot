package frameWork.event;

import frameWork.EventContainer;

public class Janitor extends LoopEvent{
	private EventContainer container;//list to cleanup from
	private long cleanUpTime = 0;//will collect garbage every cleanUpTime milliseconds
	private int count = 0;

	/**
	 * @param container list to collect garbage from
	 * @param garbageTime loop time to collect garbage, 
	 */
	public Janitor(EventContainer container, long cleanUpTime){
		super();
		this.container = container;
		this.cleanUpTime = cleanUpTime;
	}

	/**
	 * @returns true if its time to collect garbage
	 */
	@Override
	public boolean condition() {
		return timeIdle > cleanUpTime;
	}

	/**
	 * Removes Event if its been idle for too long(default time is 6 hours)
	 */
	@Override
	public void loop() {
		count++;
		System.out.println("Garbage Collection ran: "+ count);
		for(Event s : container.toArray(new Event[container.size()])){
			synchronized(s){
				if(s != null && !(s instanceof Janitor)) {//just incase something goes wrong
					if(s.isGarbage()) {
						collect(s);
					}
				}
			}
		}
		
	}

	/**
	 * Removes Event from execution schedule
	 */
	public void collect(Event... staff){
		for(Event s : staff){
			if(s != null){
				if(s instanceof LoopEvent){
					revoke((LoopEvent)s);
				} else {
					container.remove(s);
				}
				System.out.println("collected: "+s);
			}
		}
	}

	/**
	 * Removes LoopEvent from execution schedule and properly shuts it down
	 */
	private void revoke(LoopEvent... staff){
		for(LoopEvent s : staff){
			if(s!= null){
				s.shutDown();
				container.remove(s);
			}
		}
	}	
}
