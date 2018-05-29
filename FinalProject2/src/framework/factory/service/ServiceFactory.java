package framework.factory.service;

import framework.factory.dao.DAOFactory;
import framework.service.AccountService;
import framework.service.AccountServiceImp;
import framework.service.AccountServiceInvoker;
import framework.service.AccountServiceObservableProxy;
import framework.service.CustomerService;
import framework.service.CustomerServiceImp;

public class ServiceFactory {
	private static volatile AccountService accountService;
	private static volatile CustomerService customerService;
	private static volatile AccountServiceInvoker accountServiceInvoker;
	
	
	
	public static AccountService createAccountService() {
		if(accountService==null) {
			synchronized(ServiceFactory.class) {
				if(accountService==null ) {
					
					AccountServiceImp accountServiceImp = new AccountServiceImp();
					accountServiceImp.setAccountDAO(DAOFactory.createAccountDAO());
					
					accountService = new AccountServiceInvoker(new AccountServiceObservableProxy(accountServiceImp));
					//accountService = new AccountServiceInvoker();
				}
			}
		}
		
		return accountService;
	}
	
	public static CustomerService createCustomerService() {
		if(null == customerService) {
			synchronized(ServiceFactory.class) {
				if(null == customerService) {
					CustomerServiceImp customerServiceImp = new CustomerServiceImp();
					customerServiceImp.setCustomerDAO(DAOFactory.createCustomerDAO());
					
					customerService = customerServiceImp;
				}
			}
		}
		
		return customerService;
	}
	public static AccountServiceInvoker createInvokerService() {
		if(null == accountServiceInvoker) {
			synchronized(ServiceFactory.class) {
				if(null == accountServiceInvoker) {
					accountServiceInvoker = new AccountServiceInvoker();
				}
			}
		}
		
		return accountServiceInvoker;
	}

}
