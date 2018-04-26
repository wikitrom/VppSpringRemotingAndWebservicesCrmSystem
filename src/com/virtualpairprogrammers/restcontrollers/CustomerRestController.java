package com.virtualpairprogrammers.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.restrepresentations.CustomerCollectionRepresentation;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerManagementService customerService;

	// -- Error handling

	// use spring error handling support - use ResponseEntity to return error data
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e) {

		// return a representation of the error/exception to client
		ClientErrorInformation error = new ClientErrorInformation(e.toString(), req.getRequestURI());
		return new ResponseEntity<ClientErrorInformation>(error, HttpStatus.NOT_FOUND);
	}

	// -- HTTP Request handlers

	// we want to support GETs to /customer/373737
	@RequestMapping(value = "/customer/{id}")
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException {
		return customerService.getFullCustomerDetail(id); // sent to the message converter
	}

	/**
	 * Requirement: ONLY return customers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customers")
	public CustomerCollectionRepresentation returnAllCustomers(@RequestParam(required = false) Integer first,
			@RequestParam(required = false) Integer last) {

		List<Customer> allCustomers = customerService.getAllCustomers();
		// remove calls before return
		for (Customer next : allCustomers) {
			next.setCalls(null);
		}

		// TODO: IMPORTANT! always check parameters before using them, skipped here

		// return value is sent to the message converter for further processing
		// note: we wrap allCustomer list in another object in order for the converter to
		// be able to return XML-formatted data

		if (first != null && last != null) {
			// sublist is exclusive -> last
			return new CustomerCollectionRepresentation(allCustomers.subList(first - 1, last));
		} else {
			return new CustomerCollectionRepresentation(allCustomers);
		}
	}

}
