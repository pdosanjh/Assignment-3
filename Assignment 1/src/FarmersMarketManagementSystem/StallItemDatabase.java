package FarmersMarketManagementSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implementation of the StallItemDatabase
 *
 */
public class StallItemDatabase {
	// List to hold all stall Items
	Map<Integer, StallItem> map = new HashMap<>();

	/**
	 * Insert the stall item into the list
	 * 
	 * @param itemNumber
	 * @param item
	 * @return
	 */
	boolean insert(int itemNumber, StallItem item) {
		map.put(itemNumber, item);
		return true;
	}

	/**
	 * Retrieve the stall item from the list
	 * 
	 * @param index
	 * @return
	 */
	StallItem retrive(int index) {
		return map.get(index);
	}

	/**
	 * Getter for Map
	 * 
	 * @return
	 */
	public Map<Integer, StallItem> getMap() {
		return map;
	}

	/**
	 * Setter for Map
	 * 
	 * @param map
	 */
	public void setMap(Map<Integer, StallItem> map) {
		this.map = map;
	}

	/**
	 * Overridden toString
	 */
	@Override
	public String toString() {
		return "StallItemDatabase [list=" + map + "]";
	}

}
