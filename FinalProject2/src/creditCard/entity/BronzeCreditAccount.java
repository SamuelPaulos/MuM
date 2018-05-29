package creditCard.entity;

public class BronzeCreditAccount extends CreditAccount {
	private static final double bronzeMinimumPaymentPercent = 1.40;

	public BronzeCreditAccount() {
		setInterest(new BronzeInterest());
	}

	@Override
	public double getMinimumPaymentPercent() {
		return bronzeMinimumPaymentPercent;
	}
}
