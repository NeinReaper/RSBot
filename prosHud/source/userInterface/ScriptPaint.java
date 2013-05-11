package source.userInterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import source.resources.ScriptAttributes;

public class ScriptPaint {

	public static void displayPaint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		if(ScriptAttributes.viewMouseTile && ScriptAttributes.mouseTile != null) {
			g.drawString("MouseTileLocation: "+ScriptAttributes.mouseTile.toString(), 0, 375);
			ScriptAttributes.mouseTile.draw(g1);
			if(ScriptAttributes.viewClickedTile && ScriptAttributes.clickedTile != null) {
				g.drawString("ClickedTileLocation: "+ScriptAttributes.clickedTile.toString(), 0, 350);
				if(ScriptAttributes.viewDistFromClickedTile)
					g.drawString("Distance: " +ScriptAttributes.clickedTile.distance(ScriptAttributes.mouseTile), 0, 325);
				
				ScriptAttributes.clickedTile.draw(g1);
			}
			if(ScriptAttributes.viewDistFromMouseTile && ScriptAttributes.myPlayer != null) {
				g.drawString("Distance From Player: " +ScriptAttributes.myPlayer.getLocation().distance(ScriptAttributes.mouseTile), 0, 300);
			}
		}
		if(ScriptAttributes.viewPlayers) {
			if(ScriptAttributes.playerToDraw != null)
				ScriptAttributes.playerToDraw.draw(g);
		}
	}

}
