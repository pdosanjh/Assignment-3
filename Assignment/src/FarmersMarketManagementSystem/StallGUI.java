package FarmersMarketManagementSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * GUI for a particular stall
 *
 */
public class StallGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4107373050757393035L;
	Stall stall; // Reference to stall
	JCheckBox[] checkBoxes = new JCheckBox[10]; // List of all check boxes
	JButton price, display;
	List<StallItem> stallList;
	/**
	 * Constructor for GUI of a particular stall that takes Stall as argument.
	 * @param stall
	 */
	StallGUI(Stall stall) {
		this.stall = stall;
		initComponents();
		addActionListeners();
		for (int i = 0; i < 10; i++) {
			add(checkBoxes[i]);
		}
		add(price);
		add(display);
		setSize(600, 600);
		setTitle(stall.name);
		setLayout(new GridLayout(6, 2, 50, 50));
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	/**
	 * Adds action listeners to the buttons
	 */
	private void addActionListeners() {
		price.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double price = 0;
				for (int i = 0; i < 10; i++) {
					if (checkBoxes[i].isSelected()) {
						price += stallList.get(i).getPrice();
					}
				}
				JOptionPane.showMessageDialog(null, "The total price is : " + price);
			}
		});
		display.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> bigList = new ArrayList<String>();
				String longMessage = "";
				for (int i = 0; i < 10; i++) {
					if (checkBoxes[i].isSelected()) {
						bigList.add(stallList.get(i).toString());
						longMessage += stallList.get(i).toString() + "\n";
					}
				}

				// create a JTextArea
			      JTextArea textArea = new JTextArea(6, 25);
			      if(longMessage.length() == 0){
			    	  longMessage = "There are no Items selected";
			      }
			      textArea.setText(longMessage);
			      textArea.setEditable(false);
			      
			      // wrap a scrollpane around it
			      JScrollPane scrollPane = new JScrollPane(textArea);
			      
			      // display them in a message dialog
			      JOptionPane.showMessageDialog(null, scrollPane);

			}
		});
	}

	/**
	 * Initialize all components.
	 */
	private void initComponents() {
		stallList = new ArrayList<>();
		for (Map.Entry<Integer, StallItem> item : stall.getDatabase().getMap().entrySet()) {
			stallList.add(item.getValue());
		}
		for (int i = 0; i < 10; i++) {
			StallItem item = stallList.get(i);
			checkBoxes[i] = new JCheckBox("Name : " + item.itemName + " Price : " + item.getPrice());
		}
		price = new JButton("Compute Price");
		display = new JButton("Display Items");
	}

}
