package source.userInterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.Player;

import frameWork.paint.AbstractPaint;

import source.resources.ScriptAttributes;

public class ScriptPaint extends AbstractPaint{

	public void drawPaint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		
		if(ScriptAttributes.viewMouseTile) {
			g.drawString("MouseTileLocation: "+ScriptAttributes.mouseTile, 0, 375);
			ScriptAttributes.mouseTile.draw(g1);
			if(ScriptAttributes.viewClickedTile) {
				g.drawString("ClickedTileLocation: "+ScriptAttributes.clickedTile, 0, 350);
				ScriptAttributes.clickedTile.draw(g1);
				if(ScriptAttributes.viewDistFromClickedTile) {
					g.drawString("Distance: " +ScriptAttributes.clickedTile.distance(ScriptAttributes.mouseTile), 0, 325);
				}	
			}
			Player p = Players.getLocal();
			if(p!= null){
				if(ScriptAttributes.viewDistFromMouseTile) {
					g.drawString("Distance From Player: " +p.getLocation().distance(ScriptAttributes.mouseTile), 0, 300);
				}
			}
		}
	}

}
