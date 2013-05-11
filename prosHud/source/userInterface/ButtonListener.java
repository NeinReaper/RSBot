package source.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import source.resources.ScriptAttributes;

public class ButtonListener implements ActionListener{
	private GUI gui;
	public ButtonListener(GUI gui) {
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ScriptAttributes.viewMouseTile = gui.tileViewingPanel.viewMouseTileBox.isSelected();
		ScriptAttributes.viewClickedTile = gui.tileViewingPanel.viewClickedTileBox.isSelected();
		ScriptAttributes.viewDistFromMouseTile = gui.tileViewingPanel.distMouseTileBox.isSelected();
		ScriptAttributes.viewDistFromClickedTile = gui.tileViewingPanel.distFromClickedTileBox.isSelected();
		ScriptAttributes.viewPlayers = gui.playerViewingPanel.playerViewingBox.isSelected();
		ScriptAttributes.highLightPlayers = gui.playerViewingPanel.highlightBox.isSelected();
		ScriptAttributes.displayNames = gui.playerViewingPanel.displayPlayersBox.isSelected();
		ScriptAttributes.showGui = false;
		ScriptAttributes.showPaint = true;
		gui.frame.setVisible(ScriptAttributes.showGui);
		gui.frame.dispose();
		
	}

}
