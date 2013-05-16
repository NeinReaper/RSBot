import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import org.powerbot.game.api.Manifest;
import frameWork.AbstractScript;
import frameWork.event.Event;
import source.event.*;
import source.event.events.PlayerViewingEvent;
import source.event.events.TileViewingEvent;
import source.resources.ScriptAttributes;
import source.userInterface.GUI;
import source.userInterface.ScriptPaint;
@Manifest(authors = { "Protog/Jordan" }, 
description = "Customizeable Hud", 
name = "ProsHud", 
version = 1.0)
public class ProsHud extends AbstractScript{
	@Override
	public void begin() {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new GUI().frame.setVisible(true);
			}
			
		});
		container.submit(new TileViewingParent(new Event[]{new TileViewingEvent()}),
				new PlayerViewingParent(new Event[]{new PlayerViewingEvent()}));
		paintContainer.add(new ScriptPaint());
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(ScriptAttributes.viewClickedTile)
			ScriptAttributes.clickedTile = ScriptAttributes.mouseTile;
		
	}


	

	
}
