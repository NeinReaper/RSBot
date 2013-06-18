package source.scriptFramework.execution.event;

import org.powerbot.core.script.ActiveScript;

public abstract class Event{
	protected boolean shutDown = false;
	public abstract void cycle();
	public abstract boolean accept();
	private Event container;
	public Event(Event container){
		this.container = container;
	}
	public void execute(){
		if(!shutDown){
			cycle();
		}
	}
	public void shutDown(){
		shutDown = true;
	}
	
	public Event getContainer(){
		return container;
	}
	
	public ActiveScript getScript(){
		Event currentEvent = this;
		while(!(currentEvent instanceof ControlEvent)){
			currentEvent = currentEvent.getContainer();
		}
		return currentEvent instanceof ControlEvent ? ((ControlEvent)currentEvent).getActiveScript() : null;
	}
}
