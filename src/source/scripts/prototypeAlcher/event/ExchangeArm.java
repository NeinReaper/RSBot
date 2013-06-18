package source.scripts.prototypeAlcher.event;

import source.scriptFramework.execution.event.Event;
import source.scriptFramework.execution.event.SecondaryEvent;

public class ExchangeArm extends SecondaryEvent{
	private boolean needsToExchange = true;
	public ExchangeArm(Event container, Event[] arm) {
		super(container, arm);
	}

	@Override
	public boolean accept() {
		return needsToExchange;
	}

}
