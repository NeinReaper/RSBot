package frameWork;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.util.Random;

import frameWork.paint.PaintContainer;


public abstract class AbstractScript extends ActiveScript implements PaintListener, MouseListener{
	protected volatile StaffContainer container = new StaffContainer();
	protected PaintContainer paintContainer = new PaintContainer();
	
	@Override
	public void onStart(){
		begin();
	}
	
	@Override
	public void onStop(){
		end();
		container.collectGarbage();
	}
	
	@Override
	public int loop() {
		container.employ();
		return Random.nextInt(50, 100);
	}
	
	@Override
	public void onRepaint(Graphics arg0) {
		paintContainer.employ(arg0);
	}
	
	public abstract void begin();
	public abstract void end();

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }
}