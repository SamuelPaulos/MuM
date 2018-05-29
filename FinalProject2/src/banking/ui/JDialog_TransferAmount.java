/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.ui;

import banking.factory.entity.BankAccountFactory;
import banking.factory.entity.BankAccountType;
import framework.entity.Account;
import framework.factory.entity.AccountType;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class JDialog_TransferAmount extends JDialog{
    private BankFrm parentFrame;
    
                public JDialog_TransferAmount(BankFrm parentFrame){
                    this.parentFrame=parentFrame;    
                    
                setTitle("Money Transfer");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(200,200);
		setVisible(false);
		getContentPane().setSize(200, 500);
		getContentPane().setBackground(new Color(95,95,95));
                
		JLabel1.setText("Tarnsfer from Account ");
                JLabel1.setForeground(java.awt.Color.white);		
                JLabel1.setBounds(12,12,150,24);
                getContentPane().add(JLabel1);
                
		
                sRadioBut.setText("SAVING");
                sRadioBut.setForeground(java.awt.Color.white);
                sRadioBut.setBackground(new Color(95,95,95));
                sRadioBut.setBounds(12,46,90,24);
                getContentPane().add(sRadioBut);
                
                cRadioBut.setText("CHECKING");
                cRadioBut.setForeground(java.awt.Color.white);
                cRadioBut.setBackground(new Color(95,95,95));
		cRadioBut.setBounds(100,46,90,24);
                getContentPane().add(cRadioBut);
		
                acctNumLb.setText("Account Number");
                acctNumLb.setForeground(java.awt.Color.white);
                acctNumLb.setBounds(12,80,90,24);
                getContentPane().add(acctNumLb);
                
                accText.setBounds(112,80,150,24);
                 getContentPane().add(accText);
                 
                 toAccLbl.setText("To");
                 toAccLbl.setForeground(java.awt.Color.white);
                 toAccLbl.setBounds(12,114,50,24);
                 getContentPane().add(toAccLbl);
                  
                  toSRadioBut.setText("SAVING");
                  toSRadioBut.setForeground(java.awt.Color.white);
                  toSRadioBut.setBackground(new Color(95,95,95));
                  toSRadioBut.setBounds(12,148,90,24);
                  getContentPane().add(toSRadioBut);
                  
                   toCRadioBut.setText("CHECKING");
                   toCRadioBut.setForeground(java.awt.Color.white);
                   toCRadioBut.setBackground(new Color(95,95,95));
                  toCRadioBut.setBounds(112,148,112,24);
                  getContentPane().add(toCRadioBut);
                  
                  toAccNumber.setText("Account Number");
                  toAccNumber.setForeground(java.awt.Color.white);
                  toAccNumber.setBounds(12,182,90,24);
                  getContentPane().add(toAccNumber);
                  
                  
                  toAccNum.setForeground(java.awt.Color.white);
                  toAccNum.setBounds(112,182,150,24);
                  getContentPane().add(toAccNum);
                   getContentPane().add(toAccNum);
                  
                   tranferLabel.setForeground(java.awt.Color.white);
                 tranferLabel.setBounds(12,216,90,24);
                 getContentPane().add(tranferLabel);
                 
              
                         transferText.setBounds(112,216,150,24);
                       getContentPane().add(transferText);
                 
		
	       JButton_transfer.setText("Transfer");
		getContentPane().add(JButton_transfer);
		JButton_transfer.setBounds(36,255,84,24);
                
		JButton_Cancel.setText("Cancel");
//		JButton_Cancel.setActionCommand("Cancel");
	
		JButton_Cancel.setBounds(135,255,84,24);
                getContentPane().add(JButton_Cancel);
//                
//		getContentPane().add(JTextField_Deposit);
//		JTextField_Deposit.setBounds(84,48,144,24);
		//}}
//	    JTextField_NAME.setText(accnr);
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_transfer.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_transfer = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
	//}}
                 JRadioButton sRadioBut=new JRadioButton();
                 JRadioButton cRadioBut=new JRadioButton();
                 
                 JRadioButton toSRadioBut=new JRadioButton();
                 JRadioButton toCRadioBut=new JRadioButton();
                 
                 JLabel acctNumLb=new JLabel();
                 JLabel toAccLbl=new JLabel();
                 JTextField accText=new JTextField();
                 JTextField toAccNum=new JTextField();
                 JLabel toAccNumber=new JLabel();
                 
                 JLabel tranferLabel=new JLabel("Transfer Amount");
              //   tranferLabel.setForeground(java.awt.Color.white);
                 
                 JTextField transferText=new JTextField();
                 

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_transfer)
				JButtonTransfer_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonTransfer_actionPerformed(java.awt.event.ActionEvent event)
	{
//        parentFrame.amountDeposit=JTextField_Deposit.getText();
		
               AccountType fromType=BankAccountType.CHECKING;
               AccountType toType=BankAccountType.CHECKING;
               
               if(sRadioBut.isSelected()){
                   fromType=BankAccountType.SAVING;
               }              
               
               if(toSRadioBut.isSelected()){
                   toType=BankAccountType.SAVING;
               }
              
               if(!transferText.getText().isEmpty()&&!accText.getText().isEmpty()&&!toAccNum.getText().isEmpty()){
               BankAccountFactory toBnkAcc=new BankAccountFactory();
               Account toAccount=toBnkAcc.createAccount(toType);
               toAccount.setAccountNumber(toAccNum.getText());
               toAccount.setAccountType(toType);
               
        
               BankAccountFactory fromBnkAcc=new BankAccountFactory();
                Account fromAccount=fromBnkAcc.createAccount(fromType);
                fromAccount.setAccountNumber(accText.getText());
                fromAccount.setAccountType(fromType);
                
            
              parentFrame.transferAmount= Double.parseDouble(transferText.getText());   
                   parentFrame.source=fromAccount;
                   parentFrame.destination=toAccount;
                }
                else{
                    System.out.println("Enter all the fields");
                }
                
                
                
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}