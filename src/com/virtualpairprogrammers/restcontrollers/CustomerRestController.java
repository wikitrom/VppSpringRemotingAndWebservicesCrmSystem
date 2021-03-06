package com.virtualpairprogrammers.restcontrollers;

// for HATEOAS linking
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.restrepresentations.CustomerCollectionRepresentation;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerManagementService customerService;

	@Autowired
	private CustomerValidator validator; // to validate customer objects

	// -- Error handling

	// use spring error handling support - use ResponseEntity to return error data
	@ExceptionHandler(CustomerNotFoundException.class) // what to do if CustomerNotFoundException is thrown
	public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e) {

		// return a representation of the error/exception to client
		ClientErrorInformation error = new ClientErrorInformation(e.toString(), req.getRequestURI());
		return new ResponseEntity<ClientErrorInformation>(error, HttpStatus.NOT_FOUND);
	}

	// -- HTTP Request handlers

	// --- GET handlers

	// we want to support GETs to /customer/373737
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException {
		return customerService.getFullCustomerDetail(id); // sent to the message converter
	}

	/**
	 * Requirement: return customers with links
	 *
	 * @return
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public CustomerCollectionRepresentation returnAllCustomers(@RequestParam(required = false) Integer first,
			@RequestParam(required = false) Integer last) throws CustomerNotFoundException {

		List<Customer> allCustomers = customerService.getAllCustomers();

		// remove call details AND add detailed link (HATEOAS) before returning results
		for (Customer next : allCustomers) {
			next.setCalls(null);
			Link link = linkTo(methodOn(CustomerRestController.class).findCustomerById(next.getCustomerId()))
					.withSelfRel();
			next.add(link);
		}

		// TODO: IMPORTANT! always check parameters before using them, skipped here

		// return value is sent to the message converter for further processing
		// note: we wrap allCustomer list in another object in order for the converter
		// to be able to return XML-formatted data

		if (first != null && last != null) {
			// sublist is exclusive -> last
			CustomerCollectionRepresentation page = new CustomerCollectionRepresentation(
					allCustomers.subList(first - 1, last));
			page.add(linkTo(methodOn(CustomerRestController.class).returnAllCustomers(last + 1, last + 10))
					.withRel("next"));
			return page;
		} else {
			return new CustomerCollectionRepresentation(allCustomers);
		}
	}

	// --- POST handlers

	// -- NOTE:
	//
	// The 'Errors errors' parameter is required by Spring Validator class.
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer, Errors errors)
			throws CustomerNotFoundException {

		// validate newCustomer object before use
		validator.validate(newCustomer, errors);
		if (errors.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Customer createdCustomer = customerService.newCustomer(newCustomer);

		// -- create return link to access new customer
		HttpHeaders headers = new HttpHeaders();

		// URI uri =
		// MvcUriComponentsBuilder.fromMethodName(CustomerRestController.class,
		// "findCustomerById",
		// createdCustomer.getCustomerId()).build().toUri();

		// -- using Spring HATEOAS
		// --- 1st try:
		// --- the findCustomerById method below is not called, it's just an identifier
		// --- however, eclipse will complain about try-catch, thus we
		// --- have to add a throws-declaration to the method even though it will never
		// --- occur, thus we add a 'throws ...' declaration to the method above
		// URI uri =
		// ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CustomerRestController.class)
		// .findCustomerById("109")).toUri();

		// --- 2nd try:
		// this short version works because we use a static import of
		// ControllerLinkBuilder.*
		URI uri = linkTo(methodOn(CustomerRestController.class).findCustomerById(createdCustomer.getCustomerId()))
				.toUri();

		headers.setLocation(uri);

		return new ResponseEntity<Customer>(createdCustomer, headers, HttpStatus.CREATED); // 201
	}

	// --- PUT handlers

	@RequestMapping(value = "/customers", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT) // 204
	public void updateExistingCustomer(@RequestBody Customer newCustomer) throws CustomerNotFoundException {
		customerService.updateCustomer(newCustomer);
	}

	// --- DELETE handlers

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT) // 204
	public void deleteCustomerById(@PathVariable String id) throws CustomerNotFoundException {
		Customer customer = customerService.getFullCustomerDetail(id);
		customerService.deleteCustomer(customer);
	}

	// N/A
}
