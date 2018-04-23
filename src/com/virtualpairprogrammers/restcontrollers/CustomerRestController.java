package com.virtualpairprogrammers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@Controller
public class CustomerRestController {

	@Autowired
	private CustomerManagementService customerService;

	// add support for GET to /customer/3737373
	@RequestMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable String id) {
		try {
			Customer foundCustomer = customerService.getFullCustomerDetail(id);
			return foundCustomer;
		} catch (CustomerNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
