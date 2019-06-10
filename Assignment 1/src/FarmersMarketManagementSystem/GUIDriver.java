package FarmersMarketManagementSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
/**
 * 
 * Driver class for GUI.
 *
 */
public class GUIDriver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8416517133020280649L;
	
	Stall appleStall, orangeStall, mangoStall, grapeStall; // The stalls created
	JCheckBox appleCheck, orangeCheck, mangoCheck, grapeCheck; // Check boxes for stalls
	JButton open, exit; // Buttons created

	

	/**
	 * Constructor for the GUI.
	 */
	public GUIDriver() {
		initComponents();
		addActionListeners();
		setSize(300, 300);
		add(appleCheck);
		add(orangeCheck);
		add(mangoCheck);
		add(grapeCheck);
		add(open);
		add(exit);
		setTitle("STALL GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 2, 50, 50));
		setVisible(true);

	}

	/**
	 * Adds action listeners to buttons.
	 */
	private void addActionListeners() {
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		open.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check1 = appleCheck.isSelected();
				boolean check2 = orangeCheck.isSelected();
				boolean check3 = mangoCheck.isSelected();
				boolean check4 = grapeCheck.isSelected();
				if (check1) {
					StallGUI stall1 = new StallGUI(appleStall);
				}
				if (check2) {
					StallGUI stall2 = new StallGUI(orangeStall);
				}
				if (check3) {
					StallGUI stall3 = new StallGUI(mangoStall);
				}
				if (check4) {
					StallGUI stall4 = new StallGUI(grapeStall);
				}
			}
		});
	}

	/**
	 * Initialize the components
	 */
	private void initComponents() {
		appleStall = new Stall("Apple Stall");
		orangeStall = new Stall("Orange Stall");
		mangoStall = new Stall("Mango Stall");
		grapeStall = new Stall("Grape Stall");
		appleCheck = new JCheckBox(appleStall.name);
		orangeCheck = new JCheckBox(orangeStall.name);
		mangoCheck = new JCheckBox(mangoStall.name);
		grapeCheck = new JCheckBox(grapeStall.name);
		open = new JButton("Open");
		exit = new JButton("Exit");
	}

	/**
	 * Main method to drive the computation
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIDriver();
			}
		});
	}

}
