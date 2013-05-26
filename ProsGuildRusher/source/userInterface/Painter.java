package source.userInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;
import frameWork.paint.AbstractPaint;
import source.Attributes;
public class Painter extends AbstractPaint{
	public static int xpGained = 0, fishFished = 0,profit = 0,startXp,fishXp = 0, fishPrice = 0;
	public static long startTime;
	public static String status = "";
	public final Image hideButton = getImage("http://t2.gstatic.com/images?q=tbn:ANd9GcRHmkRpJu3sk-JUEAGkJ2Gp3R5OrZpwspFP_GA2S3cCKZjP_jS7"), 
			unHideButton = getImage("http://t1.gstatic.com/images?q=tbn:ANd9GcRHr0Wz9h1erBX1DvuL_Kkclwt6090A2nqUmmjmurcs6M6Y1MBQ"),
			paintImage = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/paint_zps80e2978f.png");

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch(IOException e) {
			return null;
		}
	}
	
	public void drawPaint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		xpGained = Skills.getExperience(Skills.FISHING)-startXp;
		fishFished = (int) (xpGained/fishXp);
		profit = fishFished*fishPrice;
		if(Attributes.showPaint){	
			long currentTimeMilli = System.currentTimeMillis()-Painter.startTime;
			long milliToSecs = TimeUnit.MILLISECONDS.toMinutes(currentTimeMilli);
			g.drawImage(paintImage, 2, 250, null);
			g.setColor(Color.CYAN);
			g.setFont(new Font("Arial", 0, 13));
			g.drawString(Time.format(currentTimeMilli), 100,362);//time
			g.drawString("" + profit, 55, 382);//profit
			g.drawString("" + fishFished, 240, 362);
			g.drawString("" + xpGained, 431, 362);
			g.drawString(status, 15, 420);
			
			g.drawString("("+ (Skills.getLevel(Skills.FISHING)+1) + "): " //xp to level
					+ (Skills.getExperienceToLevel(Skills.FISHING, Skills.getRealLevel(Skills.FISHING)+1)), 432, 402);

			if(fishFished > 0) {
				g.drawString("" + (int)Math.round(profit/((double)milliToSecs/60)), 75, 402);//profit/hr

				g.drawString("" + (int)Math.round(fishFished/((double)milliToSecs/60)), 260, 382);//fish/hr

				g.drawString(Time.format((long) (((double) Skills.getExperienceToLevel(Skills.FISHING, 
								Skills.getRealLevel(Skills.FISHING)+1) * 3600000.0) 
								/ (double)(3600000d / (double) (System.currentTimeMillis()-startTime)
										* (double) (Skills.getExperience(Skills.FISHING) - startXp)))), 285, 402);//time to level
				
				g.drawString("" + (int)Math.round(xpGained/((double)milliToSecs/60)), 412, 382);//xp/hr
			} else {
				g.drawString("waiting", 75, 402);

				g.drawString("waiting", 260, 382);

				g.drawString("waiting", 285, 402);
				

				g.drawString("waiting", 412, 382);
			}
		}
		if(hideButton != null && unHideButton != null) {
			g.drawImage(Attributes.showPaint ?  hideButton : unHideButton, 7, 459, null);

		}
	}

	@Override
	protected boolean condition() {
		return !Attributes.showGui;
	}
}
