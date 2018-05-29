package framework.command;

import framework.entity.Account;
import framework.service.AccountService;

public class WithdrawAccountCommand implements Command {
	private AccountService accountService;
	private String accountNumber;
	private Double amount;

	public WithdrawAccountCommand(AccountService accountService, String accountNumber, Double amount) {
		this.accountService = accountService;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	public void execute() {
		accountService.withdraw(accountNumber, amount);
	}

	@Override
	public String undo() {
		accountService.deposit(accountNumber, amount);
                return accountNumber;
	}
        
        
      @Override
        public String redo(){
            accountService.deposit(accountNumber, amount);      
           return accountNumber;
           
                   }
	
	
}