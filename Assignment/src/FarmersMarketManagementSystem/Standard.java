package FarmersMarketManagementSystem;

/**
 * 
 * Implementation of the Standard Sub Class
 *
 */
public class Standard extends StallItem {
	String specification; // specification of the item

	/**
	 * Default Constructor
	 */
	public Standard() {
		itemName = "Standard Item";
		itemPrice = 100;
		specification = "";
	}

	/**
	 * Custom Constructor
	 * 
	 * @param name
	 * @param price
	 * @param spec
	 */
	Standard(String name, double price, String spec) {
		itemName = name;
		itemPrice = price;
		specification = spec;
	}

	/**
	 * Getter for specification
	 * 
	 * @return
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * Setter for specification
	 * 
	 * @param specification
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	/**
	 * Overridden getPrice
	 */
	@Override
	public double getPrice() {
		return itemPrice;
	}
	/**
	 * Setter for Price
	 */
	@Override
	public void setPrice(double price) {
		this.itemPrice = price;
		
	}

	/**
	 * Overridden toString() method
	 */

	@Override
	public String toString() {
		return "Standard [specification=" + specification + ", itemName=" + itemName + ", itemPrice=" + getPrice() + "]";
	}

}
