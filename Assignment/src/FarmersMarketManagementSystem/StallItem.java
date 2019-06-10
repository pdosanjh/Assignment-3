package FarmersMarketManagementSystem;
/**
 * 
 * Base class StallItem that is abstract
 *
 */
public abstract class StallItem {
	
	String itemName; // Name of the item
	double itemPrice; // Price of the item
	/**
	 * Getter for Name
	 * @return
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Setter for Name
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * Getter for Price
	 * @return
	 */
	public abstract double getPrice();
	/**
	 * Setter for Price
	 * @param price
	 */
	public abstract void setPrice(double price);
	/**
	 * Overridden toString method
	 */
	@Override
	public String toString() {
		return "StallItem [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
}
