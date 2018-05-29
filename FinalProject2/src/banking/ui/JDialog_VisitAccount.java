/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.ui;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class JDialog_VisitAccount  extends JDialog{
    
    private BankFrm mainFrame;
    public JDialog_VisitAccount(BankFrm mainFrame){
        this.mainFrame=mainFrame;
        getContentPane().setBackground(new Color(95,95,95));   
              setTitle("Visit Customer Account");
		setModal(true);    //block input to other window            
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
                
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);                
		JLabel1.setForeground(java.awt.Color.white);
		JLabel1.setBounds(12,12,48,24);
                
		
//		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
                
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
                
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
                
	
		//}}
//	    JTextField_NAME.setText(accnr);
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
        
        class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
        mainFrame.visitaccnum=JTextField_NAME.getText();
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}
    
    
}
