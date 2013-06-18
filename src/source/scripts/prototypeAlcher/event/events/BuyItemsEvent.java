package source.scripts.prototypeAlcher.event.events;

import org.powerbot.core.script.job.Task;

import source.scriptFramework.execution.event.Event;
import source.scripts.prototypeAlcher.PrototypeAlcher;
import source.util.GrandExchange;

public class BuyItemsEvent extends Event {
	private GrandExchange grandExchange;
	public BuyItemsEvent(Event container) {
		super(container);
	}

	@Override
	public void cycle() {
		if(grandExchange != null){
			if(grandExchange.isOpen()){
				System.out.println("open");
			} else {
				if(grandExchange.open()){
					System.out.println("opening");
					do{
						Task.sleep(500);
						System.out.println("sleeping");
					} while(!grandExchange.isOpen());
				}
			}
		} else {
			
			grandExchange = ((PrototypeAlcher) getScript()).getGrandExchange();
		}

	}

	@Override
	public boolean accept() {
		return true;
	}

}
