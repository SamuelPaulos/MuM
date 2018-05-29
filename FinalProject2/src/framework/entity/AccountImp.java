package framework.entity;

import framework.factory.entity.AccountType;
import framework.observer.Observable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import framework.visitor.Visitor;

public abstract class AccountImp implements Account,Serializable{

	private String accountNumber;
	
	private Customer customer;
	
	private Double balance = 0.00;

	private List<AccountEntry> accountEntries = new ArrayList<>();

	private Interest interest;
	
	public AccountEntry getAccountEntry() {
		return accountEntry;
	}

	public void setAccountEntry(AccountEntry accountEntry) {
		this.accountEntry = accountEntry;
	}

	private AccountEntry accountEntry;
        
        private AccountType accType;
        String email="";
        private Observable observable;

	
	public AccountImp() {
		
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#setInterest(framework.entity.Interest)
	 */
	@Override
	public void setInterest(Interest interest) {
		this.interest = interest;
	}
        
        @Override
       public AccountType getAccountType(){
           return accType;
           }
       
        @Override
       public void  setAccountType(AccountType accType){
           this.accType=accType;
       }
        public Observable getObservable() {
            return observable;
        }

        public void setObservable(Observable observable) {
            this.observable = observable;
        }
	
	/* (non-Javadoc)
	 * @see framework.entity.Account#deposit(java.lang.Double)
	 */
    	@Override
    	public void deposit(Double amount){
    		setBalance(balance + amount);
    		
//    		AccountEntryImp newAccountEntry = new AccountEntryImp(
//    				amount, 
//    				"description", 
//    				"fromAccountNumber", 
//    				"fromPersonName"
//    		);
                    
//                    AccountEntryImp newAccountEntry = new AccountEntryImp(
//    				amount,"Money Deposited",new Date());
//    		accountEntries.add(newAccountEntry);
    		
    		
    		      this.accountEntry=new AccountEntryImp(
    				amount,"Money Deposited",new Date());
    		
    	}
    	
    	
    	@Override
    	public void withdraw(Double amount){
    		setBalance(balance - amount);
    		
//    		AccountEntryImp newAccountEntry = new AccountEntryImp(
//    				balance, 
//    				"description", 
//    				"fromAccountNumber", 
//    				"fromPersonName"
//    		);
//              
//    		AccountEntryImp newAccountEntry = new AccountEntryImp(amount,"Money withdraw",new Date());
//    		accountEntries.add(newAccountEntry);
    		
    		
    		this.accountEntry=new AccountEntryImp(
    				amount,"Money withdraw",new Date());
    	}
	
	/* (non-Javadoc)
	 * @see framework.entity.Account#addInterest()
	 */
	@Override
	public void addInterest(){
		interest.addInterest(this);
	}
	
	
	/* 
	 * getters and setters
	 */

	/* (non-Javadoc)
	 * @see framework.entity.Account#getAccountNumber()
	 */
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#setAccountNumber(java.lang.String)
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#getCustomer()
	 */
	@Override
	public Customer getCustomer() {
		return customer;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#setCustomer(framework.entity.Customer)
	 */
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/* (non-Javadoc)
	 * @see framework.entity.Account#getBalance()
	 */
	@Override
	public Double getBalance() {
		return balance;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#setBalance(java.lang.Double)
	 */
	@Override
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	/* (non-Javadoc)
	 * @see framework.entity.Account#getAccountEntries()
	 */
	@Override
	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#setAccountEntries(java.util.List)
	 */
	@Override
	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);		
	}

	@Override
	public double getMinimumPaymentPercent() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see framework.entity.Account#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}
	  @Override
	    public boolean notifyEmail(Double amount) {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public String getEmail() {
	          return email;
	    }

	    @Override
	    public void setEmail(String email) {
	             this.email=email;
	    }

	    @Override
	    public void update() {        
	        this.email=this.observable.getEmail();    
	        System.out.println("Account Imple Email:"+email);
	      }
	
   public Account getclone(Account acc) throws Exception{
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("temp/out.ser"));     
        out.writeObject(acc);
        out.close();
        
        
        
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("temp/out.ser"));
        Account clone=(Account)in.readObject();
		
		
		return clone;
	}
}
