package source.userInterface;
import java.awt.BasicStroke;
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

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.client.input.Canvas;

import frameWork.paint.AbstractPaint;
import source.Attributes;

public class Paint extends AbstractPaint{
	public static int xpGained, fishFished,profit,startXp,fishXp = 0, fishPrice = 0;
	public static long startTime;
	public static String status = "";
	public final Image hideButton = getImage("http://t2.gstatic.com/images?q=tbn:ANd9GcRHmkRpJu3sk-JUEAGkJ2Gp3R5OrZpwspFP_GA2S3cCKZjP_jS7"), 
								unHideButton = getImage("http://t1.gstatic.com/images?q=tbn:ANd9GcRHr0Wz9h1erBX1DvuL_Kkclwt6090A2nqUmmjmurcs6M6Y1MBQ"), 
								fishCape = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/cape_zps60f0f2c6.jpg");
	
	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch(IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(51, 255, 255);
	private final Color color2 = new Color(0, 0, 0);
	private final Color color3 = Color.RED;
	private final Color color4 = Color.WHITE;

	private final BasicStroke stroke1 = new BasicStroke(1);

	private final Font font1 = new Font("Arial", 0, 15);
	private final Font font2 = new Font("Arial", 0, 12);

	
	
	public void drawPaint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		drawMouse(g1);
		if(!Attributes.showGui){
			xpGained = Skills.getExperience(Skills.FISHING)-startXp;
			fishFished = (int) (xpGained/fishXp);
			profit = fishFished*fishPrice;
			if(Attributes.showPaint){
				long currentTimeMilli = System.currentTimeMillis()-Paint.startTime;
				long milliToSecs = TimeUnit.MILLISECONDS.toMinutes(currentTimeMilli);
				g.setColor(color1);
				g.fillRoundRect(3, 353, 317, 93, 16, 16);//243
				g.setColor(color2);
				g.setStroke(stroke1);
				g.drawRoundRect(3, 353, 317, 93, 16, 16);
				g.drawImage(fishCape, 282, 368, null);
				g.setFont(font1);
				g.setColor(color3);
				g.drawString("ProsGuildRusher: ", 12, 371);
				g.setColor(color4);

				if(fishFished < 1) {
					g.drawString("Profit: waiting", 10, 383);
					g.drawString("Profit/Hr: waiting", 10, 397);
					g.drawString("Fish/Hr: waiting", 10, 430);
					g.drawString("Fish: waiting", 10, 412);
					g.drawString("XP: waiting", 130, 382);
					g.drawString("XP/Hr: waiting", 130, 395);
					g.drawString("TimeToLevel: waiting", 130, 423);

				} else {
					g.drawString("Profit: " + profit, 10, 383);
					g.drawString("Profit/Hr: " + (int)Math.round(profit/((double)milliToSecs/60)), 10, 397);
					g.drawString("Fish/Hr: " + (int)Math.round(fishFished/((double)milliToSecs/60)), 10, 430);
					g.drawString("XP: " + xpGained, 130, 382);
					g.drawString("XP/Hr: " + (int)Math.round(xpGained/((double)milliToSecs/60)), 130, 395);
					g.drawString("TimeToLevel(" + (Skills.getLevel(Skills.FISHING)+1) + "): " 
							+ Time.format((long) (((double) Skills.getExperienceToLevel(Skills.FISHING, 
									Skills.getRealLevel(Skills.FISHING)+1) * 3600000.0) 
									/ (double)(3600000d / (double) (System.currentTimeMillis()-startTime)
											* (double) (Skills.getExperience(Skills.FISHING) - startXp)))), 130, 423);
				}
				g.drawString("Time: " + Time.format(currentTimeMilli), 130, 370);
				g.drawString("XPtoLvl(" + (Skills.getLevel(Skills.FISHING)+1) + "): " 
								+ (Skills.getExperienceToLevel(Skills.FISHING, 
										Skills.getRealLevel(Skills.FISHING)+1)), 130, 408);
				g.drawString("PercentToLevel(" + (Skills.getLevel(Skills.FISHING)+1) + "): " 
										+ (int)((double)Skills.getExperienceToLevel(Skills.FISHING ,
												Skills.getRealLevel(Skills.FISHING)+1)
												/ Skills.getExperience(Skills.FISHING) * 1000), 130, 438);
				g.drawString("Fish: " + fishFished, 10, 412);
				
				g.setFont(font2);
				g.setColor(color3);
				g.drawString(status, 230, 365);

			}
			if(hideButton != null && unHideButton != null) {
				g.drawImage(Attributes.showPaint ?  hideButton : unHideButton, 7, 459, null);

			}
		}
	}
	public void drawMouse(Graphics g){
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
}
