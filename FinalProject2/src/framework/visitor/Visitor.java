package framework.visitor;

import framework.entity.Account;

public interface Visitor {
	public double visit(Account account);
}
