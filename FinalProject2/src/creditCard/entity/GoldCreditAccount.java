package creditCard.entity;

public class GoldCreditAccount extends CreditAccount {
	private static final double goldMinimunPaymentPercent = 0.10;

	public GoldCreditAccount() {
		setInterest(new GoldInterest());
	}

	@Override
	public double getMinimumPaymentPercent() {
		return goldMinimunPaymentPercent;
	}
}
