package banking.factory.entity;

import banking.entity.CheckingAccount;
import banking.entity.SavingAccount;
import framework.entity.Account;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;

public class BankAccountFactory extends AccountFactory {

	@Override
	public Account createAccount(AccountType accountType) {
		if (! (accountType instanceof BankAccountType)){
			return null;
		}
		
		BankAccountType bankAccountType = (BankAccountType) accountType;
		if (bankAccountType == BankAccountType.CHECKING){
			return new SavingAccount();
		}
		else if (bankAccountType == BankAccountType.SAVING){
			return new CheckingAccount();
		}
		else {
			return null;
		}
	}

}
