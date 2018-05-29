package ui.loginForm;

import java.io.IOException;

import javax.swing.JOptionPane;

import banking.ui.BankFrm;
import creditCard.ui.CardFrm;
import framework.dao.StaffDataBase;
import framework.entity.Staff;
import framework.iterator.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserLoginController extends Application {

	private static Stage primaryStage;
	private static AnchorPane mainLayout;
	private String staffType;
	
	@FXML
	private Label lblBankCreditSelectionResult;

	@FXML
	private RadioButton rdBank;

	@FXML
	private RadioButton rdCredit;

	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField txtPassword;

	String bankOrCreditSelected = "bankStaff";

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login Form");
		showMainView();
	}

	// Displays the Login form
	public void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserLoginController.class.getResource("LoginForm.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void rdBankSelected() {
		lblBankCreditSelectionResult.setText("Bank Login Form");
		bankOrCreditSelected = "bankStaff";

	}

	public void rdCreditSelected() {
		lblBankCreditSelectionResult.setText("Credit Login Form");
		bankOrCreditSelected = "creditStaff";
	}

	// For Login
	public void btnLoginActionListener(ActionEvent e) {
		boolean validStaff = false;
		if (rdBank.isSelected()) {
			staffType = "bankStaff";
			if (authenticateBankStaff()) {
				new BankFrm().bankMain();
				primaryStage.close();
				validStaff = true;
			}

		} else if (rdCredit.isSelected()) {
			staffType = "creditStaff";
			if (authenticateCreditStaff()) {
				new CardFrm().creditMain();
				primaryStage.close();
				validStaff = true;
			}
		}
		
		if (!validStaff){
			
			JOptionPane.showMessageDialog(null, "Invalid UserName or Password", "Login Failed",
					JOptionPane.WARNING_MESSAGE);
			
		}
	}

	private boolean authenticateBankStaff() {

		String userName = txtUserName.getText();
		String password = txtPassword.getText().toString();
		boolean authenticated = false;
		
		Iterator staffIterator = StaffDataBase.getStaffDBInstance().getIterator(staffType);
		
		while(staffIterator.hasNext()){
			Staff bs = staffIterator.next();
			
			if (userName.equals(bs.getUsername()) && password.equals(bs.getPassword())) {
				authenticated = true;
				break;
			} 
		}

		return authenticated;
	}

	// Authentication for credit staff
	private boolean authenticateCreditStaff() {

		String userName = txtUserName.getText();
		String password = txtPassword.getText().toString();
		boolean authenticated = false;
		
		Iterator staffIterator = StaffDataBase.getStaffDBInstance().getIterator(staffType);

		while(staffIterator.hasNext()){
			Staff bs = staffIterator.next();
			
			if (userName.equals(bs.getUsername()) && password.equals(bs.getPassword())) {
				authenticated = true;
				break;
			} 
		}

		
		return authenticated;
	}

	// For signing up a staff
	public void btnRegisterStaffActionListener(ActionEvent e) {
		new UserRegistration(bankOrCreditSelected);

	}

	// Exit the system on click of cancel button
	public void btnCancelActionListener(ActionEvent e) {
		System.exit(0);
	}

}
