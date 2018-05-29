package banking.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import banking.factory.entity.BankAccountFactory;
import banking.report.PdfFromXmlFile;
import framework.entity.Account;
import framework.entity.Address;
import framework.entity.Company;
import framework.entity.Customer;
import framework.entity.Individual;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;
import framework.factory.entity.CustomerFactory;
import framework.factory.entity.CustomerType;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;
import net.sf.jasperreports.engine.JRException;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A basic JFC based application.
 */
public class BankFrm extends javax.swing.JFrame {
	
	 AccountService accountService = ServiceFactory.createAccountService();
	AccountFactory accountFactory = new BankAccountFactory();
	
	/*
	 * init variables in the object
	 */
	AccountType accountType;
	String accountnr,visitaccnum, clientName, street, city, zip, state, clientType, amountDeposit;
        Account source,destination;
        double transferAmount;
	boolean newaccount;
        boolean undoOperations;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
        private JButton checkMailButton;
	BankFrm myframe;
	private Object rowdata[];       
        
           JPanel JPanel1 = new JPanel();
           JPanel panel2=new JPanel();
           JPanel  panel3=new JPanel();
           
           
	   JButton JButton_PerAC = new JButton();
	JButton JButton_CompAC = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Addinterest = new JButton();
	JButton JButton_Exit = new JButton();
        
        JButton transactionBut=new JButton();
        JButton accountsBut=new JButton();
        JButton undoBut=new JButton();
        JButton redoBut=new JButton();
        JButton transferBut=new JButton();
        JButton sendEmail=new JButton("Send Mail");
        JButton complaintsButton=new JButton("Complaint Report");
        JButton reportButton=new JButton("Generate Report");
  
//        JButton sendEmail=new JButton("Send Mail");
        Box vbox=Box.createVerticalBox();
        
       public  void mouthHover(JButton jbt){
    	   jbt.setForeground(java.awt.Color.white);
           
    	   jbt.setBackground(new Color(95,95,95));
    	   jbt.setContentAreaFilled(false);
    	   jbt.setOpaque(true);
    	   jbt.setFont(new Font("Arial",Font.PLAIN,20));
    	   jbt.addMouseListener(new java.awt.event.MouseAdapter() {
   		    public void mouseEntered(java.awt.event.MouseEvent evt) {
   		    	jbt.setBackground(Color.white);
   		    	jbt.setForeground(java.awt.Color.black);
   		    }

   		    public void mouseExited(java.awt.event.MouseEvent evt) {
   		    	jbt.setBackground(new Color(95,95,95));
   		    	jbt.setForeground(java.awt.Color.white);
   		    }
   		});}
       public  void mouthHoverbar(JButton jbt){
    	   jbt.setForeground(java.awt.Color.black);
           
    	   jbt.setBackground(Color.WHITE);
    	   jbt.setContentAreaFilled(false);
    	   jbt.setOpaque(true);
    	   jbt.setFont(new Font("Arial",Font.PLAIN,20));
    	   jbt.addMouseListener(new java.awt.event.MouseAdapter() {
   		    public void mouseEntered(java.awt.event.MouseEvent evt) {
   		    	jbt.setBackground(new Color(95,95,95));
   		    	jbt.setForeground(java.awt.Color.white);
   		    }

   		    public void mouseExited(java.awt.event.MouseEvent evt) {
   		    	jbt.setBackground(Color.white);
   		    	jbt.setForeground(java.awt.Color.black);
   		    }
   		});}

