package frameWork.paint;
import java.awt.Graphics;
import java.util.ArrayList;
public class PaintContainer extends ArrayList<AbstractPaint>{
	public void employ(Graphics g){
		for(AbstractPaint paint : this){
			if(paint != null){
				if(paint.condition()){
					paint.paint(g);
				}
			}	
		}
	}
	
	public void submit(AbstractPaint...paints){
		for(AbstractPaint paint : paints){
			if(paint!=null){
				add(paint);
			}
		}
	}
	
	public void revoke(AbstractPaint...paints){
		for(AbstractPaint paint : paints){
			if(contains(paint)){
				remove(paint);
			}
		}
	}
}
