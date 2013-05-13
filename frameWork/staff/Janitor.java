package frameWork.staff;

import frameWork.StaffContainer;

public class Janitor extends WorkingStaff{
	private StaffContainer container;//list to cleanup from
	private long cleanUpTime = 0;//will collect garbage every cleanUpTime milliseconds
	private int count = 0;

	/**
	 * @param container list to collect garbage from
	 * @param garbageTime loop time to collect garbage, 
	 */
	public Janitor(StaffContainer container, long cleanUpTime){
		this.container = container;
		this.cleanUpTime = cleanUpTime;
	}

	/**
	 * @returns true if its time to collect garbage
	 */
	@Override
	public boolean activate() {
		return timeIdle > cleanUpTime;
	}

	/**
	 * Removes Staff if its been idle for too long(default time is 6 hours)
	 */
	@Override
	public void loop() {
		count++;
		System.out.println("Garbage Collection ran: "+ count);
		for(Staff s : container.toArray(new Staff[container.size()])){
			if(s != null && !(s instanceof Janitor)) {//just incase something goes wrong
				if(s.isGarbage()) {
					collect(s);
				}
			}
		}
		
	}

	/**
	 * Removes Staff from execution schedule
	 */
	public void collect(Staff... staff){
		for(Staff s : staff){
			if(s != null){
				if(s instanceof WorkingStaff){
					revoke((WorkingStaff)s);
				} else {
					container.remove(s);
				}
				System.out.println("collected: "+s);
			}
		}
	}

	/**
	 * Removes WorkingStaff from execution schedule and properly shuts it down
	 */
	private void revoke(WorkingStaff... staff){
		for(WorkingStaff s : staff){
			if(s!= null){
				s.shutDown();
				container.remove(s);
			}
		}
	}	
}