	public BankFrm() {
		myframe = this;

		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		//getContentPane().setLayout(new BorderLayout());
		getContentPane().setLayout(null);
		setSize(1920, 1080);
		setVisible(false);
//                setResizable(false);
//		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
//		JPanel1.setBounds(150, 70, 575, 310);
		JPanel1.setBounds(130, 90, 1900, 700);
		panel2.setBackground(new Color(0,0,0));
		JPanel1.setBackground(new Color(241,241,241));
                
//               panel2.setLayout(null);
               getContentPane().add(BorderLayout.NORTH, panel2);
//               panel2.setBounds(0, 0, 575, 310);
               panel2.setBounds(0, 5, 1900, 50);
                
		/*
		 * /Add buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
                
                 checkMailButton=new JButton("Check Mail");
//                 checkMailButton.setForeground(java.awt.Color.white);
//                 
//                 checkMailButton.setBackground(new Color(95,95,95));
//                 checkMailButton.setContentAreaFilled(false);
//                 checkMailButton.setOpaque(true);
                 
//                 (JButton jbt){
//                 checkMailButton.addMouseListener(new java.awt.event.MouseAdapter() {
//        		    public void mouseEntered(java.awt.event.MouseEvent evt) {
//        		    	checkMailButton.setBackground(Color.white);
//        		    	checkMailButton.setForeground(java.awt.Color.black);
//        		    }
//
//        		    public void mouseExited(java.awt.event.MouseEvent evt) {
//        		    	checkMailButton.setBackground(new Color(95,95,95));
//        		    	checkMailButton.setForeground(java.awt.Color.white);
//        		    }
//        		})}
                 mouthHover(checkMailButton);
                 
                 Dimension buttonDimension=checkMailButton.getMaximumSize();
                 
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
                
		JTable1 = new JTable(model);
		model.addColumn("AccountNumber");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("Personal/Company");
		model.addColumn("Checking/Saving");
		model.addColumn("Amount");
		//model
		rowdata = new Object[8];
		newaccount = false;
                undoOperations=false;
                 

		JPanel1.add(JScrollPane1);
		//ScrollPane1.setBounds(20, 20, 800, 600);
		JScrollPane1.setPreferredSize(new Dimension(1300,600));
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 1300, 600);
		// rowdata = new Object[8];
		Color blk = new Color(95, 95, 95);
		JTable1.setOpaque(true);
		JTable1.setFillsViewportHeight(true);
		JTable1.setBackground(blk);
		JTable1.setSize(800, 600);
		JTable1.setForeground(Color.white);
		JTable1.setRowHeight(24);
		JTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 22));
		JTable1.setFont(new Font("Arial", Font.BOLD, 20));
                
                JTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (JTable1.rowAtPoint(e.getPoint()) == -1) {
                    JTable1.getSelectionModel().clearSelection();
                     JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
                      JTable1.getSelectionModel().setLeadSelectionIndex(-1);
                }
            }
        });
			

		JButton_PerAC.setText("Add personal account");
		panel2.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		mouthHoverbar(JButton_PerAC);
		//JButton_PerAC.setFont(new Font("Arial",Font.PLAIN,18));
		
//		JButton_PerAC.setBackground(Color.BLACK);
//		JButton_PerAC.setContentAreaFilled(false);
//		JButton_PerAC.setOpaque(true);
		//JButton_PerAC.setForeground(Color.);
//		JButton_PerAC.addMouseListener(new java.awt.event.MouseAdapter() {
//		    public void mouseEntered(java.awt.event.MouseEvent evt) {
//		    	JButton_PerAC.setBackground(Color.white);
//		    }
//
//		    public void mouseExited(java.awt.event.MouseEvent evt) {
//		    	JButton_PerAC.setBackground(UIManager.getColor("control"));
//		    }
//		});
                
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		mouthHoverbar(JButton_CompAC);       
		panel2.add(JButton_CompAC);
		
		//JButton_CompAC.setFont(new Font("Arial",Font.PLAIN,18));
		JButton_CompAC.setBounds(240, 20, 192, 33);
                
                //////JPanel1///////////////////
                
                
                JButton_Withdraw.setText("Withdraw");
//      Dimension dimForJButton_Withdraw=JButton_Withdraw.getPreferredSize();
      
      JButton_Withdraw.setMaximumSize(buttonDimension);
      mouthHover(JButton_Withdraw);
//      JButton_Withdraw.setForeground(java.awt.Color.white);
//      JButton_Withdraw.setBackground(new Color(95,95,95));
//      JButton_Withdraw.setFont(new Font("Arial",Font.PLAIN,20));
                  
		JButton_Deposit.setText("Deposit");
		
	
		JButton_Deposit.setMaximumSize(buttonDimension);
		mouthHover(JButton_Deposit);
//		JButton_Deposit.setForeground(java.awt.Color.white);
//		JButton_Deposit.setBackground(new Color(95,95,95));
//		JButton_Deposit.setFont(new Font("Arial",Font.PLAIN,20));
//                JButton_Deposit.setPreferredSize(dimForJButton_Withdraw);
  
                      vbox.add(checkMailButton);
                       vbox.add(Box.createRigidArea(new Dimension(30,10)));
                
		    vbox.add(JButton_Deposit);    
                    vbox.add(Box.createRigidArea(new Dimension(30,10)));
                    vbox.add(JButton_Withdraw);
                    vbox.add(Box.createRigidArea(new Dimension(30,10)));    
		
		JButton_Exit.setText("Exit");

		JButton_Exit.setMaximumSize(buttonDimension);
		mouthHover(JButton_Exit);
//		JButton_Exit.setForeground(java.awt.Color.white);
//		JButton_Exit.setBackground(new Color(95,95,95));
//		JButton_Exit.setFont(new Font("Arial",Font.PLAIN,20));
		
//                 JButton_Exit.setPreferredSize(dimForJButton_Withdraw);
                 
                vbox.add(JButton_Exit);
                  vbox.add(Box.createRigidArea(new Dimension(30,10)));
               
                  JPanel1.add(Box.createRigidArea(new Dimension(15,10)));
                JPanel1.add(vbox);
                
                
                JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		mouthHoverbar(JButton_Addinterest);
		//JButton_Addinterest.setFont(new Font("Arial",Font.PLAIN,20));
		panel2.add(JButton_Addinterest);
      //////////////////////////////////////// Extra  Features ////////////////////   
                transactionBut.setText("Transaction");
                transactionBut.setBounds(570,20,100,33);
                mouthHoverbar(transactionBut);
               // transactionBut.setFont(new Font("Arial",Font.PLAIN,20));
                panel2.add(transactionBut);
               
                accountsBut.setText("Visit Personal Account");
                mouthHoverbar(accountsBut);
               // accountsBut.setFont(new Font("Arial",Font.PLAIN,20));
                accountsBut.setBounds(686,20,120,33);
                panel2.add(accountsBut);
                
                transferBut.setText("Transfer Funds");
                mouthHoverbar(transferBut);
                //transferBut.setFont(new Font("Arial",Font.PLAIN,20));
                transferBut.setBounds(822,20,120,33);
                panel2.add(transferBut);
                
                 undoBut.setText("Undo");
                 mouthHoverbar(undoBut);
               //  undoBut.setFont(new Font("Arial",Font.PLAIN,20));
                undoBut.setBounds(958,20,60,33);
                panel2.add(undoBut);
                
                 redoBut.setText("Redo");
                 mouthHoverbar(redoBut);
                // redoBut.setFont(new Font("Arial",Font.PLAIN,20));
                redoBut.setBounds(1034,20,60,33);
                panel2.add(redoBut);
                
                
              
                sendEmail.setBounds(1110,20,75,33);
                mouthHoverbar(sendEmail);
               // sendEmail.setFont(new Font("Arial",Font.PLAIN,20));
                panel2.add(sendEmail);
                mouthHoverbar(reportButton);
               // reportButton.setFont(new Font("Arial",Font.PLAIN,20));
                reportButton.setBounds(1280, 20, 80, 33);
                panel2.add(reportButton);
                mouthHoverbar(complaintsButton);
              //  complaintsButton.setFont(new Font("Arial",Font.PLAIN,20));
                complaintsButton.setBounds(1190,20,80,33);
                panel2.add(complaintsButton);
                
                
                
		
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
                
                accountsBut.addActionListener(lSymAction);
                undoBut.addActionListener(lSymAction);
                redoBut.addActionListener(lSymAction);
                transferBut.addActionListener(lSymAction);
                transactionBut.addActionListener(lSymAction);
                sendEmail.addActionListener(lSymAction);
                checkMailButton.addActionListener(lSymAction);
                reportButton.addActionListener(lSymAction);
                complaintsButton.addActionListener(lSymAction);
	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	//static public void main(String args[]) {
		public static void bankMain() {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new BankFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	

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
			if (object == BankFrm.this)
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
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
                        
                        else if(object==accountsBut)
                             accountsActionPerformed(event);
                        else if(object==undoBut)
                            undoButtonActionPerformed(event);
                        
                        else if(object==redoBut)
                            redoundoButtonActionPerformed(event);
                        else if(object==transferBut)
                            transferButtonActionPerformed(event);
                        else if(object==transactionBut)
                            transactionbuttonActionPerformed(event);
                        else if(object==sendEmail)
                            sendEmailToAllCustomers(event);
                        
                        else if(object==checkMailButton){
                            checkMailActionPerformed(event);
                        }
                        else if(object==reportButton){
                        	reportActionPerformed(event);
                        	}
                        else if(object==complaintsButton){
                            complaintsActionPerformed(event);
                        }

		}
	}
	
	 public void complaintsActionPerformed(ActionEvent ae){
         JDialog_Complaints complaints_Dialog=new JDialog_Complaints(this);
         
          complaints_Dialog.setAlwaysOnTop(true);
		complaints_Dialog.setBounds(200, 20, 600, 350);
             complaints_Dialog.setResizable(false);
		complaints_Dialog.show();     
         
         
     }
	public void reportActionPerformed(ActionEvent ae){
	
		PdfFromXmlFile report=new PdfFromXmlFile();
		
		try {
			report.generateReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
        
        
	 public void checkMailActionPerformed(ActionEvent ae){
         
         
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >= 0) {
				String accnr = (String) model.getValueAt(selection, 0);
	                        
	                       JDialog_CheckMail checkMail=new JDialog_CheckMail(accountService.getAccountHashmap(accnr));
	                        
	                       
	                checkMail.setAlwaysOnTop(true);
			checkMail.setBounds(200, 20, 600, 350);
	                checkMail.setResizable(false);
			checkMail.show();          
	                        System.out.println( accountService.getAccountHashmap(accnr).getEmail()+
	                        ""+"Email has been recieved");
	                }
	                        
	            
	        }
                
                
        public void sendEmailToAllCustomers(ActionEvent ae){
            
            
            
            JDialog_SendEmail sendemail=new JDialog_SendEmail(this);
                            
                sendemail.setAlwaysOnTop(true);
		sendemail.setBounds(200, 20, 600, 400);
		sendemail.show();          
                
            
                
                
        }
        
        public void transactionbuttonActionPerformed(ActionEvent event) {
		
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
		
		

		JDialog_Transaction trfAmt = new JDialog_Transaction(this,accnr);
		trfAmt.setAlwaysOnTop(true);
		trfAmt.setBounds(200, 20, 600, 300);
		trfAmt.show();

	}
                
        }
        
        public void transferButtonActionPerformed(ActionEvent event){
            JDialog_TransferAmount trfAmt=new JDialog_TransferAmount(this);
            trfAmt.setAlwaysOnTop(true);
             trfAmt.setBounds(825,50,400,360);
             trfAmt.setResizable(false);
             trfAmt.show();
//            trfAmt.pack();
//            trfAmt.setVisible(true);
        accountService.transferFunds(source, destination, transferAmount);



        }
        
        
       public void  accountsActionPerformed(ActionEvent event){
           
           JDialog_VisitAccount visitAcc=new JDialog_VisitAccount(this);
                  visitAcc.setBounds(200,50,300,200);
                  visitAcc.show();
                  
                  String accnum=visitaccnum;
                  
                  if(!accnum.isEmpty()){
                      
                      //assuming saving and checking account are in the same table in database
                  Account account=accountService.getAccount(accnum);
                  
                  for(int i=model.getRowCount()-1;i>=0;i--){
                      model.removeRow(i);
                  }
                  
                  rowdata[0]=account.getAccountNumber();
                   rowdata[1]=account.getCustomer().getName();
                   rowdata[2]=account.getCustomer().getAddress().getCity();
                    String customerType="";
                            if(account.getCustomer() instanceof Individual){
                                customerType="P";
                            }
                            else if( account.getCustomer() instanceof Company) {
                                customerType="C";
                            }
                   rowdata[3]=customerType;
                   rowdata[4]=account.getAccountType();
                   rowdata[5]=account.getBalance();
                   
                   model.addRow(rowdata);
                         
                    
                   
                      
                  }
           
       }
     

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}
        
         public void undoButtonActionPerformed(ActionEvent event){               
              
               String accNUM=accountService.undoCommand();
                  
               if(!accNUM.isEmpty()){
               Account account= accountService.getAccount(accNUM);
               System.out.println("Number of rows"+ model.getRowCount());  
               
               //modify the row
               model.removeRow(model.getRowCount()-1);

                   rowdata[0]=account.getAccountNumber();
                   rowdata[1]=account.getCustomer().getName();
                   rowdata[2]=account.getCustomer().getAddress().getCity();
                    String customerType="";
                            if(account.getCustomer() instanceof Individual){
                                customerType="P";
                            }
                            else if( account.getCustomer() instanceof Company) {
                                customerType="C";
                            }
                   rowdata[3]=customerType;
                   rowdata[4]=account.getAccountType();
                   rowdata[5]=account.getBalance();
                   
                   model.addRow(rowdata);
                   
               }

          
                }
         
         public void redoundoButtonActionPerformed(ActionEvent event){
             
            String accnumber=accountService.redoCommand();
            
            if(!accnumber.isEmpty()){
            Account account= accountService.getAccount(accnumber);
            Object redoRow[];
            redoRow = new Object[6];
            
              //search for the accnumber In JTable rows
              double amt;
                 System.out.println(model.getRowCount());
                 
              for(int i=0; i<model.getRowCount();i++){                  
                  
                  if(((String)model.getValueAt(i,0)).equalsIgnoreCase(accnumber)){
                       
                        model.setValueAt(String.valueOf(account.getBalance()), i, 5);
                        System.out.println("successfully added to the row");
                        break;
                  }
                  
              }
            
            }
            
             
         }

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(200, 20, 400, 450);
		pac.setBackground(new Color(95,95,95));
		pac.show();
                  
                   
		if (newaccount ) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "P";  //customer type
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
                        
                         JTable1.getSelectionModel().setAnchorSelectionIndex(-1);			
			
//			Account account = accountFactory.createAccount(accountType);
//			account.setAccountNumber(accountnr);
//                        
//			Customer customer = CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
//			//customer.setId(id);
//			customer.setName(clientName);
//			//customer.setBirthDate(birthDate);
//			//customer.setEmail(email);
//			
//			Address address = new Address();
//			address.setCity(city);
//			address.setZip(zip);
//			address.setState(state);
//			address.setStreet(street);
			
//			customer.setAddress(address);
//			account.setCustomer(customer);
//                      account.setAccountType(accountType);
			
			//accountService.createAccount(account);
			newaccount = false;
		}
                else{
                    System.out.println("The account is already created..!");
                }

	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 400, 450);
		pac.show();

		if (newaccount) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "C";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
                        
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			
			
			Account account = accountFactory.createAccount(accountType);
			account.setAccountNumber(accountnr);
			
			Customer customer = CustomerFactory.createCustomer(CustomerType.COMPANY);
			//customer.setId(id);
			customer.setName(clientName);
			//customer.setBirthDate(birthDate);
			//customer.setEmail(email);
			
			Address address = new Address();
			address.setCity(city);
			address.setZip(zip);
			address.setState(state);
			address.setStreet(street);
			
			customer.setAddress(address);
			account.setCustomer(customer);
                        account.setAccountType(accountType);
			
			accountService.createAccount(account);
			newaccount = false;
		}

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 300, 250);
			dep.show();

			// compute new amount
			double deposit = Double.parseDouble(amountDeposit);
                        
//			String samount = (String) model.getValueAt(selection, 5);
//			long currentamount = Long.parseLong(samount);
                        accountService.deposit(accnr, deposit);
                        
		       double newamount = accountService.getAccount(accnr).getBalance();
			model.setValueAt(String.valueOf(newamount), selection, 5);
			
			
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			double withdraw = Double.parseDouble(amountDeposit);
                        
//			String samount = (String) model.getValueAt(selection, 5);
//                        
//			long currentamount = Long.parseLong(samount);
                       
			double newamount = accountService.getAccount(accnr).getBalance()-withdraw;
                        
                        
                        
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						"You don't have enough balance in your account " + accnr ,
						"Warning: low balance", JOptionPane.WARNING_MESSAGE);
                               
			}
                        else{
                             accountService.withdraw(accnr,withdraw);
		      	model.setValueAt(String.valueOf(newamount), selection, 5);
                        }
			
			
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		accountService.addInterest();
		
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		
	}
        
        
        
}
