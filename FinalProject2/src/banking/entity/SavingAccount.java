package banking.entity;

public class SavingAccount extends BankAccount {

	public SavingAccount() {
		setInterest(new SavingInterest());
	}
}
