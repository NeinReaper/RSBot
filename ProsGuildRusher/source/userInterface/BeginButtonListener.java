package source.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import deprecatedNodeSystem.NodeEmployment;
import frameWork.StaffContainer;


import antiban.AntiBan;

import source.Attributes;

public class BeginButtonListener implements ActionListener {
	private Frame frame;
	private StaffContainer container;
	public final static int[] FISH_XPS = {110,90,100}, FISH_IDS = {383,377,371};
	public BeginButtonListener(Frame frame, StaffContainer c) {
		this.frame = frame;
		container = c;
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
		container.submit(Attributes.antiBan.myManager);
		Attributes.showPaint = true;
		Attributes.showGui = false;
		//ScriptAttributes.fishPrice = GeItem.lookup(ScriptAttributes.fishId).getPrice();
		Paint.fishPrice = 815;
		frame.frame.setVisible(Attributes.showGui);
		frame.frame.dispose();

	}

}
