package source.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import source.resources.ScriptAttributes;

public class ButtonListener implements ActionListener{
	private HudFrame gui;
	public ButtonListener(HudFrame gui) {
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ScriptAttributes.viewMouseTile = gui.tvPanel.viewMouseTileBox.isSelected();
		ScriptAttributes.viewClickedTile = gui.tvPanel.viewClickedTileBox.isSelected();
		ScriptAttributes.viewDistFromMouseTile = gui.tvPanel.distMouseTileBox.isSelected();
		ScriptAttributes.viewDistFromClickedTile = gui.tvPanel.distFromClickedTileBox.isSelected();
		ScriptAttributes.viewEntities = gui.pvPanel.entityViewingBox.isSelected();
		ScriptAttributes.highLightEntities = gui.pvPanel.highlightBox.isSelected();
		ScriptAttributes.displayNames = gui.pvPanel.displayNamesBox.isSelected();
		ScriptAttributes.viewArea = gui.avPanel.viewAreaBox.isSelected();
		ScriptAttributes.showGui = false;
		ScriptAttributes.showPaint = true;
	}

}
