package FarmersMarketManagementSystem;

/**
 * 
 * Implementation of the Discounted Sub Class
 *
 */
public class Discounted extends StallItem {
	int discount; // Discount percentage

	/**
	 * Default Constructor
	 */
	public Discounted() {
		itemName = "Discounted Item";
		itemPrice = 100;
		discount = 10;
	}

	/**
	 * Custom Constructor
	 * 
	 * @param name
	 * @param price
	 * @param discount
	 */
	Discounted(String name, double price, int discount) {
		itemName = name;
		itemPrice = price;
		this.discount = discount;
	}

	/**
	 * Overridden getPrice
	 */
	@Override
	public double getPrice() {
		return (itemPrice - (itemPrice * ((double) discount / 100)));
	}

	/**
	 * Getter for discount
	 * 
	 * @return
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Setter for discount
	 * 
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
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
		return "Discounted [discount=" + discount + ", itemName=" + itemName + ", itemPrice=" + getPrice() + "]";
	}
	

}
