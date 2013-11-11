package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JTextField firstName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JTextField lastName;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField phoneNumber;
	private JLabel lblPhoneNumber;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirm;
	private JTextField contactName;
	private JTextField contactTlf;
	private JLabel lblContactPersonName;
	private JLabel lblContactPersonNumber;

	

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(199, 47, 219, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		firstName = new JTextField();
		firstName.setBounds(199, 140, 219, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(21, 50, 168, 14);
		contentPane.add(lblEmail);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 81, 168, 14);
		contentPane.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(21, 112, 168, 14);
		contentPane.add(lblConfirmPassword);
		
		lastName = new JTextField();
		lastName.setBounds(199, 171, 219, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(21, 143, 168, 14);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(21, 174, 168, 14);
		contentPane.add(lblLastName);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(199, 202, 219, 20);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(21, 205, 168, 14);
		contentPane.add(lblPhoneNumber);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 78, 219, 20);
		contentPane.add(passwordField);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setBounds(199, 109, 219, 20);
		contentPane.add(passwordField_confirm);
		
		contactName = new JTextField();
		contactName.setBounds(199, 233, 219, 20);
		contentPane.add(contactName);
		contactName.setColumns(10);
		
		contactTlf = new JTextField();
		contactTlf.setBounds(199, 264, 219, 20);
		contentPane.add(contactTlf);
		contactTlf.setColumns(10);
		
		lblContactPersonName = new JLabel("Contact person Name");
		lblContactPersonName.setBounds(21, 236, 168, 14);
		contentPane.add(lblContactPersonName);
		
		lblContactPersonNumber = new JLabel("Contact person Number");
		lblContactPersonNumber.setBounds(21, 267, 168, 14);
		contentPane.add(lblContactPersonNumber);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(21, 295, 133, 23);
		contentPane.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeRegistration();
			}
		});
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(285, 295, 133, 23);
		contentPane.add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rEmail = emailTextField.getText();
				String rFirstName = firstName.getText();
				String rLastName = lastName.getText();
				String rphoneNumber = phoneNumber.getText();
				char rpasswordField[] = passwordField.getPassword();
				char rpasswordFieldconfirm[] = passwordField_confirm.getPassword();
				String  rcontactName = contactName.getText();
				String rcontactTlf = contactTlf.getText();
				
				retEmail(rEmail);
				retFirstName(rFirstName);
				retLastName(rLastName);
				retPhone(rphoneNumber);
				retpassword(rpasswordField);
				retpasswordConfirm(rpasswordFieldconfirm);
				retContactName(rcontactName);
				retContactPhone(rcontactTlf);
			}
			
		});
		
		this.setVisible(true);
	}
	
	public void closeRegistration(){
		this.setVisible(false);
	}
	
	public String retEmail(String email){
		return email;
	}
	public String retFirstName(String name){
		return name;
	}
	public String retLastName(String lastname) {
		return lastname;
	}
	public String retPhone(String phoneNumber){
		return phoneNumber;
	}
	public String retContactName(String contactName){
		return contactName;
	}
	public String retContactPhone(String contactPhone){
		return contactPhone;
	}
	public char[] retpassword(char[] rpasswordField){
		return rpasswordField;
	}
	public char[] retpasswordConfirm(char[] passConfirm){
		return passConfirm;
	}
}
