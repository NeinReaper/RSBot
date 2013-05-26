package source.userInterface.tabs;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
public class AreaViewingPanel {
	public JPanel panel;
	private JLabel titleLabel, infoLabel;
	public JCheckBox viewAreaBox;
	public AreaViewingPanel() {
		panel = new JPanel();
		titleLabel = new JLabel("Area Viewing");
		infoLabel = new JLabel("- Must Have"+"\r\n"+"Tile viewing enabled");
		viewAreaBox = new JCheckBox("View Area");
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		infoLabel.setVerticalAlignment(SwingConstants.TOP);
		
		titleLabel.setBounds(5, 5, 75, 15);
		viewAreaBox.setBounds(5, 20, 100, 29);
		infoLabel.setBounds(75, 5, 115, 40);
		
		panel.add(titleLabel);
		panel.add(viewAreaBox);
		panel.add(infoLabel);	
	}
}
