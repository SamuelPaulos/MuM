package framework.dao;

import java.util.Collection;

import framework.entity.Customer;

public interface CustomerDAO {
	
	public void saveCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public Customer loadCustomer(Long id);
	
	public Collection<Customer> getCustomers();
}
