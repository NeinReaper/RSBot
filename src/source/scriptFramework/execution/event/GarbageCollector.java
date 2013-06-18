package source.scriptFramework.execution.event;
import java.util.ArrayList;
import org.powerbot.game.api.util.Timer;
public class GarbageCollector extends Event {
	private ArrayList<Event> garbage = new ArrayList<Event>();
	private Timer timeOut;
	private int count = 0, timeOutTime;
	public GarbageCollector(Event container){
		super(container);
		setTimeOutTime(3600000);//1 hour default
		resetTimer();
		
	}

	@Override
	public void cycle() {
		collectGarbage();
		System.out.println("Garbage Collected: "+count);
		count++;
		resetTimer();
	}
	
	public void addToGarbage(Event...events){
		
	}
	
	public void addAll(){

	}
	
	public void collectAll(){
		addAll();
		collectGarbage();
	}
	
	public void collectGarbage(){

	}
	
	public void setTimeOutTime(int time){
		timeOutTime = time;
	}
	
	public void resetTimer(){
		timeOut = new Timer(timeOutTime);
	}

	
	@Override
	public boolean accept() {
		return !timeOut.isRunning();
	}

}
