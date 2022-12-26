package com.shoppingcart.app.exception;

public class OfficeNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = -8129406834468842223L;

	public  OfficeNotFoundException(String exception) {
		super(exception);
	}
}
