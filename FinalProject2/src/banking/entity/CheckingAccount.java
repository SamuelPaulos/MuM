package banking.entity;

public class CheckingAccount extends BankAccount {

	public CheckingAccount() {
		setInterest(new CheckingInterest());
	}

}
