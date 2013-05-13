package antiban;
import org.powerbot.game.api.wrappers.Area;
import frameWork.staff.Manager;
import frameWork.staff.Staff;
import antiban.staff.AntiBanManager;
import antiban.staff.employees.*;
public class AntiBan {
	public static boolean useAntiBan, checkStats, checkPeople;
	public Manager myManager;
	public AntiBan(boolean use, boolean stats, boolean people, Area checkPeopleArea) {
		useAntiBan = use;
		checkStats = stats;
		checkPeople = people;
		myManager = new AntiBanManager(new Staff[]{new CheckStats(), new CheckPeople(checkPeopleArea)});
		
	}
}
