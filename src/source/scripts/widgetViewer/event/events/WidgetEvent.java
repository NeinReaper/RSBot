package source.scripts.widgetViewer.event.events;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
import source.scriptFramework.execution.event.Event;
public class WidgetEvent extends Event {
	private WidgetChild widgetToDraw;
	private int processes = 0;
	public WidgetEvent(Event container) {
		super(container);
	}
	
	@Override
	public boolean accept() {//i realize this is an empty condition
		return true;
	}

	@Override
	public void cycle() {
		processes++;
		WidgetChild smallestChild = null;
		for(Widget widget : Widgets.getLoaded()){
			if(widget != null){
				if(widget.getChildrenCount() > 0){
					for(WidgetChild child : widget.getChildren()){
						processes++;
						if(child != null){
							if(child.getChildStackSize() > 0){
								for(WidgetChild cchild : child.getChildren()){
									processes++;
									if(toDisplay(cchild)){
										if(smallestChild != null){
											if(smallerThan(cchild, smallestChild)){
												smallestChild = cchild;
											}
										} else {
											smallestChild = cchild;
										}
										
									}
								}
							}
							if(toDisplay(child)){
								if(smallestChild != null){
									if(smallerThan(child, smallestChild)){
										smallestChild = child;
									}
								} else {
									smallestChild = child;
								}
							}
						}
					}
				}
			}
		}
		widgetToDraw = smallestChild;
	}
	
	public boolean smallerThan(WidgetChild child1, WidgetChild child2){
		return((child1.getHeight() * child1.getWidth()) < (child2.getHeight() * child2.getWidth()));
			
		
	}
	
	private boolean toDisplay(WidgetChild child){
		return child != null && child.contains(Mouse.getLocation());
	}
	
	public int getProcesses(){
		return processes;
	}

	
	public WidgetChild widgetToDraw(){
		return widgetToDraw;
	}
}
