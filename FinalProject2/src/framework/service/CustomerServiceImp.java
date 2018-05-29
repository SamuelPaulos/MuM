package framework.service;

import java.util.ArrayList;
import java.util.List;

import framework.dao.CustomerDAO;
import framework.entity.Customer;

public class CustomerServiceImp implements CustomerService {

	private CustomerDAO customerDAO;
	
	public CustomerServiceImp() {
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public void createCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);

	}

	@Override
	public Customer getCustomer(Long id) {
		return customerDAO.loadCustomer(id);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers = (List<Customer>) customerDAO.getCustomers();
		return customers;
	}

}
