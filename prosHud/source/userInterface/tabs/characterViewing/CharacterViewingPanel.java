package source.userInterface.tabs.characterViewing;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
public class CharacterViewingPanel{
	public JPanel panel;
	public JCheckBox entityViewingBox = new JCheckBox("View Entities"),  highlightBox = new JCheckBox("Highlight Entity")
						,displayNamesBox = new JCheckBox("Display Names");
	public CharacterViewingPanel() {
		panel = new JPanel();
		JLabel titleLabel = new JLabel("Entity Viewing Panel");

		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		titleLabel.setBounds(5, 0, 115, 20);
		entityViewingBox.setBounds(5, 20, 130, 20);
		highlightBox.setBounds(5, 40, 130, 20);
		displayNamesBox.setBounds(5, 60, 130, 20);

		panel.add(titleLabel);
		panel.add(entityViewingBox);
		panel.add(highlightBox);
		panel.add(displayNamesBox);
	}
}
