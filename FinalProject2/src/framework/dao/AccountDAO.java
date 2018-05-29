package framework.dao;

import java.util.Collection;
import java.util.List;

import banking.entity.BankStaff;
import framework.entity.Account;

public interface AccountDAO {
	
	public void saveAccount(Account account);
	
	public void updateAccount(Account account);
	
	public Account loadAccount(String accountNumber);
	
	public Collection<Account> getAccounts();
	public Collection<Account> getAccountsHashmap();
	
	public void saveBankStaff(BankStaff bankStaff);
	
	public List<BankStaff> getBankStaff();
	public Account getAccountHashmap(String acc);
	public void updateAccountHashmap(Account acc);
}
