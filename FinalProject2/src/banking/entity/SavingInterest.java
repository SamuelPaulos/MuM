package banking.entity;

import java.io.Serializable;

import framework.entity.Account;
import framework.entity.Interest;

public class SavingInterest implements Interest, Serializable{

	/**
	 * If balance < 1000 then you get 1% interest
	 * If balance > 1000 and balance < 5000 then you get 2% interest
	 * If balance > 5000 then you get 4% interest
	 */
	@Override
	public void addInterest(Account account) {
		Double balance = account.getBalance();
		if (balance.intValue() < 1000){
			account.setBalance(balance * 1.01);
		}
		else if (balance.intValue() > 1000 && balance.intValue() < 5000) {
			account.setBalance(balance * 1.02);
		}
		else if (balance.intValue() > 5000) {
			account.setBalance(balance * 1.04);
		}
	}
}
