package frameWork.paint;

import java.awt.Graphics;
import java.util.ArrayList;

public class PaintContainer extends ArrayList<AbstractPaint>{
	public void employ(Graphics g){
		for(AbstractPaint paint : this) {
			if(paint != null) {
				paint.drawPaint(g);
			}
		}
	}
}
