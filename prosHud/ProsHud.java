import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import managers.PlayerViewingManager;
import managers.TileViewingManager;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.wrappers.Tile;

import employees.PlayerViewingEmployee;
import employees.TileViewingEmployee;
import frameWork.AbstractScript;
import frameWork.event.Event;
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
		container.submit(new TileViewingManager(new Event[]{new TileViewingEmployee()}), 
													new PlayerViewingManager(new Event[]{new PlayerViewingEmployee()}));
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
