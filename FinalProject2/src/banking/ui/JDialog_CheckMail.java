/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package banking.ui;

import framework.entity.Account;
import framework.observer.Observable;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JDialog_CheckMail extends JDialog {
    
    Account account;
    
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
       
        
          JTextField JTextField_date = new JTextField();
          
         JTextField JTextField_subject = new JTextField();
         JTextArea textArea=new JTextArea();
         
        
        
       
        JScrollPane scrollPane=new JScrollPane();
	// }}
    public JDialog_CheckMail(Account account){
        this.account=account;
        
      setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setVisible(false);
//		
		JRadioButton_Sav.setBounds(36, 24, 84, 24);
		JLabel1.setText("From : ");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(20, 20, 48, 24);
                
               
		
		JTextField_From.setBounds(78, 20, 156, 24);
                JTextField_From.setEnabled(false);
                JTextField_From.setText("Bank of America");
                getContentPane().add(JTextField_From);
                
                
                JLabel2.setBounds(20,54,48,24);
                JLabel2.setText("To");
                getContentPane().add(JLabel2);
                
                
                
                
                
                
                JTextField_To.setBounds(78,54,156,24);
                JTextField_To.setEnabled(false);
                JTextField_To.setText(account.getCustomer().getName());  // replace with email
                getContentPane().add(JTextField_To);
                
                JLabel3.setText("Date :");
                JLabel3.setBounds(20,88,48,24);
                getContentPane().add(JLabel3);          
                
                JTextField_date.setBounds(78,88,156,24);
                JTextField_date.setText("date");
                JTextField_date.setEnabled(false);
                getContentPane().add(JTextField_date);
                
                
                JLabel4.setText("Subject :");
                JLabel4.setBounds(20,122,48,24);
                getContentPane().add(JLabel4);
                
                JTextField_subject.setBounds(78,122,156,24);
                JTextField_subject.setText("Subject");
                JTextField_subject.setEnabled(false);
                getContentPane().add(JTextField_subject);
                
                
                
                
                
                textArea.setBounds(20,160,540,160);
                scrollPane.setBounds(20,160,540,130);
                scrollPane.getViewport().add(textArea);
                textArea.setText(account.getEmail());
                 getContentPane().add(scrollPane);
                
                
    }
}
