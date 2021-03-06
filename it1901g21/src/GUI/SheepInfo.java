package GUI;

import it1901g21.Localization;
import it1901g21.Sheep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it1901g21.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;


public class SheepInfo {
	
	private JPanel contentPane;
	private JButton btnDone;
	private JButton btnEdit;
	private JLabel lblSerialnumber;
	private JLabel lblBirthdate;
	private JLabel lblHealth;
	private JLabel lblWeight;
	private DefaultListModel listmodel;
	private Main main;
	private EditSheep editSheep;
	
	private JFrame frame;
	private boolean isOpen;
	private int index;

	/**
	 * Create the frame.
	 */
	public SheepInfo(Main main) {
		
		this.main = main;
		this.isOpen = false;
		frame = new JFrame();
		editSheep = new EditSheep(getMain(), this);
				
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 516);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
		JLabel lblID = new JLabel("Eartag:");
		lblID.setBounds(57, 34, 124, 14);
		contentPane.add(lblID);
		
		JLabel lblAlder = new JLabel("Birth Date (yyyy.mm.dd):");
		lblAlder.setBounds(57, 65, 159, 14);
		contentPane.add(lblAlder);
		
		JLabel lblHelse = new JLabel("Health:");
		lblHelse.setBounds(57, 92, 124, 14);
		contentPane.add(lblHelse);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(12, 433, 136, 23);
		contentPane.add(btnEdit);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(308, 433, 124, 23);
		contentPane.add(btnDone);
		frame.getRootPane().setDefaultButton(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeSheepInfo();
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditSheepWindow();
			}
		});
		
		JLabel lblVekt = new JLabel("Weight (kg):");
		lblVekt.setBounds(57, 119, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel();
		lblSerialnumber.setBounds(223, 34, 177, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel();
		lblBirthdate.setBounds(223, 65, 177, 14);
		contentPane.add(lblBirthdate);
		
		lblHealth = new JLabel();
		lblHealth.setBounds(223, 91, 177, 14);
		contentPane.add(lblHealth);
		
		lblWeight = new JLabel();
		lblWeight.setBounds(223, 118, 177, 14);
		contentPane.add(lblWeight);
		
		JLabel lblLastKnownLoactions = new JLabel("Last known loactions:");
		lblLastKnownLoactions.setBounds(57, 146, 177, 16);
		contentPane.add(lblLastKnownLoactions);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 176, 322, 244);
		contentPane.add(scrollPane);
		
		listmodel = new DefaultListModel();
		JList list = new JList(listmodel);
		scrollPane.setViewportView(list);
		
	}
	
	public void seeSheep(int index) {
		
		this.index = index;
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		
		lblSerialnumber.setText(sheep.getEarTag());
		lblBirthdate.setText(sheep.getBirthDate());
		lblHealth.setText(sheep.getHealth());
		lblWeight.setText(String.valueOf(sheep.getWeigth()));
		
		updateLocations();
		
	}
	
	/**
	 * Updates the list of previously known locations
	 */
	public void updateLocations() {
		
		if (!isOpen) {
			return;
		}
		
		listmodel.clear();
		
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		
		System.out.println("SHOWING LOCATIONS FOR SHEEP: " + sheep.getEarTag());
		
		// Updates the previously-known-locations list. With something weird to prevent a Java Swing bug, apparently...
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        listmodel.clear();
		        for (Localization loc : main.getFarmer().getSheepHerd().get(index).getLoc()) {
		        	listmodel.addElement("  " + loc.getTime().substring(0, 19) + "        X: " + loc.getX() + ",    Y: " + loc.getY());
				}
		    }
		});
		
		// If open, updates the edit-sheep-window's sheep locations
		if (editSheep.isOpen()) {
			editSheep.updateLocationInfo();
		}
		
	}
	
	/**
	 * Updates the sheep info. Used when sheep is edited while info-window is still open.
	 */
	public void updateInfo() {
		
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		
		lblSerialnumber.setText(sheep.getEarTag());
		lblBirthdate.setText(sheep.getBirthDate());
		lblHealth.setText(sheep.getHealth());
		lblWeight.setText(String.valueOf(sheep.getWeigth()));
	}
	
	/**
	 * Used to open the edit-sheep-window for the given sheep
	 */
	private void openEditSheepWindow() {
		editSheep.openEditSheep(index);
	}
	
	/**
	 * Opens the sheep info
	 */
	public void openSheepInfo() {
		isOpen = true;
		frame.setVisible(true);
	}
	
	/**
	 * Closes the sheep info
	 */	
	public void closeSheepInfo() {
		isOpen = false;
		frame.setVisible(false);
	}
	
	private Main getMain() {
		return main;
	}
	
}
