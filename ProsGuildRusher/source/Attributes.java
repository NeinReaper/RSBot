package source;

import java.util.ArrayList;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import antiban.AntiBan;

public class Attributes {
	public static boolean showGui = true, showPaint = false, dropFish = false;

	public final static Area DOCK_AREA = new Area(new Tile(2607, 3428, 0), new Tile(2597, 3418, 0)),
								BANK_AREA = new Area(new Tile[] {new Tile(2581, 3425, 0), new Tile(2588, 3425, 0), 
														new Tile(2588, 3417, 0), new Tile(2581, 3417, 0) }),
								D_AREA = new Area(new Tile[] { new Tile(2595, 3418, 0), new Tile(2595, 3428, 0), 
																new Tile(2608, 3428, 0), new Tile(2608, 3418, 0), 
																new Tile(2615, 3418, 0), new Tile(2615, 3408, 0), 
																new Tile(2600, 3408, 0), new Tile(2600, 3418, 0) });

	public static NPC fishSpot = null;

	public static int fishNpcId;

	public static ArrayList<Integer> fishIds = new ArrayList<Integer>();

	public final static Tile[] BANKING_PATH = {new Tile(2608, 3414, 0), new Tile(2604, 3414, 0), 
												new Tile(2604, 3420, 0),new Tile(2601, 3421, 0),
												new Tile(2599, 3421, 0), new Tile(2597, 3421, 0),
												new Tile(2595, 3421, 0), new Tile(2593, 3421, 0),
												new Tile(2591, 3421, 0), new Tile(2589, 3421, 0),
												new Tile(2587, 3421, 0), new Tile(2585, 3421, 0)},
								BANKING_PATH_1 = {new Tile(2603, 3412,0), new Tile(2603, 3409,0),
													new Tile(2603, 3406, 0), new Tile(2603, 3403, 0),
													new Tile(2602, 3403, 0), new Tile(2599, 3403, 0),
													new Tile(2597, 3404, 0), new Tile(2597, 3407, 0),
													new Tile(2597, 3410, 0), new Tile(2597, 3413, 0),
													new Tile(2594, 3413, 0), new Tile(2593, 3415, 0),
													new Tile(2591, 3419, 0), new Tile(2589, 3421, 0),
													new Tile(2586, 3422, 0)};

	public static AntiBan antiBan;

}
