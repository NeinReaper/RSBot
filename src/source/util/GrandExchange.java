package source.util;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.Widget;

public class GrandExchange {


	public final int[] EXCHANGER_IDS = new int[]{1419,2593};
	public final int GE_WIDGET_ID = 105, GE_CHILD_ID = 1;
	public Widget geWidget;
	private NPC currentExchanger;
	private Exchanger exchanger;

	public GrandExchange(){
		geWidget = Widgets.get(GE_WIDGET_ID);
		currentExchanger = getNearestGeNpc();
		exchanger = new Exchanger();
	}
	
	public Exchanger getExchanger(){
		return exchanger;
	}

	public NPC getNearestGeNpc(){
		return NPCs.getNearest(EXCHANGER_IDS);
	}

	public NPC getCurrentGeNpc(){
		return ((currentExchanger != null) ? currentExchanger : (currentExchanger = getNearestGeNpc()));
	}

	public boolean isOnScreen(){
		NPC exchanger = getCurrentGeNpc();
		return exchanger != null && exchanger.isOnScreen() ;
	}

	public boolean isOpen(){
		return geWidget.getChild(GE_CHILD_ID).isOnScreen();
	}

	public boolean open(){
		NPC exchanger = getCurrentGeNpc();
		if(exchanger != null){
			if(exchanger.isOnScreen()){
				return exchanger.interact("Exchange");
			} else {
				Camera.turnTo(exchanger);
			}
		} 
		return isOpen();
	}

}
