package frameWork.paint;

import java.awt.Graphics;

public abstract class AbstractPaint {
	protected abstract void drawPaint(Graphics g);
	protected abstract boolean condition();
	
	public void paint(Graphics g) {
			drawPaint(g);
	}
	
}
