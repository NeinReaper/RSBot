package frameWork.event;

import org.powerbot.game.api.util.Random;

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
	public int loop() {
		container.employ();
		return Random.nextInt(550, 650);
	}

	public void submit(Event...staffs){
		container.submit(staffs);
	}
	public void revoke(Event...staffs){
		container.revoke(staffs);
	}
}
