package source.userInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class PlayerViewingPanel{
	public JPanel panel;
	public JCheckBox playerViewingBox = new JCheckBox("View Players"),  highlightBox = new JCheckBox("Highlight Player")
					,displayPlayersBox = new JCheckBox("Display Names");
	public PlayerViewingPanel() {
		panel = new JPanel();
		JLabel titleLabel = new JLabel("Player Viewing Panel");
		
		panel.setLayout(null);
		
		panel.setBounds(190, 20, 190, 110);
		titleLabel.setBounds(5, 0, 115, 20);
		playerViewingBox.setBounds(5, 20, 100, 20);
		highlightBox.setBounds(5, 40, 100, 20);
		displayPlayersBox.setBounds(5, 60, 100, 20);
		
		panel.add(titleLabel);
		panel.add(playerViewingBox);
		panel.add(highlightBox);
		panel.add(displayPlayersBox);

	}
}
