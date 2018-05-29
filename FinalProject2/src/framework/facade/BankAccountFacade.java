package framework.facade;

import framework.entity.Account;
import framework.factory.service.ServiceFactory;
import framework.service.AccountService;

public class BankAccountFacade {

private AccountService accountService = ServiceFactory.createAccountService();
public void createAccount(Account account){
	System.out.println("facade gebtuwal");
	accountService.createAccount(account);
}
public int validateform(Account account){
	
	if(account.getCustomer().getName().isEmpty())
		return 1;
	if(account.getCustomer().getEmail().isEmpty())
		return 2;
			
	createAccount(account);
		return 5;
	
}
}
