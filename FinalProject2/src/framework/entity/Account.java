package framework.entity;

import framework.factory.entity.AccountType;
import framework.observer.Observable;

import java.util.List;
import java.util.function.Consumer;

import framework.visitor.Visitor;

public interface Account {
        public AccountType getAccountType();
          public void  setAccountType(AccountType accType);
	void setInterest(Interest interest);

	void deposit(Double amount);
	
	void withdraw(Double amount);

	void addInterest();

	String getAccountNumber();

	void setAccountNumber(String accountNumber);

	Customer getCustomer();

	void setCustomer(Customer customer);

	Double getBalance();

	void setBalance(Double balance);

	List<AccountEntry> getAccountEntries();

	void setAccountEntries(List<AccountEntry> accountEntries);
	AccountEntry getAccountEntry();
	void setAccountEntry(AccountEntry accEntry);
	
	boolean notifyEmail(Double amount);
	
	double getMinimumPaymentPercent();
	 public double accept(Visitor visitor);
	  
	  public String getEmail();
	  public void setEmail(String email);
	  public void update();
	  public void setObservable(Observable obs);
	   public Observable getObservable();
	
	Account getclone(Account acc)throws Exception;

}