package frameWork.event;

import frameWork.EventContainer;

public abstract class LoopParentEvent extends LoopEvent{
	private EventContainer container;
	/*
	 * Has a container of staffs, which will only be executed from this staff, not the main container
	 */
	public LoopParentEvent(Event...staffs){
		super();
		container = new EventContainer();
		submit(staffs);
	}
	@Override
	public void loop() {
		container.employ();
	}

	public void submit(Event...staffs){
		container.submit(staffs);
	}
	public void revoke(Event...staffs){
		container.revoke(staffs);
	}
}
