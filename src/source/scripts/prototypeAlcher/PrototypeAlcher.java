package source.scripts.prototypeAlcher;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.util.Random;
import source.scriptFramework.execution.event.ControlEvent;
import source.scriptFramework.execution.event.Event;
import source.scriptFramework.execution.event.PrimaryEvent;
import source.scripts.prototypeAlcher.event.*;
import source.scripts.prototypeAlcher.event.events.*;
import source.util.GrandExchange;
@Manifest(authors = { "Protog" },
			description = "Revolutionary Alching", 
			name = "Prototype Alcher")
public class PrototypeAlcher extends ActiveScript {
	private boolean hasStarted = false;
	private Event controller, exchangeArm, buyItemsEvent;
	private Event[] exchangeArmEvents;
	
	private GrandExchange grandExchange;
	
	private void startUp(){
		controller = new ControlEvent(controller, this){
			@Override
			public boolean accept() {
				return Game.isLoggedIn();
			}
		};
		buyItemsEvent = new BuyItemsEvent(controller);
		exchangeArmEvents = new Event[]{ buyItemsEvent };
		exchangeArm = new ExchangeArm(controller, exchangeArmEvents);
		grandExchange = new GrandExchange();
		
		((PrimaryEvent) controller).submit(exchangeArm);
		hasStarted = true;
	}
	
	@Override
	public int loop() {
		if(hasStarted){
			if(controller.accept()){
				controller.execute();
			}
		} else {
			startUp();
		}
		return Random.nextInt(550, 650);
	}
	
	public GrandExchange getGrandExchange(){
		return grandExchange;
	}

}
