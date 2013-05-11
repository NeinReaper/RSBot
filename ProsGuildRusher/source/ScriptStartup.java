package source;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import org.powerbot.core.script.job.state.Branch;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.tab.Skills;
import employment.*;
import employment.jobManagement.NodeEmployment;
import source.resources.Attributes;
import source.userInterface.Frame;
import source.userInterface.Paint;
import source.branches.*;
import source.nodes.*;

public class ScriptStartup {

	public static void startScript(final NodeEmployment employer) {
		Paint.xpGained = 0;
		Paint.fishFished = 0;
		Paint.profit = 0;
		Branch bankBranch = new BankingBranch(new Node[]{new OpenBank(), new DepositFish(), new CloseBank()}),
				fishBranch = new FishingBranch(new Node[]{new SpotFish(), new InteractWithFish()}),
				walkBranch = new WalkingBranch(new Node[]{new WalkThere(), new WalkBack()});
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
						new Frame(employer).frame.setVisible(Attributes.showGui);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		employer.load(bankBranch,fishBranch,walkBranch);
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
