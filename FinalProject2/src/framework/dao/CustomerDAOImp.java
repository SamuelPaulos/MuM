package framework.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import framework.entity.Customer;

public class CustomerDAOImp implements CustomerDAO {
	private Map<Long, Customer> dataMap = new HashMap<>();
		
	@Override
	public void saveCustomer(Customer customer) {
		dataMap.put(customer.getId(), customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		dataMap.put(customer.getId(), customer);
	}

	@Override
	public Customer loadCustomer(Long id) {
		return dataMap.get(id);
	}

	@Override
	public Collection<Customer> getCustomers() {
		return dataMap.values();
	}

}
