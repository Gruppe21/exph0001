package GUI;

import it1901g21.Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DelSheep {
	
	private Main main;
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Initialize the contents of the frame.
	 */
	public DelSheep(Main main) {
		
		this.main = main;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblPleaseEnterSheep = new JLabel("Please enter the Sheep's ear tag:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPleaseEnterSheep, 67, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterSheep, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblPleaseEnterSheep);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		springLayout.putConstraint(SpringLayout.NORTH, btnConfirm, 15, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnConfirm, -27, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, btnConfirm);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnConfirm);
		springLayout.putConstraint(SpringLayout.EAST, btnConfirm, -42, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnConfirm);
		frame.getRootPane().setDefaultButton(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, btnConfirm, 87, SpringLayout.EAST, btnCancel);
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 18, SpringLayout.SOUTH, lblPleaseEnterSheep);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 47, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, 150, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnCancel);
		
		/*
		 * Action to happen when user clicks "cancel"
		 */
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDelSheep();
			}
		});
		
		/*
		 * Action to happen when user clicks "confirm"
		 */
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText() == null) {
					ErrorMessage error = new ErrorMessage("", "Please enter the ear tag!");
					return;
				}
				
				String earTag = textField.getText();
				sendDeleteSheep(earTag);
				
				// Resets the text field
				textField.setText(null);
				
			}
		});
		
	}
	
	
	/**
	 * Opens the delSheep window
	 */
	public void openDelSheep() {
		frame.setVisible(true);
	}
	
	/**
	 * Closes the delSheep window
	 */
	private void closeDelSheep(){
		frame.setVisible(false);
	}
	
	/**
	 * Sends the prompt to delete the sheep to Main
	 */
	private void sendDeleteSheep(String earTag) {
		closeDelSheep();
		main.deleteSheep(earTag);
	}
}
