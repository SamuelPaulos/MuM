package banking.ui;

import java.awt.Color;
import java.awt.TextArea;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.entity.Account;
import framework.entity.AccountEntry;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;
import javax.swing.JLabel;

public class JDialog_Transaction extends JDialog {

	private AccountService accountService = ServiceFactory.createAccountService();
	JScrollPane JScrollPane1;
	DefaultTableModel model;
	JTable JTable1;
	
	private BankFrm parentFrame;
    private Object row[];
	public JDialog_Transaction(BankFrm parentFrame,String accnr) {
		this.parentFrame = parentFrame;
		getContentPane().setBackground(new Color(95,95,95));
		setTitle("Tansaction");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268, 126);
		setVisible(false);
		
	   JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		row=new Object[4];
		
                
		model.addColumn("AccountType");
		model.addColumn("Amount");
		model.addColumn("Description");
		model.addColumn("Date");
		
		//model.addColumn("Amount");
		JTable1.setBounds(0, 0, 370, 0);
		//rowdata = new Object[8];
		JScrollPane1.getViewport().add(JTable1);
		//JScrollPane1.add(JTable1);
		JScrollPane1.setBounds(30,60,500,150);
		
		getContentPane().add(JScrollPane1);
		JLabel label=new JLabel();
                label.setBounds(30,15,250,43);
               label.setText("Account Number :"+accnr);
               
               getContentPane().add(label);
		Account account=accountService.getAccount(accnr);
        List<AccountEntry> transactions=account.getAccountEntries();
         
        for(AccountEntry a: transactions){
                
        	row[0]=account.getAccountType();
        	row[1]=a.getAmount();
        	row[2]=a.getDescription();
        	row[3]=a.getDate();
        
        	model.addRow(row);
        }

	}

}
