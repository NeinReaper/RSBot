package source.userInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TileViewingPanel {

	public JPanel panel;
	public JCheckBox viewMouseTileBox = new JCheckBox("View Mouse Tile"), distMouseTileBox = new JCheckBox("Distance from Mouse Tile"), 
			viewClickedTileBox = new JCheckBox("View Clicked Tile Box"), distFromClickedTileBox = new JCheckBox("Dist From Clicked Tile");
	public TileViewingPanel() {
		panel = new JPanel();
		JLabel tileViewingPanelLabel = new JLabel("Tile Viewing");
		
		tileViewingPanelLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel.setLayout(null);
		
		panel.setBounds(5, 20, 180, 110);
		tileViewingPanelLabel.setBounds(5, 0, 90, 15);
		viewMouseTileBox.setBounds(5, 20, 170, 20);
		distMouseTileBox.setBounds(5, 40, 170, 20);
		viewClickedTileBox.setBounds(5, 60, 170, 20);
		distFromClickedTileBox.setBounds(5, 80, 170, 20);
		
		panel.add(tileViewingPanelLabel);
		panel.add(viewMouseTileBox);
		panel.add(distMouseTileBox);
		panel.add(viewClickedTileBox);
		panel.add(distFromClickedTileBox);
		
		
	}
}
