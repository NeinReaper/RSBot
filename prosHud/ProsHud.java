import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Tile;

import employment.task.Employer;
import employment.task.Manager;
import employment.task.Staff;
import source.employees.PlayerViewingEmployee;
import source.employees.TileViewingEmployee;
import source.managers.PlayerViewingManager;
import source.managers.TileViewingManager;
import source.resources.ScriptAttributes;
import source.userInterface.*;

@Manifest(authors = { "Protog/Jordan" }, 
description = "Customizeable Hud", 
name = "ProsHudBeta", 
version = 1.0)
public class ProsHud extends ActiveScript implements PaintListener, MouseListener{
	
	private Employer employer;
	@Override
	public void onStart() {
		employer = new Employer();
		if(Game.isLoggedIn()) {
			ScriptAttributes.myPlayer = Players.getLocal();
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					new GUI().frame.setVisible(ScriptAttributes.showGui);
				}
			});		
		}
		Manager tileManager = new TileViewingManager(new Staff[]{new TileViewingEmployee()}),
				playerManager = new PlayerViewingManager(new Staff[]{new PlayerViewingEmployee()});
		employer.submit(tileManager,playerManager);
	}
	@Override 
	public void onStop() {
		employer.shutdown();
	}
	
	@Override
	public int loop() {
		return Random.nextInt(50, 100);
	}
	
	@Override
	public void onRepaint(Graphics g) {
		if(ScriptAttributes.showPaint)
			ScriptPaint.displayPaint(g);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(ScriptAttributes.viewClickedTile)
			ScriptAttributes.clickedTile = ScriptAttributes.mouseTile;
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }


}
