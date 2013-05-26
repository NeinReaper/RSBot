package source.resources;
import java.util.ArrayList;

import logger.Logging;
import org.powerbot.game.api.wrappers.interactive.Character;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class ScriptAttributes {
	public static boolean showGui = true, showPaint = false, viewMouseTile = false, viewClickedTile = false, 
							viewDistFromMouseTile = false, viewDistFromClickedTile = false, viewEntities = false,
							highLightEntities = false, displayNames = false, viewArea = false, viewDrops = false;
	public static Character eToDraw;
	public static Tile mouseTile = new Tile(0,0,0), clickedTile = mouseTile;
	public static Area areaToDraw;
	public static Logging logger = new Logging();
	public static ArrayList<Character> characters = new ArrayList<Character>();
}
