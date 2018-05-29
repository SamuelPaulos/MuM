package framework.observer;

import framework.entity.Account;
import framework.service.AccountService;
import java.util.ArrayList;
import java.util.Iterator;

public class Observable {

         protected String email="";
    
	private ArrayList<Account> observers = new ArrayList<Account>();
	private AccountService accSer;
        private Iterator<Account> accounts;  //observers are here
       
        public Observable(AccountService accSer){
             this.accSer=accSer;
              accounts=accSer.accountIteratorHashmap();
              System.out.println("From Observable: "+accounts);
        }
        public Observable(){
            
        }
        
        
//        public int getState(){
//            
//            return state;
//        }
//        public void setState(){
//            this.state=1;
//            
//            notifyObservers();            
//        }
        
        public void setEmail(String email){
            this.email=email;
             notifyCustomers();  
        }
        
        public String getEmail(){
            return email;
        }
        
	public void registerObserver(Account observer) {
		if (observers == null)
        throw new NullPointerException();
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeObserver(Account observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
            
//		for (Account observer : observers) {
//                      observer.setObservable(this);
//			observer.update();
//		}
               
                
                
	   }
        
        public void notifyCustomers(){
        	
        	System.out.println("notify customers: before"+this.email);
            
            while(accounts.hasNext()){
                     Account acc;
                     acc=accounts.next();
                     acc.setObservable(this);             
                     System.out.println("From Ob: notify"+acc.getEmail());
                     acc.update();
                    
                }
        }
        
        

}
