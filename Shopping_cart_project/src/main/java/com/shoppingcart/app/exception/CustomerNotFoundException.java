package com.shoppingcart.app.exception;

public class CustomerNotFoundException  extends RuntimeException {
	
	private static final long serialVersionUID = -8109095457284077938L;

	public CustomerNotFoundException(String exception) {
		super(exception);
	}
}
