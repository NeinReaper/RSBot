import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.tab.Skills;
import dynamicPaints.MousePaint;
import source.Attributes;
import source.event.*;
import source.event.events.*;
import source.userInterface.*;
import frameWork.AbstractScript;
import frameWork.event.Event;
import frameWork.event.ParentEvent;
@Manifest(authors = { "Protog" }, 
description = "Excellent Fishing Guild Fisher", 
name = "ProsFishRusherlocal", 
version = 1.0)
public class PGRusher extends AbstractScript {
	@Override
	public void begin() {
		ParentEvent fishParent = new FishingParent(new Event[]{new SpotFishEvent(), new FishEvent()}),
				walkParent = new WalkingParent(new Event[]{new WalkingEvent(), new BankEvent()}),
				bankParent = new BankingParent(new Event[]{new BankEvent()});

		if(Game.isLoggedIn()) {
			Painter.startXp = Skills.getExperience(Skills.FISHING);
			Painter.startTime = System.currentTimeMillis();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						new Frame(container).frame.setVisible(Attributes.showGui);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		container.submit(new DropFishEvent(),fishParent,walkParent,bankParent);
		paintContainer.submit(new Painter(), new MousePaint());

	}

	@Override
	public void end() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 5 && e.getX() < 20 && e.getY()>455
				&& e.getY() < 475) {
			Attributes.showPaint = !Attributes.showPaint;
		}
	}
}
