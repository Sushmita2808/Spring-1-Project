package com.shoppingcart.app.exception;

public class ProductLineNotFoundException extends RuntimeException  {
	
	private static final long serialVersionUID = -7824162061271919117L;

	public  ProductLineNotFoundException(String exception) {
		super(exception);
	}
}
