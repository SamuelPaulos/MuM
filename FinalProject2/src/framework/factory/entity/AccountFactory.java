package framework.factory.entity;

import framework.entity.Account;

public abstract class AccountFactory {
	
	public abstract Account createAccount(AccountType accountType);
}
