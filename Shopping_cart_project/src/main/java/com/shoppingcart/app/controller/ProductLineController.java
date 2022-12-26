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

import com.shoppingcart.app.exception.ProductLineNotFoundException;
import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.ProductLineService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productlines")
public class ProductLineController {
	
	@Autowired
	private ProductLineService productLineService;
	
	//Find all ProductLine
	@GetMapping
	public List<ProductLine> getAllProductLines(){
		return productLineService.findAll();
	}
	
	//Add ProductLine
	@PostMapping
	public MessageResponse createProductLine(@RequestBody ProductLine productLine) {
		return productLineService.save(productLine);
	}
	
	//Find By Id
	@GetMapping("/getbyid/{id}")
	public ProductLine getProductLineById(@PathVariable  long id) throws ProductLineNotFoundException {
		
		Optional<ProductLine> productLine= productLineService.getById(id);  
		if (productLine.isPresent()) {
			return productLine.get();
		}
		
	    throw  new ProductLineNotFoundException("ProductLine not exist with id:" + id);	
	}
	
	 //Sort the ProductLine List by description
    @GetMapping("/sortbyDes")
    public List<ProductLine> findAllSortedByDescription(@RequestBody ProductLine productLinedetails) throws ProductLineNotFoundException {
        return productLineService.sortedByDescription(productLinedetails);
             
    }
    
    //Get ProductLines records by page
    @GetMapping("/getbypage")
    public ResponseEntity<List<ProductLine>> getProductLines() throws ProductLineNotFoundException {
		List<ProductLine> list =productLineService.paging();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<ProductLine>>(productLineService.paging(), HttpStatus.OK);
	}
    
    @GetMapping("/getbysort")
	 public List<ProductLine> getProductsbysort(@RequestBody ProductLine productLine) throws ProductLineNotFoundException {
		 
		  return (List<ProductLine>) productLineService.sorting(productLine);
            
	    }

    
	 //Update Product
    @PutMapping("{id}")
  	public ProductLine updateProductLine(@RequestBody ProductLine productLine, @PathVariable long id) {
  		
    	productLine.setProductLine(id);
		
		return productLineService.update(productLine);
	   
		}	
		  
	
	 //Delete By Id
	  @DeleteMapping("{id}")
	  public MessageResponse deleteProductLineById(@PathVariable long id) throws ProductLineNotFoundException {

		  try{
			   
			  productLineService.getById(id);
		   
			}
			catch(ProductLineNotFoundException e) {
				
				e.printStackTrace();
			}
			 return productLineService.deleteById(id);
	  }
}
		

