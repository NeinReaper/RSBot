import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.tab.Skills;
import source.Attributes;
import source.staff.*;
import source.staff.employees.*;
import source.userInterface.*;
import frameWork.AbstractScript;
import frameWork.staff.Manager;
import frameWork.staff.Staff;

@Manifest(authors = { "Protog/Jordan" }, 
description = "Fishes at the fishing guild", 
name = "ProsGuildRusher", 
version = 1.0)
public class PGRusher extends AbstractScript {
	@Override
	public void begin() {
		Paint.xpGained = 0;
		Paint.fishFished = 0;
		Paint.profit = 0;
		Manager fishManager = new FishingManager(new Staff[]{new SpotFishEmp(), new InteractWithFishEmp()}),
				walkManager = new WalkingAndBankingManager(new Staff[]{new WalkingEmp(), new BankFishEmp()});
		try {
			Paint.hideButton = loadImage("http://t2.gstatic.com/images?q=tbn:ANd9GcRHmkRpJu3sk-JUEAGkJ2Gp3R5OrZpwspFP_GA2S3cCKZjP_jS7");
			Paint.unHideButton = loadImage("http://t1.gstatic.com/images?q=tbn:ANd9GcRHr0Wz9h1erBX1DvuL_Kkclwt6090A2nqUmmjmurcs6M6Y1MBQ");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Paint.status = "Error with loading button";
		}

		if(Game.isLoggedIn()) {
			Paint.startXp = Skills.getExperience(Skills.FISHING);
			Paint.startTime = System.currentTimeMillis();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						new Frame(container).frame.setVisible(Attributes.showGui);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		container.submit(new DropFishEmp(),fishManager, walkManager);
		paintContainer.add(new Paint());

	}

	@Override
	public void end() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 5 && e.getX() < 20 && e.getY()>455
				&& e.getY() < 475) {
			Attributes.showPaint = !Attributes.showPaint;
		}
	}
	
	private static HashMap<String, Image> images = new HashMap<String, Image>();

	private static Image loadImage(String url) throws MalformedURLException {
		if (images.containsKey(url)) {
			return images.get(url);
		} else {
			BufferedImage image;
			try {
				image = ImageIO.read(new URL(url));
				if (image != null) {
					images.put(url, image);

					return image;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
