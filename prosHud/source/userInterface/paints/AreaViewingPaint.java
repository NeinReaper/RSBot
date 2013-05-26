package source.userInterface.paints;

import java.awt.Color;
import java.awt.Graphics;

import org.powerbot.game.api.wrappers.Tile;

import source.resources.ScriptAttributes;

import frameWork.paint.AbstractPaint;

public class AreaViewingPaint extends AbstractPaint {

	@Override
	protected void drawPaint(Graphics g) {
		g.setColor(Color.GREEN);
		for(Tile t : ScriptAttributes.areaToDraw.getTileArray()){
			t.draw(g);
		}

	}

	@Override
	protected boolean condition() {
		return (ScriptAttributes.viewArea && ScriptAttributes.areaToDraw != null);
	}

}
