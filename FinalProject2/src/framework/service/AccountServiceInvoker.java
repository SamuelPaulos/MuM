package framework.service;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import framework.command.Command;
import framework.command.DepositAccountCommand;
import framework.command.TransferAccountCommand;
import framework.command.WithdrawAccountCommand;
import framework.entity.Account;

public class AccountServiceInvoker implements AccountService {
	
	private AccountService accountService;
	private Stack<Command> undoCommands = new Stack<>();
	private Stack<Command> redoCommands = new Stack<>();
	
	public AccountServiceInvoker(AccountService accountService) {
		this.accountService = accountService;
	}
	  
	public AccountServiceInvoker() {
		// TODO Auto-generated constructor stub
	}

	public void setCommand(Command command) {
		//commands.put(operation, command);
	}
	 
	public void runCommand(Command command) {
		command.execute();
		undoCommands.push(command);
                if(redoCommands.size()!=0)
                   redoCommands.clear(); 
	}
        
     
	
        @Override
        public String redoCommand(){  
                Command redoCommand;
                String accNumber="";
              if(redoCommands.size()>0){
            	  redoCommand=redoCommands.pop(); 
            	  System.out.println("Redo Command:"+redoCommand);
                           
            undoCommands.push(redoCommand);
           accNumber=redoCommand.redo();
                  }  
            return accNumber;
        }
        
        
        @Override
	public String undoCommand() {
            
            Command undoCommand=null;
            String accNumber="";
            if(undoCommands.size()>0){
		undoCommand = undoCommands.pop();
		
		redoCommands.push(undoCommand);
               accNumber=undoCommand.undo();
                
            }
                return accNumber;
	}

	@Override
	public void createAccount(Account account) {
		System.out.println("Acc Invoker 1"+accountService);
		accountService.createAccount(account);
		System.out.println("Acc Invoker 2"+accountService);
		
	}

	@Override
	public void deposit(String accountNumber, Double amount) {
		Command command = new DepositAccountCommand(accountService, accountNumber, amount);
                
		runCommand(command);
	}

	@Override
	public void withdraw(String accountNumber, Double amount) {
		Command command = new WithdrawAccountCommand(accountService, accountNumber, amount);
		runCommand(command);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		Command command = new TransferAccountCommand(accountService, source, destination, amount);
		runCommand(command);
	}

	@Override
	public Iterator<Account> accountIterator() {
		return accountService.accountIterator();
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountService.getAccount(accountNumber);
	}

	@Override
	public void addInterest() {
		accountService.addInterest();
	}
	
	@Override
	public List<String> getMonthlyBillingReport() {
		return accountService.getMonthlyBillingReport();
	}

	@Override
	public Account getAccountHashmap(String accountNumber) {
		// TODO Auto-generated method stub
		return accountService.getAccountHashmap(accountNumber);
	}

	@Override
	public Iterator<Account> accountIteratorHashmap() {
		// TODO Auto-generated method stub
		return accountService.accountIteratorHashmap();
	}

    

//    @Override
//    public void redo() {
//
//    }

}
