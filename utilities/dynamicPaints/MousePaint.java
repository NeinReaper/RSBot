package dynamicPaints;

import java.awt.Graphics;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;

import frameWork.paint.AbstractPaint;

public class MousePaint extends AbstractPaint {

	@Override
	protected void drawPaint(Graphics g) {
		//horizontal line
		int hx1 = 0, hx2 = Mouse.getX()-10, hy1 = Mouse.getY(), hy2 = hy1;
		g.drawLine(hx1,hy1,hx2,hy2);

		hx1 = Mouse.getX()+10;
		hx2 = (int)Game.getDimensions().getWidth();
		g.drawLine(hx1,hy1,hx2,hy2);

		//vertical line
		int vx1 = Mouse.getX(), vx2 = vx1, vy1 = 0, vy2 = Mouse.getY()-10;
		g.drawLine(vx1,vy1,vx2,vy2);

		vy1 = Mouse.getY()+10;
		vy2 = (int)(Game.getDimensions().getHeight());
		g.drawLine(vx1, vy1, vx2, vy2);

		g.drawRect(Mouse.getX()-10, Mouse.getY()-10, 20, 20);

	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return true;
	}
}
