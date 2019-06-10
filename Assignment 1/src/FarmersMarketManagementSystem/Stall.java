package FarmersMarketManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * 
 * Implementation of the Stall class
 *
 */
public class Stall {

	StallItemDatabase database; // Points to the StallItemDatabase
	static int count = 0;
	String name;

	/**
	 * Constructor that reads the file and adds items to Stall Item Database
	 */
	Stall() {
		count++;
		if (count > 30) {
			throw new RuntimeException("Can't create more than 30 stalls");
		}
		database = new StallItemDatabase();
		try {
			FileReader fileReader = new FileReader(new File("AppleStall.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			name = bufferedReader.readLine();
			String type = "", name = "";
			double price = 0;
			String line;
			int index = 1;
			while (!(line = bufferedReader.readLine()).equalsIgnoreCase("END")) {
				type = line;
				name = bufferedReader.readLine();
				price = Double.parseDouble(bufferedReader.readLine());
				if (type.equalsIgnoreCase("Premium")) {
					Premium premium = new Premium(name, price, 10);
					database.getMap().put(index, premium);
					index++;
				} else if (type.equalsIgnoreCase("Standard")) {
					Standard standard = new Standard(name, price, "No Spec");
					database.getMap().put(index, standard);
					index++;
				} else if (type.equalsIgnoreCase("Discount")) {
					Discounted discount = new Discounted(name, price, 10);
					database.getMap().put(index, discount);
					index++;
				} else if (type.equalsIgnoreCase("Special")) {
					Exclusive exclusive = new Exclusive(name, price, 100);
					database.getMap().put(index, exclusive);
					index++;
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}
	Stall(String name) {
		count++;
		this.name = name;
		if (count > 30) {
			throw new RuntimeException("Can't create more than 30 stalls");
		}
		Random random = new Random();
		database = new StallItemDatabase();
		// Add 10 default items to the stall/
		StallItem[] array = { new Discounted(), new Exclusive(), new Discounted(), new Standard(), new Premium() };
		for (int i = 0; i < 10; i++) {
			database.insert(i, array[random.nextInt(array.length)]);
		}
	}

	/**
	 * This method writes the contents to the file.
	 * 
	 * @param fileName
	 */
	public void writeToFile(String fileName) {

		try {
			File file = new File(fileName);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(this.name + "\n");
			for (Map.Entry<Integer, StallItem> entry : database.getMap().entrySet()) {
				StallItem item = entry.getValue();
				if (item instanceof Premium) {
					writer.write("Premium \n");
				} else if (item instanceof Standard) {
					writer.write("Standard \n");
				} else if (item instanceof Discounted) {
					writer.write("Discount \n");
				} else if (item instanceof Exclusive) {
					writer.write("Special \n");
				}
				writer.write(item.getItemName() + "\n");
				writer.write(item.itemPrice + "\n");
			}
			writer.write("END");
			writer.close();
			System.out.println("Contents written to file successfully");
		} catch (IOException e) {
			System.out.println("Excpetion Occured please try again");
		}
	}

	/**
	 * Getter for Database
	 * 
	 * @return
	 */
	public StallItemDatabase getDatabase() {
		return database;
	}

	/**
	 * Setter for Database
	 * 
	 * @param database
	 */
	public void setDatabase(StallItemDatabase database) {
		this.database = database;
	}

	/**
	 * Overridden toString()
	 */
	@Override
	public String toString() {
		String result = "Stall Name : " + name + " \n";
		for (Map.Entry<Integer, StallItem> item : database.getMap().entrySet()) {
			result += item.getKey() + ". " + item.getValue() + " \n";
		}
		return result;
	}

	/**
	 * Helper to print all the items in the stall database.
	 */
	public void printItemsInStall() {
		Map<Integer, StallItem> map = database.getMap();
		if (map.size() == 0) {
			System.out.println("There are no items in the stall");
			return;
		}
		for (Map.Entry<Integer, StallItem> item : map.entrySet()) {
			System.out.println(item.getValue());
		}
	}

}
