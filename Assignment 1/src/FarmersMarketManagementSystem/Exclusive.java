package FarmersMarketManagementSystem;

/**
 * 
 * Exclusive sub class implementation for StallItem
 *
 */
public class Exclusive extends StallItem {
	int increasePercent; // The percentage increase price

	/**
	 * Default Constructor.
	 */
	public Exclusive() {
		itemName = "Exclusive Item";
		itemPrice = 100;
		increasePercent = 50;
	}

	/**
	 * Custom Constructor
	 * 
	 * @param name
	 * @param price
	 * @param increasePercent
	 */
	Exclusive(String name, double price, int increasePercent) {
		this.itemName = name;
		this.itemPrice = price;
		this.increasePercent = increasePercent;
	}

	/**
	 * Overridden getPrice()
	 */
	@Override
	public double getPrice() {
		return itemPrice * (1 + ((double) increasePercent / 100));
	}

	/**
	 * Getter for increasePercent
	 * 
	 * @return
	 */
	public int getIncreasePercent() {
		return increasePercent;
	}

	/**
	 * Setter for increasePercent
	 * 
	 * @param increasePercent
	 */
	public void setIncreasePercent(int increasePercent) {
		this.increasePercent = increasePercent;
	}
	/**
	 * Setter for Price
	 */
	@Override
	public void setPrice(double price) {
		this.itemPrice = price;
		
	}
	/**
	 * Overridden toString
	 */
	@Override
	public String toString() {
		return "Exclusive [increasePercent=" + increasePercent + ", itemName=" + itemName + ", itemPrice=" + getPrice()
				+ "]";
	}

}
