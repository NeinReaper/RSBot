package source.userInterface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import source.userInterface.tabs.AreaViewingPanel;
import source.userInterface.tabs.TileViewingPanel;
import source.userInterface.tabs.characterViewing.CharacterViewingPanel;

public class HudFrame {
	public JFrame frame;
	private JPanel contentPane;
	private JTabbedPane tabPane;
	public TileViewingPanel tvPanel;
	public CharacterViewingPanel pvPanel;
	public AreaViewingPanel avPanel;
	
	private JButton startButton;
	/**
	 * Create the frame.
	 */
	public HudFrame() {
		contentPane = new JPanel();
		frame = new JFrame();
		frame.setSize(450,300);
		tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setLocation(0, 0);
		tabPane.setSize(434, 241);
		tvPanel = new TileViewingPanel();
		pvPanel = new CharacterViewingPanel();
		avPanel = new AreaViewingPanel();
		startButton = new JButton("Apply");
		
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		startButton.addActionListener(new ButtonListener(this));
		
		startButton.setBounds(169, 241, 89, 23);
		
		contentPane.add(startButton);
		contentPane.add(tabPane);
		
		tabPane.addTab("Tile Viewing", tvPanel.panel);
		tabPane.addTab("Player Viewing", pvPanel.panel);
		tabPane.addTab("Area Viewing", avPanel.panel);
	
	}
}
