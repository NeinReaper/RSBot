package source.userInterface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

import deprecatedNodeSystem.NodeEmployment;

import frameWork.StaffContainer;

import antiban.AntiBanPanel;
public class Frame {

	public final static String[] FISH_TYPES = {"Shark", "Lobster", "SwordFish/Tuna"};
	public static String fishName = "", clickAction = "";
	public JFrame frame;
	private JPanel contentPane;
	public AntiBanPanel antiBanPanel;
	public JComboBox<String> fishSelectionBox = new JComboBox<String>();
	public JCheckBox dropFishBox = new JCheckBox("Drop Unwanted Fish");
	public Frame(StaffContainer c) {
		frame = new JFrame();
		contentPane = new JPanel();
		antiBanPanel = new AntiBanPanel();
		JLabel titleLabel = new JLabel("ProsGuildRusher");
		JButton beginButton = new JButton("Begin");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		fishSelectionBox.setModel(new DefaultComboBoxModel<String>(FISH_TYPES));
		
		beginButton.addActionListener(new BeginButtonListener(this,c));
		
		frame.setBounds(100, 100, 275, 175);
		titleLabel.setBounds(5, 5, 135, 20);
		fishSelectionBox.setBounds(120, 30, 90, 20);
		beginButton.setBounds(120, 90, 90, 20);
		dropFishBox.setBounds(120, 60, 140, 20);
		
		
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(titleLabel);
		contentPane.add(antiBanPanel.antiBanPanel);
		contentPane.add(fishSelectionBox);
		contentPane.add(beginButton);
		contentPane.add(dropFishBox);
	}
}
