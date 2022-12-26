package com.shoppingcart.app.exception;

public class OrderDetailNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 3291621815637372340L;

	public  OrderDetailNotFoundException(String exception) {
		super(exception);
	}
}
