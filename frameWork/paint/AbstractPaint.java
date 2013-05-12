package frameWork.paint;

import java.awt.Graphics;

public abstract class AbstractPaint {
	private boolean showPaint = false;
	protected abstract void drawPaint(Graphics g);
	
	public void paint(Graphics g) {
		if(showPaint) {
			drawPaint(g);
		}	
	}
	
	public void showPaint() {
		showPaint = true;
	}
}
