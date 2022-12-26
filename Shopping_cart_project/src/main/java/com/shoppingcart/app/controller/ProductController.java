package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private  ProductService  productService;
	
		//Find all
		@GetMapping
		public List<Product> getAllProducts(){
			return productService.findAll();
		}
		
		//Add Product
		@PostMapping
		public MessageResponse createProduct(@RequestBody Product product) {
			return productService.save(product);
		}
		
		
		//Find By Id
	    @GetMapping("/getbyid/{id}")
	    public Product getProductById(@PathVariable  long id) throws ProductNotFoundException {
	    	
	    	Optional<Product> product = productService.getById(id);  
			if (product.isPresent()) {
				return product.get();
			}
			
		    throw  new ProductNotFoundException("Product not exist with id:" + id);	
		}	
	
	    
	  //Find the Product By name
	    @GetMapping("/getbyname/{productName}")
	    public ResponseEntity<List<Product>> findByProductName(@PathVariable  String productName){
	    	  List<Product> products = productService.getByName(productName);

	    	    if ( products.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }
	    	    
	    	    return new ResponseEntity<>( products, HttpStatus.OK);
	    	  }
	    	
	    
	    //Get Products records by page
	    @GetMapping("/getbypage")
	    public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
			
	    	List<Product> list = productService.paging();
			
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<List<Product>>(productService.paging(), HttpStatus.OK);
		}
	    
	    @GetMapping("/getbysort")
		 public List<Product> getProductsbysort(@RequestBody Product product) throws ProductNotFoundException {
			 
			  return (List<Product>) productService.sorting(product);
	             
		    }

	    
	    //Update Product
	    @PutMapping("{id}")
	  	public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
	  		
	    		product.setProductCode(id);
	  			
	    		return productService.update(product);
	    		   
	    }	
	  			
	    
	    //Delete By Id
	    @DeleteMapping("{id}")
	    public MessageResponse deleteByProductId(@PathVariable long id) throws ProductNotFoundException {

	    	try{
	 		   
	    		productService.getById(id);
		   
			}
			catch(ProductNotFoundException e) {
				
				e.printStackTrace();
			}
			 return productService.deleteById(id);
  	  }
}
		

