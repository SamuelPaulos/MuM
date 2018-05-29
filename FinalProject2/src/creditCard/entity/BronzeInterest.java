package creditCard.entity;

import framework.entity.Account;
import framework.entity.Interest;

public class BronzeInterest implements Interest {

	/**
	 * If It is Silver, interest is 8%
	 */
	@Override
	public void addInterest(Account account) {
		Double balance = account.getBalance();
		account.setBalance(balance * 1.08);
	}
}
