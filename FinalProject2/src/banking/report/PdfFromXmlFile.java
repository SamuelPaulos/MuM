package banking.report;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import banking.factory.entity.BankAccountFactory;
import banking.factory.entity.BankAccountType;
import framework.entity.Account;
import framework.entity.Address;
import framework.entity.Customer;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.CustomerFactory;
import framework.factory.entity.CustomerType;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
	 
	public class PdfFromXmlFile {
		
	            static  Account account;
	            
	            static AccountReport accountreport;
		        static  AccountFactory accountFactory = new BankAccountFactory();
		        static AccountService accountService = ServiceFactory.createAccountService();
		   
		public void generateReport() throws JRException, IOException {
	        try {
	           
	            /* List to hold Items */
	           
	            List<AccountReport> listItems = new ArrayList();

	        
	            
	            Iterator<Account> accountlist = accountService.accountIterator();
	    
	    	while (accountlist.hasNext()) {
	    			accountreport=new AccountReport();
	    			account = accountlist.next();
	    			  			 
	            accountreport.setAccountNumber(account.getAccountNumber());
	            accountreport.setBalance(account.getBalance());
	            accountreport.setName(account.getCustomer().getName());
	            accountreport.setEmail(account.getCustomer().getEmail());
	            accountreport.setStreet(account.getCustomer().getAddress().getStreet());
	            accountreport.setCity(account.getCustomer().getAddress().getCity());
	            accountreport.setZip(account.getCustomer().getAddress().getZip());
	            accountreport.setState(account.getCustomer().getAddress().getState());
	           

	            /* Add Items to List */
	            listItems.add(accountreport);
	            }
	        

	            /* Convert List to JRBeanCollectionDataSource */
	            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

	            /* Map to hold Jasper report Parameters */
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("ItemDataSource", itemsJRBean);

	            /* Using compiled version(.jasper) of Jasper report to generate PDF */
	            JasperPrint jasperPrint = JasperFillManager.fillReport("src/banking/report/template_Table.jasper", parameters, new JREmptyDataSource());

	            // jasper viewer
	            JasperViewer jasperviewer= new JasperViewer(jasperPrint);
	            jasperviewer.getContentPane().setBackground(new Color(95,95,95));
	            jasperviewer.setVisible(true);
	            /* outputStream to create PDF */
//	            OutputStream outputStream = new FileOutputStream(new File(outputFile));
//	            /* Write content to PDF file */
//	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

	            System.out.println("File Generated");
	        } catch (JRException ex) {
	            ex.printStackTrace();
	        }
	    }
		

	}

