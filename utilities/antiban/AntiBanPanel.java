package antiban;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AntiBanPanel {
	
	public JPanel antiBanPanel;
	public JCheckBox useAntiBanBox = new JCheckBox("Anti Ban"), checkPeopleBox = new JCheckBox("Check Ppl"), 
			checkStatsBox = new JCheckBox("Check Stats");
	public AntiBanPanel() {
		antiBanPanel = new JPanel();
		JLabel lblNewLabel = new JLabel("Anti Ban Settings");
		
		antiBanPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		antiBanPanel.setBounds(5, 30, 105, 95);
		lblNewLabel.setBounds(5, 5, 100, 14);
		useAntiBanBox.setBounds(5, 20, 80, 20);
		checkStatsBox.setBounds(5, 40, 97, 20);
		checkPeopleBox.setBounds(5,60,100,20);
	
		antiBanPanel.setLayout(null);
		
		antiBanPanel.add(lblNewLabel);
		antiBanPanel.add(useAntiBanBox);
		antiBanPanel.add(checkPeopleBox);
		antiBanPanel.add(checkStatsBox);
	}

}
