import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;

import employment.jobManagement.NodeEmployment;
import source.ScriptStartup;
import source.resources.Attributes;
import source.userInterface.Paint;

@Manifest(authors = { "Protog/Jordan" }, 
description = "Fishes at the fishing guild", 
name = "ProsGuildRusher", 
version = 1.0)
public class ProsGuildRusher extends ActiveScript implements PaintListener, MouseListener{
	private NodeEmployment employer;
	@Override
	public void onStart() {
		employer = new NodeEmployment();
		ScriptStartup.startScript(employer);
	}
	@Override
	public void onRepaint(Graphics arg0) {
		if(Attributes.showPaint)
			Paint.displayPaint(arg0);
	}

	@Override
	public int loop() {
		try {
			if(employer != null)
				employer.fire(this);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Random.nextInt(50, 100);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 5 && e.getX() < 20 && e.getY()>455
				&& e.getY() < 475) {
			Attributes.showPaint = !Attributes.showPaint;
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {	}
	@Override
	public void mouseExited(MouseEvent arg0) {	}
	@Override
	public void mousePressed(MouseEvent arg0) {	}
	@Override
	public void mouseReleased(MouseEvent arg0){	}

}
