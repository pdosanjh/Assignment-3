package FarmersMarketManagementSystem;

/**
 * 
 * Implementation of the Premium Sub Class
 *
 */
public class Premium extends StallItem {
	int count; // Count if the number of premium items

	/**
	 * Default constructor for Premium
	 */
	public Premium() {
		itemName = "Premium";
		itemPrice = 100;
		count = 10;
	}

	/**
	 * Custom constructor
	 * 
	 * @param name
	 * @param price
	 * @param count
	 */
	Premium(String name, double price, int count) {
		this.itemName = name;
		this.itemPrice = price;
		this.count = count;
	}

	/**
	 * Overridden getPrice method.
	 */
	@Override
	public double getPrice() {
		return itemPrice * 2; // Premium items are sold at twice the price.
	}

	/**
	 * Getter for count
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Setter for count
	 * 
	 * @return
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Setter for Price
	 */
	@Override
	public void setPrice(double price) {
		this.itemPrice = price;

	}

	/**
	 * Overridden toString method.
	 */
	@Override
	public String toString() {
		return "Premium [count=" + count + ", itemName=" + itemName + ", itemPrice=" + getPrice() + "]";
	}

}
