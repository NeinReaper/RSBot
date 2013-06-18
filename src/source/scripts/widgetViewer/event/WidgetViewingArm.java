package source.scripts.widgetViewer.event;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
import source.scriptFramework.execution.event.Event;
import source.scriptFramework.execution.event.SecondaryEvent;
import source.scripts.widgetViewer.WidgetViewer;
public class WidgetViewingArm extends SecondaryEvent{
	public WidgetViewingArm(Event container, Event[] arm) {
		super(container, arm);
	}

	@Override
	public boolean accept() {
		WidgetChild child;
		return (((child = ((WidgetViewer) getScript()).getWidgetViewingEvent().widgetToDraw()) != null) ? !(child.contains(Mouse.getLocation())) : true);
	}
	
}
