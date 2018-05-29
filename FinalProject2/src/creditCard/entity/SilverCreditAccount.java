package creditCard.entity;

public class SilverCreditAccount extends CreditAccount {
	private static final double silverMinimumPaymentPercent = 1.20;

	public SilverCreditAccount() {
		setInterest(new SilverInterest());
	}

	@Override
	public double getMinimumPaymentPercent() {
		return silverMinimumPaymentPercent;
	}
}
