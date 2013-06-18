package source.util;
import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
public enum LodeStone {
	BANDIT_CAMP(7), AL_KHARID(40), ARDOUGNE(41), BURTHORPE(42), CATHERBY(43), DRAYNOR_VILLAGE(44),
	EDGEVILLE(45), FALADOR(46), LUMBRIDGE(47), PORT_SARIM(48), SEERS(49), TAVERLY(50), VARROCK(51), YANILLE(52);
	
	private static final Widget LOAD_STONE_WIDGET = Widgets.get(1092);
	private static final WidgetChild MAGE_CHILD = Widgets.get(275,40),
			TELEPORT_CHILD = Widgets.get(275, 47),
			HOME_TELEPORT_CHILD = Widgets.get(275,16).getChild(155),
			LOAD_STONE_INTERFACE = LOAD_STONE_WIDGET.getChild(0);
	
	private static Tile oldTile;
	private int value;
	
	LodeStone(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public boolean teleport(){
		oldTile = Players.getLocal().getLocation();
		if(!LOAD_STONE_INTERFACE.visible()){
			if(Tabs.ABILITY_BOOK.isOpen()){
				if(!TELEPORT_CHILD.visible()){
					if(MAGE_CHILD.click(true)){
						do{ 
							Task.sleep(500);
						}while(!TELEPORT_CHILD.visible());
					}
				} else {
					if(!HOME_TELEPORT_CHILD.visible()){
						if(TELEPORT_CHILD.click(true)){
							do{ 
								Task.sleep(500);
							}while(!HOME_TELEPORT_CHILD.visible());
						}
					} else {
						if(!LOAD_STONE_INTERFACE.visible()){
							if(HOME_TELEPORT_CHILD.click(true)){
								do{ 
									Task.sleep(500);
								}while(!LOAD_STONE_INTERFACE.visible());
							}
						} 
					}
				}
			} else {
				if(Tabs.ABILITY_BOOK.open()){
					do{ 
						Task.sleep(500);
					}while(!Tabs.ABILITY_BOOK.isOpen());
				}
			}
		} else {
			if(LOAD_STONE_WIDGET.getChild(getValue()).click(true)){
				do{ 
					Task.sleep(500);
				}while(Calculations.distanceTo(oldTile) < 5);
			}
		}
		return Calculations.distanceTo(oldTile) > 5;//to be changed to loadstone.isOnScreen || new Location.contains(player)

	}
}
