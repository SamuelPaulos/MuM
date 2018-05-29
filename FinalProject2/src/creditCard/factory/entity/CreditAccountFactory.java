package creditCard.factory.entity;

import creditCard.entity.BronzeCreditAccount;
import creditCard.entity.GoldCreditAccount;
import creditCard.entity.SilverCreditAccount;
import framework.entity.Account;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;

public class CreditAccountFactory extends AccountFactory {

	@Override
	public Account createAccount(AccountType accountType) {
		if (! (accountType instanceof CreditAccountType)){
			return null;
		}
		
		CreditAccountType creditAccountType = (CreditAccountType) accountType;
		if (creditAccountType == CreditAccountType.GOLD){
			return new GoldCreditAccount();
		}
		else if (creditAccountType == CreditAccountType.SILVER){
			return new SilverCreditAccount();
		}
		else if (creditAccountType == CreditAccountType.BRONZE){
			return new BronzeCreditAccount();
		}
		else {
			return null;
		}
		
	}

}
