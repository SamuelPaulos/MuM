package creditCard.ui;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import creditCard.factory.entity.CreditAccountFactory;
import creditCard.factory.entity.CreditAccountType;
import framework.entity.Account;
import framework.entity.Address;
import framework.entity.Customer;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;
import framework.factory.entity.CustomerFactory;
import framework.factory.entity.CustomerType;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;
import framework.service.AccountServiceInvoker;

/**
 * A basic JFC based application.
 */

public class CardFrm extends javax.swing.JFrame {

	private AccountService accountService = ServiceFactory.createAccountService();
	private AccountServiceInvoker accountServiceInvoker = ServiceFactory.createInvokerService();
	private AccountFactory accountFactory = new CreditAccountFactory();

	/****
	 * init variables in the object
	 ****/
	AccountType accountType;
	String clientName, street, city, zip, state, amountDeposit, amountWithdraw, expdate, ccnumber;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	CardFrm thisframe;
	private Object rowdata[];

	public CardFrm() {
		thisframe = this;

		setTitle("Credit-card processing Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(600, 350);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[7];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);

		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	// static public void main(String args[]) {
	static public void creditMain() {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new CardFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 400);
		ccac.show();

		if (newaccount) {

			Account account = accountFactory.createAccount(accountType);

			// set initial balance
			if (accountType.equals(CreditAccountType.BRONZE))
				account.setBalance(500.0);
			else if (accountType.equals(CreditAccountType.SILVER))
				account.setBalance(1000.0);
			else if (accountType.equals(CreditAccountType.GOLD))
				account.setBalance(1500.0);

			account.setAccountNumber(ccnumber);

			Customer customer = CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
			// customer.setId(id);
			customer.setName(clientName);
			// customer.setBirthDate(birthDate);
			// customer.setEmail(email);

			Address address = new Address();
			address.setCity(city);
			address.setZip(zip);
			address.setState(state);
			address.setStreet(street);

			customer.setAddress(address);
			account.setCustomer(customer);

			// Calling the invoker method
			accountServiceInvoker.createAccount(account);
			newaccount = false;
			refreshRows();
		}

	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		JDialogGenBill billFrm = new JDialogGenBill();
		billFrm.setBounds(450, 20, 465, 600);
		billFrm.show();
		refreshRows();
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			String ccnr = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(thisframe, name);
			dep.setBounds(430, 15, 280, 160);
			dep.show();

			// compute new amount
			long deposit;
			if (amountDeposit == null || amountDeposit.trim().equals("")) {
				deposit = 0;
			} else {
				deposit = Long.parseLong(amountDeposit);
			}

			// Calling the invoker method
			accountServiceInvoker.deposit(ccnr, Double.valueOf(deposit));
			amountDeposit = "0";
			refreshRows();
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();

		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			String ccnr = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, name);
			wd.setBounds(430, 15, 280, 160);
			wd.show();

			// compute new amount

			long withdraw;
			if (amountWithdraw == null || amountWithdraw.trim().equals("")) {
				withdraw = 0;
			} else {
				withdraw = Long.parseLong(amountWithdraw);
			}

			// Calling the invoker method
			accountServiceInvoker.withdraw(ccnr, Double.valueOf(withdraw));

			double newAmount = accountService.getAccount(ccnr).getBalance();
			if (newAmount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" " + name + " Your balance is negative: $" + String.valueOf(newAmount) + " !",
						"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
			}

			amountWithdraw = "0";
			refreshRows();
		}

	}

	// Updating the DefaultTableModel (Display)
	public void refreshRows() {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}

		Iterator<Account> accountIterator = accountService.accountIterator();
		Account data;

		while (accountIterator.hasNext()) {

			data = accountIterator.next();

			// add row to table
			rowdata[0] = data.getCustomer().getName();
			rowdata[1] = data.getAccountNumber();
			rowdata[2] = expdate;

			if (data.getClass().getSimpleName().equals("BronzeCreditAccount"))
				rowdata[3] = "BRONZE";
			else if (data.getClass().getSimpleName().equals("SilverCreditAccount"))
				rowdata[3] = "SILVER";
			else if (data.getClass().getSimpleName().equals("GoldCreditAccount"))
				rowdata[3] = "GOLD";

			DecimalFormat df = new DecimalFormat("#.00");

			// needed to be converted to float
			rowdata[4] = Float.parseFloat(df.format(data.getBalance()));

			model.addRow(rowdata);
		}
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

}
