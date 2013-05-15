package source.userInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.concurrent.TimeUnit;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;

import frameWork.paint.AbstractPaint;
import source.Attributes;

public class Paint extends AbstractPaint{
	public static int xpGained, fishFished,profit,startXp,fishXp = 0, fishPrice = 0;
	public static long startTime;
	public static String status = "";
	public static Image hideButton, unHideButton;

	public void drawPaint(Graphics arg0) {
		Graphics2D g = (Graphics2D) arg0;
		g.setRenderingHints( new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
		if(!Attributes.showGui) {
			xpGained = Skills.getExperience(Skills.FISHING)-startXp;
			fishFished = (int) (xpGained/fishXp);
			profit = fishFished*fishPrice;
			if(Attributes.showPaint) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(7, 346, 380, 113);
				g.setColor(new Color(0, 204, 204));
				g.fillRect(11, 352, 371, 102);
				g.setColor(new Color(0, 0, 204));
				g.setFont(new Font("Arial", 0, 18));
				g.drawString("ProsGuildRusher", 15, 366);
				g.setColor(new Color(255, 255, 255));
				g.setFont(new Font("Arial", 0, 12));
				long currentTimeMilli = System.currentTimeMillis()-Paint.startTime;
				long milliToSecs = TimeUnit.MILLISECONDS.toMinutes(currentTimeMilli);
				if(fishFished < 1) {
					g.drawString("Profit: wait for a few fish", 15, 379);
					g.drawString("Profit/hr: Processing", 15, 392);
					g.drawString("Fish/hr:  Processing", 15, 419);
					g.drawString("XP Gained: Processing", 15, 432);
					g.drawString("XP/HR: Processing", 15, 446);
					g.drawString("Time to Level("+(Skills.getLevel(Skills.FISHING)+1)+"): "+ "Processing", 215, 388);
				} else {
					g.drawString("Profit: "+profit, 15, 379);
					g.drawString("Profit/hr: "+(int)Math.round(profit/((double)milliToSecs/60)), 15, 392);
					g.drawString("Fish/hr:  "+(int)Math.round(fishFished/((double)milliToSecs/60)), 15, 419);
					g.drawString("XP Gained: "+xpGained, 15, 432);
					g.drawString("XP/HR: "+(int)Math.round(xpGained/((double)milliToSecs/60)), 15, 446);
					g.drawString("Time to Level("+(Skills.getLevel(Skills.FISHING)+1)+"): "+Time.format((long) (((double) Skills.getExperienceToLevel(Skills.FISHING, Skills.getRealLevel(Skills.FISHING)+1) * 3600000.0) / (double)(3600000d / (double) (System.currentTimeMillis()-startTime) * (double) (Skills.getExperience(Skills.FISHING) - startXp)))), 215, 388);

				}
				g.drawString("Fish: "+fishFished, 15, 405);
				g.drawString("Time Running: "+Time.format(currentTimeMilli), 215, 376);
				g.drawString("Status: "+status, 215, 413);
				g.drawString("XP to level("+(Skills.getLevel(Skills.FISHING)+1)+"): "+(Skills.getExperienceToLevel(Skills.FISHING, Skills.getRealLevel(Skills.FISHING)+1)), 215, 425);
				g.drawString("Percent Until Level("+(Skills.getLevel(Skills.FISHING)+1)+"): "+(int)((double)Skills.getExperienceToLevel(Skills.FISHING , Skills.getRealLevel(Skills.FISHING)+1) / Skills.getExperience(Skills.FISHING) * 1000), 215, 439);
			}
			if(hideButton != null && unHideButton != null) {
				g.drawImage(Attributes.showPaint ?  hideButton : unHideButton, 7, 459, null);

			}
		}
	}
}
