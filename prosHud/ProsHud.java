import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import org.powerbot.game.api.Manifest;

import dynamicPaints.MousePaint;
import frameWork.AbstractScript;
import frameWork.event.Event;
import source.event.*;
import source.event.events.*;
import source.resources.ScriptAttributes;
import source.userInterface.HudFrame;
import source.userInterface.paints.*;
@Manifest(authors = { "Protog" }, 
description = "Makes Legit Playing Easy", 
name = "ProsDynamicHud", 
version = 1.0)
public class ProsHud extends AbstractScript{
	private HudFrame frame;
	@Override
	public void begin() {
		frame = new HudFrame();
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				frame.frame.setVisible(true);
			}
			
		});
		container.submit(new TileViewingParent(new Event[]{new TileViewingEvent(), new AreaViewingEvent()}),
							new CharacterViewingParent(new Event[]{new CharacterViewingEvent()}));
		
		paintContainer.submit(new TileViewingPaint(), new CharacterViewingPaint(),
								new AreaViewingPaint(), new MousePaint());
		
	}

	@Override
	public void end() {
		frame.frame.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(ScriptAttributes.viewClickedTile)
			ScriptAttributes.clickedTile = ScriptAttributes.mouseTile;
		
	}
}
