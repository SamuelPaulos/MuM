package framework.factory.dao;

import framework.dao.AccountDAO;
import framework.dao.AccountDAOImp;
import framework.dao.CustomerDAO;
import framework.dao.CustomerDAOImp;

public class DAOFactory {
	private static volatile AccountDAO accountDAO;
	private static volatile CustomerDAO customerDAO;

	public static AccountDAO createAccountDAO()

	{	if (null == accountDAO) {
			synchronized (DAOFactory.class) {
				if (null == accountDAO) {
					accountDAO = new AccountDAOImp();	}
			}
		}

		return accountDAO;
	}

	public static CustomerDAO createCustomerDAO() {
		if (null == customerDAO) {
			synchronized (DAOFactory.class) {
				if (null == customerDAO) {
					customerDAO = new CustomerDAOImp();
				}
			}
		}

		return customerDAO;
	}

}
