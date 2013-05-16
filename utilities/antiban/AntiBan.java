package antiban;
import org.powerbot.game.api.wrappers.Area;

import frameWork.event.Event;
import frameWork.event.ParentEvent;
import antiban.staff.AntiBanManager;
import antiban.staff.employees.*;
public class AntiBan {
	public static boolean useAntiBan, checkStats, checkPeople;
	public ParentEvent myManager;
	public AntiBan(boolean use, boolean stats, boolean people, Area checkPeopleArea) {
		useAntiBan = use;
		checkStats = stats;
		checkPeople = people;
		myManager = new AntiBanManager(new Event[]{new CheckStats(), new CheckPeople(checkPeopleArea)});
		
	}
}
