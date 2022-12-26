package com.shoppingcart.app.exception;

public class EmployeeNotFoundException  extends RuntimeException  {

	private static final long serialVersionUID = 203510100712702738L;

	public  EmployeeNotFoundException(String exception) {
		super(exception);
	}
}
