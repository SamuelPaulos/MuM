package framework.command;

import framework.entity.Account;
import framework.service.AccountService;

public class TransferAccountCommand implements Command {
	private AccountService accountService;
	private Account source;
	private Account destination;
	private Double amount;

	public TransferAccountCommand(AccountService accountService, Account source, Account destination, Double amount) {
		this.accountService = accountService;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}
	
	public void execute() {
		accountService.transferFunds(source, destination, amount);
	}

	@Override
	public String  undo() {
		accountService.transferFunds(destination, source, amount);
                return "";
	}
        
        
//        	@Override
//        public Account redo(){
//            accountService.deposit(accountNumber, amount);      
//           return accountService.getAccount(accountNumber);
//        }

    @Override
    public String redo() {
    	accountService.transferFunds(source,destination, amount);
    	return "";
    }
	
        
       
	
}