package framework.service;

import java.util.List;

import framework.entity.Customer;

public interface CustomerService {
	
	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public Customer getCustomer(Long Id);
	
	public List<Customer> getCustomers();

}
