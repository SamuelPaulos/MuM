package banking.entity;

import framework.entity.AccountImp;

public class BankAccount extends AccountImp {

	@Override
	public boolean notifyEmail(Double amount) {
		if (amount > 500 || this.getBalance()  < 0) {
			return true;
		}
		else {			
			return false;
		}
	}

}
