package source.resources;

import logger.Logging;

import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.Player;

public class ScriptAttributes {
	public static boolean showGui = true, showPaint = false, viewMouseTile = false, viewClickedTile = false, 
							viewDistFromMouseTile = false, viewDistFromClickedTile = false, viewPlayers = false,
							highLightPlayers = false, displayNames = false;
	public static Tile mouseTile = new Tile(0,0,0), tileIterator = mouseTile, clickedTile = mouseTile;
	public static Player myPlayer, playerToDraw;
	public static Logging logger = new Logging();

}
