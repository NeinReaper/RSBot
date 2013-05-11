package source.userInterface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class GUI{
	public JFrame frame;
	protected JPanel contentPane;
	protected TileViewingPanel tileViewingPanel;
	protected PlayerViewingPanel playerViewingPanel;
	
	
	public GUI() {
		frame = new JFrame();
		contentPane = new JPanel();
		playerViewingPanel = new PlayerViewingPanel();
		tileViewingPanel = new TileViewingPanel();
		JLabel titleLabel = new JLabel("ProsDynamicHud");
		JButton startButton = new JButton("Start");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		startButton.addActionListener(new ButtonListener(this));
		
		frame.setBounds(100, 100, 400, 200);
		titleLabel.setBounds(5, 0, 115, 15);
		startButton.setBounds(50, 130, 90, 20);
		
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(tileViewingPanel.panel);
		contentPane.add(titleLabel);
		contentPane.add(startButton);
		contentPane.add(playerViewingPanel.panel);
	}
}
