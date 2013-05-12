import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import managers.TileViewingManager;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.wrappers.Tile;

import employees.TileViewingEmployee;
import frameWork.AbstractScript;
import frameWork.staff.Staff;
import source.resources.ScriptAttributes;
import source.userInterface.GUI;
import source.userInterface.ScriptPaint;
@Manifest(authors = { "Protog/Jordan" }, 
description = "Customizeable Hud", 
name = "ProsHud", 
version = 1.0)
public class ProsHud extends AbstractScript implements MouseListener{
	private TileViewingEmployee tvEmployee;
	@Override
	public void begin() {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new GUI().frame.setVisible(true);
			}
			
		});
		tvEmployee = new TileViewingEmployee();
		container.submit(new TileViewingManager(new Staff[]{tvEmployee}));
		paintContainer.add(new ScriptPaint());
		
		container.submit(new Staff(){

			@Override
			public boolean activate() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(ScriptAttributes.viewClickedTile)
			ScriptAttributes.clickedTile = ScriptAttributes.mouseTile;
	}
	

	
}
