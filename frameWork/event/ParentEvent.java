package frameWork.event;

import frameWork.EventContainer;

public abstract class ParentEvent extends Event{
	private EventContainer container;
	public ParentEvent(Event[] employees){
		super();
		container = new EventContainer();
		container.submit(employees);
	}
	
	public void execute(){
		super.execute();
		container.employ();
	}
}
