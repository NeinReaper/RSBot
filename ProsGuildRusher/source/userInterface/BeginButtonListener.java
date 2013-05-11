package source.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import employment.jobManagement.NodeEmployment;
import employment.task.Employer;


import antiban.AntiBan;

import source.resources.Attributes;

public class BeginButtonListener implements ActionListener {
	private Frame frame;
	private NodeEmployment employer;
	public final static int[] FISH_XPS = {110,90,100}, FISH_IDS = {383,377,371};
	public BeginButtonListener(Frame frame, NodeEmployment employer) {
		this.frame = frame;
		this.employer = employer;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object temp = frame.fishSelectionBox.getSelectedItem();
		if(temp != null) {
			Frame.fishName = (String)temp;
			switch(Frame.fishName) {
			case "Shark":
				Attributes.fishNpcId = 313;
				Frame.clickAction = "Harpoon";
				Paint.fishXp = FISH_XPS[0];
				Attributes.fishId = FISH_IDS[0];
				break;
			case "Lobster":
				Attributes.fishNpcId = 312;
				Frame.clickAction = "Cage";
				Paint.fishXp = FISH_XPS[1];
				Attributes.fishId = FISH_IDS[1];
				break;
			case "SwordFish/Tuna":
				Attributes.fishNpcId = 312;
				Frame.clickAction = "Harpoon";
				Paint.fishXp = FISH_XPS[2];
				Attributes.fishId = FISH_IDS[2];
				break;
			}
		} else {
			Attributes.fishNpcId = 313;
			Frame.clickAction = "Harpoon";
			Paint.fishXp = FISH_XPS[0];
			Attributes.fishId = FISH_IDS[0];
		}
		Attributes.useAntiBan = frame.antiBanPanel.useAntiBanBox.isSelected();
		Attributes.checkStats = frame.antiBanPanel.checkStatsBox.isSelected();
		Attributes.antiBan = new AntiBan(Attributes.useAntiBan, Attributes.checkStats,
				frame.antiBanPanel.checkPeopleBox.isSelected(),Attributes.DOCK_AREA);
		employer.load(Attributes.antiBan.myBranch);
		Attributes.showPaint = true;
		Attributes.showGui = false;
		//ScriptAttributes.fishPrice = GeItem.lookup(ScriptAttributes.fishId).getPrice();
		Paint.fishPrice = 815;
		frame.frame.setVisible(Attributes.showGui);
		frame.frame.dispose();

	}

}
