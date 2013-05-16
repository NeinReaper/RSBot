package source.event.events;

import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;
import source.Attributes;
import frameWork.event.Event;

public class DropFishEvent extends Event {

	@Override
	public boolean condition() {
		Integer[] list = Attributes.fishIds
				.toArray(new Integer[Attributes.fishIds.size()]);
		int[] temp = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			temp[i] = list[i];
		}
		return (Attributes.dropFish && inventoryContainsOtherThan(temp));
	}

	@Override
	public void execute() {
		super.execute();
		for (Item item : Inventory.getItems()) {
			if (!Attributes.fishIds.contains(item.getId())) {
				item.getWidgetChild().interact("Drop");
			}
		}
	}

	public boolean inventoryContainsOtherThan(int... ids) {
		if (itemOtherThan(ids) != null) {
			return true;
		}
		return false;
	}

	public Item itemOtherThan(int... ids) {
		for (Item item : Inventory.getItems()) {
			for (int i : ids) {
				if (item.getId() != i) {
					return item;
				}
			}
		}
		return null;
	}

}
