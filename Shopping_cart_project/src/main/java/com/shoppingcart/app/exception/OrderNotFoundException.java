package com.shoppingcart.app.exception;

public class OrderNotFoundException extends RuntimeException  {
	
	private static final long serialVersionUID = 8280115182401600685L;

	public  OrderNotFoundException(String exception) {
		super(exception);
	}
}
