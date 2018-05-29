package creditCard.entity;

import framework.entity.Account;
import framework.entity.Interest;

public class GoldInterest implements Interest {

	/**
	 * If It is Gold, interest is 6%
	 */
	@Override
	public void addInterest(Account account) {
		Double balance = account.getBalance();
		account.setBalance(balance * 1.06);
	}
}
