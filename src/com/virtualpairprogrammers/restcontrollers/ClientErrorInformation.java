package com.virtualpairprogrammers.restcontrollers;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * This is a helper class to carry the data to be returned when we throw an
 * exception of some kind, i.e. when an HTTP error code is sent back to the
 * client.
 * 
 * @author mrB
 */
@XmlRootElement
public class ClientErrorInformation {

	private String message;
	private String uri;

	// -- constructors --

	// -- empty constructor
	// needed for Spring httpmessageconverter to work properly when returning
	// xml-formatted error codes
	public ClientErrorInformation() {
	}

	public ClientErrorInformation(String message, String uri) {
		this.message = message;
		this.uri = uri;
	}

	// -- getters/setters --

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
