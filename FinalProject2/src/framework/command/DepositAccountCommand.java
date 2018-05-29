package framework.command;

import framework.entity.Account;
import framework.service.AccountService;

public class DepositAccountCommand implements Command {
	private AccountService accountService;
	private String accountNumber;
	private Double amount;

    public AccountService getAccountService() {
        return accountService;
    }

	public DepositAccountCommand(AccountService accountService, String accountNumber, Double amount) {
		this.accountService = accountService;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.deposit(accountNumber, amount);
	}

	@Override
	public String undo() {
		accountService.withdraw(accountNumber, amount);
                return accountNumber;
	}
        
        	@Override
        public String redo(){
            accountService.deposit(accountNumber, amount);     
          
           return accountNumber;
        }
	
}