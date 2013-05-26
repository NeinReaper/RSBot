package source.userInterface.paints;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import org.powerbot.game.api.util.Random;

import source.resources.ScriptAttributes;

import frameWork.paint.AbstractPaint;

public class CharacterViewingPaint extends AbstractPaint{

	@Override
	protected void drawPaint(Graphics g3) {
		Graphics g1 = g3;
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		if(ScriptAttributes.highLightEntities) {
			Polygon[] bounds = ScriptAttributes.eToDraw.getBounds();
			int it = 0;
			boolean condition = true;
			if(it > bounds.length/2){
				condition = ScriptAttributes.eToDraw.isIdle();
			}
			for(int i = 0; i < bounds.length&&!condition; i++){
				g.draw(bounds[i]);
				g.setColor(new Color(0,0,Random.nextInt(0, 255)));
				it = i;
			}
		}
		g.setColor(Color.WHITE);
		if(ScriptAttributes.displayNames){
			int x = ScriptAttributes.eToDraw.getCentralPoint().x;
			int y = ScriptAttributes.eToDraw.getCentralPoint().y-60;
			g.drawRect(x, y,100,30);
			g.drawString(ScriptAttributes.eToDraw.getName(), x, y);
			g.setColor(Color.BLUE);
			y+=11;
			g.drawString("HP: "+ ScriptAttributes.eToDraw.getHealthPercent(), x, y);
		}

	}

	@Override
	protected boolean condition() {
		return (ScriptAttributes.viewEntities && ScriptAttributes.eToDraw != null);
	}


}
