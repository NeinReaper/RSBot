import java.awt.Graphics;
import java.awt.event.MouseEvent;
import frameWork.AbstractScript;
import frameWork.event.Event;
import frameWork.paint.AbstractPaint;

public class TestScript extends AbstractScript{

	@Override
	public void begin() {

		container.submit(new Event(){//exactly like a powerbot node
			@Override
			public void execute(){
				super.execute();
			}
			@Override
			public boolean condition() {
				return false;
			}
			
		});
		
		paintContainer.add(new AbstractPaint(){
			@Override
			protected void drawPaint(Graphics g) {
				
			}
			
		});
	}

	@Override
	public void end() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
}
