package creditCard.entity;

import framework.entity.AccountImp;

public abstract class CreditAccount extends AccountImp {

	@Override
	public boolean notifyEmail(Double amount) {
		if (amount > 400 || this.getBalance()  < 0) {
			return true;
		}
		else {			
			return false;
		}
	}
}
