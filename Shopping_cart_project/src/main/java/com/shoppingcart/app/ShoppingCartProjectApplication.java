package com.shoppingcart.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoppingcart.app.display.AddData;

@SpringBootApplication
public class ShoppingCartProjectApplication implements CommandLineRunner {
	
	@Autowired
	private AddData  addData;
	

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("\n\nWelcome to ShoppingCart!!!");
		
		/* In AddData class we created object of this project and add in List ,also save in Database
		 * Named ShoppingCartApp. */
		
		addData.run();
		
	}

}
