package banking.entity;

import java.io.Serializable;

import framework.entity.Account;
import framework.entity.Interest;

public class CheckingInterest implements Interest,Serializable {

	/**
	 * If balance < 1000 then you get 1.5% interest
	 * If balance > 1000 then you get 2.5% interest
	 */
	@Override
	public void addInterest(Account account) {
		Double balance = account.getBalance();
		if (balance.intValue() < 1000){
			account.setBalance(balance * 1.015);
		}
		else if (balance.intValue() > 1000) {
			account.setBalance(balance *1.025);
		}
	}

}
