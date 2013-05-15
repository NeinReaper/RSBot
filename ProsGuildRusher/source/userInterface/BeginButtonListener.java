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
				Paint.fishXp = 110;
				Attributes.fishIds.add(383);
				break;
			case "Lobster":
				Attributes.fishNpcId = 312;
				Frame.clickAction = "Cage";
				Paint.fishXp = 90;
				Attributes.fishIds.add(377);
				break;
			case "SwordFish":
				Attributes.fishNpcId = 312;
				Frame.clickAction = "Harpoon";
				Paint.fishXp = 100;
				Attributes.fishIds.add(371);
				break;
			case "Bass":
				Attributes.fishNpcId = 313;
				Frame.clickAction = "Net";
				Paint.fishXp = 100;
				Attributes.fishIds.add(363);
				break;
			case "Tuna":
				Attributes.fishNpcId = 312;
				Frame.clickAction = "Harpoon";
				Paint.fishXp = 80;
				Attributes.fishIds.add(359);
				break;
			}
		} else {
			Attributes.fishNpcId = 313;
			Frame.clickAction = "Harpoon";
			Paint.fishXp = 110;
			Attributes.fishIds.add(383);
		}
		Attributes.antiBan = new AntiBan(frame.antiBanPanel.useAntiBanBox.isSelected(), 
				frame.antiBanPanel.checkStatsBox.isSelected(),
				frame.antiBanPanel.checkPeopleBox.isSelected(),Attributes.DOCK_AREA);
		Attributes.dropFish = frame.dropFishBox.isSelected();
		container.submit(Attributes.antiBan.myManager);
		Attributes.showPaint = true;
		Attributes.showGui = false;
		//ScriptAttributes.fishPrice = GeItem.lookup(ScriptAttributes.fishId).getPrice();
		Paint.fishPrice = 815;
		frame.frame.setVisible(Attributes.showGui);
		frame.frame.dispose();

	}

}
