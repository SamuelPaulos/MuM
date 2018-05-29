package ui.loginForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import banking.entity.BankStaff;
import creditCard.entity.CreditStaff;
import framework.dao.StaffDataBase;

import framework.validator.FormValidator2;

public class UserRegistration extends FormValidator2 {

	List<String> lableTxtList = new ArrayList<>();
	List<JTextField> txtFieldList = new ArrayList<>();
	JFrame userFrame = new JFrame("CREDIT UNION USER REGISTRATION FORM");
	JLabel title, firstnameLabel, lastnameLabel, genderLabel, usernameLabel, passwordLabel, ageLabel;
	JTextField firstnameField, lastnameField, genderField, usernameField, passwordField, ageField;
	JButton registerButton, exitButton, updateButton, deleteButton, resetButton, refresh;

	JRadioButton male, female, bankStaff, creditStaff;
	ButtonGroup bg, staff;
	JPanel panel;
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollpane;

	public UserRegistration(String bankOrCreditSelected) {
		// TODO Auto-generated constructor stub

		userFrame.setTitle("User Registration -- Bank");
		userFrame.setSize(450, 420);
		userFrame.setLayout(null);

		title = new JLabel("Registration Form");

		refreshTxtFieldList(new ArrayList<>());

		title.setBounds(60, 7, 200, 30);
		firstnameLabel = new JLabel("FirstName");
		firstnameLabel.setBounds(30, 80, 60, 30);
		lastnameLabel = new JLabel("LastName");
		lastnameLabel.setBounds(30, 115, 60, 30);
		genderLabel = new JLabel("Gender");
		genderLabel.setBounds(30, 150, 60, 30);

		ageLabel = new JLabel("Age");
		ageLabel.setBounds(30, 185, 60, 30);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(30, 220, 60, 30);
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 255, 60, 30);

		firstnameField = new JTextField();

		firstnameField.setBounds(95, 80, 130, 30);
		firstnameField.setName("firstname");
		regiterTextField(firstnameField);
		lastnameField = new JTextField();
		lastnameField.setBounds(95, 115, 130, 30);
		lastnameField.setName("lastname");
		regiterTextField(lastnameField);
		// Defining Gender Buttons
		male = new JRadioButton("Male");
		male.setBounds(95, 150, 60, 30);
		male.setSelected(true);
		female = new JRadioButton("Female");
		female.setBounds(155, 150, 70, 30);

		bankStaff = new JRadioButton("Bank Staff");
		bankStaff.setBounds(30, 40, 110, 30);
		bankStaff.setSelected(true);
		creditStaff = new JRadioButton("Credit Staff");
		creditStaff.setBounds(145, 40, 120, 30);

		bg = new ButtonGroup();
		staff = new ButtonGroup();

		bg.add(male);
		bg.add(female);

		staff.add(bankStaff);
		staff.add(creditStaff);

		ageField = new JTextField();
		ageField.setBounds(95, 185, 130, 30);
		regiterTextField(ageField);
		ageField.setName("age");

		usernameField = new JTextField();
		usernameField.setBounds(95, 220, 130, 30);
		regiterTextField(usernameField);
		usernameField.setName("username");

		passwordField = new JPasswordField();
		passwordField.setBounds(95, 255, 130, 30);
		regiterTextField(passwordField);
		passwordField.setName("password");

		// Disable radio button bank or credit staffs based on user selection
		if (bankOrCreditSelected.equals("bankStaff")) {
			creditStaff.setEnabled(false);
			bankStaff.setSelected(true);
		} else {
			bankStaff.setEnabled(false);
			creditStaff.setSelected(true);
		}

		userFrame.add(title);
		userFrame.add(firstnameLabel);
		userFrame.add(lastnameLabel);
		userFrame.add(genderLabel);
		userFrame.add(ageLabel);
		userFrame.add(usernameLabel);
		userFrame.add(passwordLabel);
		userFrame.add(firstnameField);
		userFrame.add(lastnameField);
		userFrame.add(male);
		userFrame.add(female);
		userFrame.add(usernameField);
		userFrame.add(passwordField);
		userFrame.add(ageField);
		userFrame.add(bankStaff);
		userFrame.add(creditStaff);
		//exitButton = new JButton("Exit");

		//exitButton.setBounds(25, 250, 80, 25);
		// Defining Register Button
		registerButton = new JButton("Register");
		registerButton.setBounds(110, 300, 100, 25);
		// Defining Update Button
		//updateButton = new JButton("Update");
		//updateButton.setBounds(110, 285, 100, 25);
		//updateButton.setEnabled(false);
		// Defining Delete Button
		//deleteButton = new JButton("Delete");
		//deleteButton.setBounds(25, 285, 80, 25);
		//deleteButton.setEnabled(false);
		// Defining Reset Button
		//resetButton = new JButton("Reset");
		//resetButton.setBounds(60, 320, 100, 25);
		//resetButton.setEnabled(false);

		// fixing all Buttons
		// add(exitButton);
		userFrame.add(registerButton);
		// add(updateButton);
		// add(deleteButton);
		// add(resetButton);

		// Defining Panel
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.setBounds(250, 40, 480, 100);
		// panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
		userFrame.add(panel);

		panel.add(validationResultLbl);

		// Displaying Frame in Center of the Screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		userFrame.setLocation(dim.width / 2 - userFrame.getSize().width / 2,
				dim.height / 2 - userFrame.getSize().height / 2);

		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.setResizable(false);
		userFrame.setVisible(true);

		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				process(new BankStaff());

				if (bankStaff.isSelected()) {
					// new BankStaff();
					if (validationResultLbl.getText().equals("<html></html>")) {

						String fname = firstnameField.getText();
						String lname = lastnameField.getText();
						String gender = male.isSelected() ? "Male" : "Female";
						int age = Integer.parseInt(ageField.getText());
						String username = usernameField.getText();
						String password = passwordField.getText();

						BankStaff bs = new BankStaff();
						bs.setFname(fname);
						bs.setLname(lname);
						bs.setGender(gender);
						bs.setAge(age);
						bs.setUsername(username);
						bs.setPassword(password);

						StaffDataBase.addBankStaff(bs);
						userFrame.dispose();
					}
					
				} else if (creditStaff.isSelected()) {
					// new CreditStaff();
					if (validationResultLbl.getText().equals("<html></html>")) {

						String fname = firstnameField.getText();
						String lname = lastnameField.getText();
						String gender = male.isSelected() ? "Male" : "Female";
						int age = Integer.parseInt(ageField.getText());
						String username = usernameField.getText();
						String password = passwordField.getText();

						CreditStaff cs = new CreditStaff();
						cs.setFname(fname);
						cs.setLname(lname);
						cs.setGender(gender);
						cs.setAge(age);
						cs.setUsername(username);
						cs.setPassword(password);

						StaffDataBase.addCreditStaff(cs);
						userFrame.dispose();
						
					}
				}
				

				// new UserLoginController();
				// }
			}
		});

	}

}
