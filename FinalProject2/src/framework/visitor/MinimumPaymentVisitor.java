package framework.visitor;

import framework.entity.Account;

public class MinimumPaymentVisitor implements Visitor {

	@Override
	public double visit(Account account) {
		return account.getBalance() * account.getMinimumPaymentPercent();
	}

}
