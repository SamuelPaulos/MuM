package creditCard.entity;

import framework.entity.Account;
import framework.entity.Interest;

public class SilverInterest implements Interest {

	/**
	 * If It is Bronze, interest is 10%
	 */
	@Override
	public void addInterest(Account account) {
		Double balance = account.getBalance();
		account.setBalance(balance * 1.1);
	}
}
