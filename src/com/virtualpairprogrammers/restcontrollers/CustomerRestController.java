package com.virtualpairprogrammers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerManagementService customerService;

	// we want to support GETs to /customer/373737
	@RequestMapping(value = "/customer/{id}")
	public Customer findCustomerById(@PathVariable String id)
			throws CustomerNotFoundException {
		return customerService.getFullCustomerDetail(id);
	}
}
