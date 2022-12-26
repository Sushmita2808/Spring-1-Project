package com.shoppingcart.app.exception;

public class PaymentNotFoundException extends RuntimeException  {
	
	private static final long serialVersionUID = 933958641037794250L;

	public  PaymentNotFoundException(String exception) {
		super(exception);
	}
}
