package source.scripts.widgetViewer;
import java.awt.Color;
import java.awt.Graphics;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
import source.scriptFramework.execution.event.ControlEvent;
import source.scriptFramework.execution.event.Event;
import source.scriptFramework.execution.event.PrimaryEvent;
import source.scripts.widgetViewer.event.WidgetViewingArm;
import source.scripts.widgetViewer.event.events.WidgetEvent;
@Manifest(authors = { "Protog" },
description = "Widget Viewer", 
name = "Widget Viewer")
public class WidgetViewer extends ActiveScript implements PaintListener{
	private boolean hasStarted = false;
	private Event controller, widgetViewingArm, widgetEvent;
	private Event[] widgetViewingEvents;

	private void startUp(){
		controller = new ControlEvent(controller, this){
			@Override
			public boolean accept() {
				return Game.isLoggedIn();
			}
		};
		widgetEvent = new WidgetEvent(widgetViewingArm);
		widgetViewingEvents = new Event[]{ widgetEvent};
		widgetViewingArm = new WidgetViewingArm(controller, widgetViewingEvents);
		
		((PrimaryEvent) controller).submit(widgetViewingArm);
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
	@Override
	public void onRepaint(Graphics g) {
		if(!(g.getColor().equals(Color.RED))){
			g.setColor(Color.RED);
		}
			
		WidgetChild childToDraw = getWidgetViewingEvent().widgetToDraw();
		if(childToDraw !=  null){
			childToDraw.draw(g);
			g.drawString("WidgetChild Id: "+ childToDraw.getIndex(), 5, 320);
			if(childToDraw.getParent() != null){
				g.drawString("WidgetChildParent Id: " + childToDraw.getParent().getIndex(), 5, 340);
			} else {
				g.drawString("WidgetChildParent Id: null", 5, 340);
			}
			g.drawString("WidgetChild Text: " + childToDraw.getText(), 5, 360);
		} 
		g.drawString("Processes: "+getWidgetViewingEvent().getProcesses(), 5, 300);
		
	}
	
	public WidgetEvent getWidgetViewingEvent(){
		return ((WidgetEvent)widgetEvent);
	}
}
