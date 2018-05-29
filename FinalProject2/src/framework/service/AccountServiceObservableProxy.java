package framework.service;

import java.util.Iterator;
import java.util.List;

import framework.entity.Account;
import framework.entity.Company;
import framework.entity.Customer;
import framework.observer.Observable;

public class AccountServiceObservableProxy extends Observable implements AccountService {
	
	private AccountService accountService;
	
	public AccountServiceObservableProxy(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void createAccount(Account account) {
		System.out.println("\n createAccount(Account "+ account +")");
		accountService.createAccount(account);
	}

	@Override
	public void deposit(String accountNumber, Double amount) {
		System.out.println("\n deposit(accountNumber "+ accountNumber +", amount " + amount +")");
		accountService.deposit(accountNumber, amount);
		
		Account account = getAccount(accountNumber);
		notifyAccountChanged(account, amount);
	}

	@Override
	public void withdraw(String accountNumber, Double amount) {
		System.out.println("\n withdraw(accountNumber "+ accountNumber +", amount " + amount +")");
		accountService.withdraw(accountNumber, amount);
		
		Account account = getAccount(accountNumber);
		notifyAccountChanged(account, amount);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		System.out.println("\n transferFunds(Account "+ source +", Account "+ destination +", amount " + amount +")");
		accountService.transferFunds(source, destination, amount);
		notifyAccountChanged(source, amount);
		notifyAccountChanged(destination, amount);
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
		System.out.println("\n addInterest() to all accounts in the system");
		accountService.addInterest();
	}
	
	@Override
	public List<String> getMonthlyBillingReport() {
		return accountService.getMonthlyBillingReport();
	}
	
	public void notifyAccountChanged(Account account, Double amount) {
		Customer customer = account.getCustomer();
		if (customer instanceof Company) {
			notifyObservers();
			return;
		}

		if (account.notifyEmail(amount)){
			notifyObservers();
		}
	}

        //not implemented
    @Override
    public String undoCommand() {
        return "";
    }

    @Override
    public String redoCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
