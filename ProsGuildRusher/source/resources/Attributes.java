package source.resources;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;

import antiban.AntiBan;

public class Attributes {
	public static boolean useAntiBan = false, checkStats = false, showGui = true, showPaint = false;
	
	public final static Area DOCK_AREA = new Area(new Tile[] { new Tile(2596, 3418, 0), new Tile(2596, 3426, 0), new Tile(2607, 3426, 0), new Tile(2607, 3418, 0) }),
			BANK_AREA = new Area(new Tile[] { new Tile(2581, 3425, 0), new Tile(2588, 3425, 0), new Tile(2588, 3417, 0), new Tile(2581, 3417, 0) });

		public static NPC fishSpot = null;

		public static int fishNpcId, fishId;
		
	public final static Tile[] BANKING_PATH = { new Tile(2601, 3421, 0), new Tile(2599, 3421, 0), new Tile(2597, 3421, 0), 
			new Tile(2595, 3421, 0), new Tile(2593, 3421, 0), new Tile(2591, 3421, 0), 
			new Tile(2589, 3421, 0), new Tile(2587, 3421, 0), new Tile(2585, 3421, 0) };
	
	public static AntiBan antiBan;
	
	
}
