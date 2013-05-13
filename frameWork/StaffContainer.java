package frameWork;

import java.util.ArrayList;

import frameWork.staff.Janitor;
import frameWork.staff.Staff;


public class StaffContainer extends ArrayList<Staff>{
	private Janitor janitor;
	private static final int DEFAULT_CLEANUP_TIME = 360000;//1 hour
	
	/**
	 * Contains an arraylist of type Staff
	 * submits the default staff object to itself (garbage collection system)
	 */
	public StaffContainer(){
		super();
		janitor = new Janitor(this, DEFAULT_CLEANUP_TIME);
		janitor.setForceRemain(true);
		submit(janitor);
	}
	
	/**
	 * loops through all the staff objects and executes them
	 */
	public void employ(){
		for(Staff s : toArray(new Staff[size()])){
			if(s != null){
				if(s.condition()) {
					s.execute();
				}	
			}
		}
	}
	
	/**
	 * submits the trainees to be executed
	 * @param trainees to be scheduled for execution
	 */
	public void submit(Staff... trainees){
		for(Staff t : trainees){
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
	public void revoke(Staff... staff){
		for(Staff s : staff){
			if(s != null){
				s.setForceCollect(true);
			}
		}
	}
	
	public void revoke(int id){
		Staff s = get(id);
		revoke(s);
	}
	
	public void collectGarbage() {
		for(Staff s : this){
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
