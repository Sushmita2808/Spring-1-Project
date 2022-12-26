package com.shoppingcart.app.exception;

public class ProductNotFoundException  extends RuntimeException  {

	private static final long serialVersionUID = 1531865679710451637L;

	public ProductNotFoundException(String exception) {
		super(exception);
	}
}
