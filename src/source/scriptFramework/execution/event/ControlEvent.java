package source.scriptFramework.execution.event;

import org.powerbot.core.script.ActiveScript;

public abstract class ControlEvent extends PrimaryEvent {
	private ActiveScript activeScript;
	public ControlEvent(Event container) {
		super(container);
	}
	
	public ControlEvent(Event container, ActiveScript activeScript){
		super(null);
		this.activeScript = activeScript;
	}
	
	public ActiveScript getActiveScript(){
		return activeScript;
	}

}
