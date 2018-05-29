/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.ui;

import banking.factory.entity.BankAccountType;
import framework.entity.Account;
import framework.observer.Observable;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author USER
 */
public class JDialog_SendEmail extends JDialog {
    
    BankFrm parentframe;
    
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_From = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_To = new javax.swing.JTextField();
         JTextArea textArea=new JTextArea();
         
        
        
        
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
        JScrollPane scrollPane=new JScrollPane();
	// }}
    
    
    public JDialog_SendEmail(BankFrm parentframe){
        this.parentframe=parentframe;
        setTitle("Send Email");
        
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		getContentPane().setBackground(new Color(95,95,95));
		setVisible(false);
//		
		JRadioButton_Sav.setBounds(36, 24, 84, 24);
		JLabel1.setText("From : ");
		
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.white);
		JLabel1.setBounds(20, 20, 48, 24);
                
               
		
		JTextField_From.setBounds(78, 20, 156, 20);
                JTextField_From.setEnabled(false);
                JTextField_From.setText("Bank of America");
                getContentPane().add(JTextField_From);
                
                
                JLabel2.setBounds(20,54,48,24);
                JLabel2.setText("To");
                JLabel2.setForeground(java.awt.Color.white);
                getContentPane().add(JLabel2);
                
                JTextField_To.setBounds(78,54,156,20);
                JTextField_To.setEnabled(false);
                JTextField_To.setText("Bank Customers");
                getContentPane().add(JTextField_To);
                
                
                textArea.setBounds(20,94,540,130);
                scrollPane.setBounds(20,94,540,130);
                scrollPane.getViewport().add(textArea);
                
                 getContentPane().add(scrollPane);
                
                

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 264, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 264, 84, 24);
//		
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		// When Checking radio is clicked make this radio on
		// and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		// When Saving radio is clicked make this radio on
		// and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		String emailContent= textArea.getText();
		
                   Observable obsrv=new Observable(parentframe.accountService);
                   obsrv.setEmail(emailContent);
                   System.out.println("JDIalog_SendMail"+emailContent);
//                parentframe.accountService.getAccount("11").setEmail(emailContent); 
                          
                
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}
}
