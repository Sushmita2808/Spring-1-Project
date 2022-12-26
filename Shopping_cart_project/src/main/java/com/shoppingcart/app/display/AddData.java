package com.shoppingcart.app.display;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shoppingcart.app.controller.CustomerController;
import com.shoppingcart.app.controller.EmployeeController;
import com.shoppingcart.app.controller.OfficeController;
import com.shoppingcart.app.controller.OrderController;
import com.shoppingcart.app.controller.OrderDetailController;
import com.shoppingcart.app.controller.PaymentController;
import com.shoppingcart.app.controller.ProductController;
import com.shoppingcart.app.controller.ProductLineController;
import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.model.OrderDetail;
import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.model.ProductLine;

@Controller
public class AddData {
	

	@Autowired
	private ProductController productController;
	
	@Autowired
	private ProductLineController productLineController;
	
	@Autowired
	private OfficeController officeController;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private OrderController orderController;
	
	@Autowired
	private OrderDetailController orderDetailController;
	
	@Autowired
	private PaymentController paymentController;
	
	@Autowired
	private CustomerController customerController;

	public void run() {

		System.out.println("\n\n*********Products Records***********");
		addProducts(createProducts());
		
		System.out.println("\n\n*********productLines Records***********");
		addProductLine(createProductLines());
		
		System.out.println("\n\n*********Orders Records***********");
		addOrder(createOrder());
		
		System.out.println("\n\n*********OrderDetails Records***********");
		addOrderDetail(createOrderDetail());
		
		System.out.println("\n\n*********Customers Records***********");
		addCustomer(createCustomer());
		
		System.out.println("\n\n*********Payments Records***********");
		addPayment(createPayment());
		
		System.out.println("\n\n*********Employees Records***********");
		addEmployee(createEmployee());
		
		System.out.println("\n\n*********Offices Records***********");
		addOffice(createOffice());
		
		
	}
	
	//----------------- Add Product in database ---------------------
	
	private void addProducts(List<Product> products) {
		for (Product product : products) {
			productController.createProduct(product);
			
		}
	}
	
	//----------------- Add ProductLine in database ---------------------
	
	private void addProductLine(List<ProductLine> productLines) {
		for (ProductLine productLine : productLines) {
			productLineController.createProductLine(productLine);
			}
		}
	
	//----------------- Add Customer in database ---------------------
	
	private void addCustomer(List<Customer> customers) {
		for (Customer customer :customers) {
			customerController.createCustomer(customer);
			}
		}
	
	//----------------- Add Order in database ---------------------
	
	private void addOrder(List<Order> orders) {
		for (Order order :orders) {
			orderController.createOrder(order);
		}
	}
	
	//----------------- Add OrderDetail in database ---------------------
	
	private void addOrderDetail(List<OrderDetail> orderDetails) {
		for (OrderDetail orderDetail :orderDetails) {
			orderDetailController.createOrderDetail( orderDetail);
		}
	}
	
	//----------------- Add Payment in database ---------------------
	
	private void addPayment(List<Payment> payments) {
		for (Payment payment :payments) {
			paymentController.createPayment(payment);
		}
	}
	
	//----------------- Add Employee in database ---------------------
	
	private void addEmployee(List<Employee> employees) {
		for (Employee employee :employees) {
			employeeController.createEmployee(employee);
		}
	}
	
	//----------------- Add Office in database ---------------------
	
	private void addOffice(List<Office> offices) {
		for (Office office :offices) {
			officeController.createOffice(office);
		}
	}
	
	//---------------------------------------------- Object's Insertion Part ----------------------------------------
	
	
	//********************************************* Product Class *******************************************************
	private List<Product> createProducts() {
		
		//create object
				
				Product product1 = new  Product(1L,"Maggie Noddles ","Nestlé  ranks second in the Food and Agriculture Benchmark ",
						"Rishabh Jaiswal","No matter where you go in India, no matter how remote a village, "
						+ "you will find Maggi 2-Minute Noodles.",189,238.10,252.34,null,null);		
						
				Product product2 = new  Product(2L,"Kit Kat","Nestlé  ranks second in the Food and Agriculture Benchmark ",
						"Rishabh Jaiswal","A delicious chocolate bar of 2 fingers of crispy wafer biscuit covered with"
						+ " smooth honeycomb flavoured chocolate.",189,499.04,640.11,null,null);			
								
				Product product3 = new  Product(3L,"Nivea Lotion","Nivea  ranked fourth ", "RK","Enriched with cocoa butter and coconut oil; gives long "
						+ "lasting and deep moisture to the skin, providing it deep nourishment.",189,259.10,375.22,null,null);
				
				Product product4 = new  Product(4L,"Amul Protein Buttermilk","Amul becomes World's 8th Largest Milk Processor",
						"Vihaan Distributes","Amul Protein Buttermilk is refreshing milk based natural drink.",189,40.04,48.30,null,null);
				
						
				//add in list
				List<Product> products= new ArrayList<>();
				products.add(product1);
				products.add(product2);
				products.add(product3);
				products.add(product4);
		 
		 return products;
		

		}
	
	//********************************************* ProductLine Class *******************************************************
	
	private List<ProductLine> createProductLines() {
		
		//Create Object
				ProductLine	productLine1 = new ProductLine(1L,"Amul offers a plethora of product lines that "
						+ "are closely related but still different .Its products include milk, flavored milk, chocolate","<ol>"
					    + "<li>Amul offers a plethora of product lines that are closely related but still different.<li>"
					    + "<li>Its products include milk, flavored milk, chocolate, butter, curd, yogurt, ghee, etc.<li>"
					    + "<ol>","D:\\Image of Project ANUD.jpg",null);
				
				ProductLine productLine2 = new ProductLine(2L,"Nestlé is the provider of the best food for whatever time of day "
				 		+ "and for whatever time of your life."+ "Its products include Baby Foods ,Milk ,Kit Kat ,"
				 		+ "Maggi Noodles ,Ice Cream  etc.." ,
				 		  "<ol>"
				 		+ "<li>Nestlé is the provider of the best food for whatever time of day.<li>"
				 		+ "<li>and for whatever time of your life.\"+ \"Its products include Baby Foods ,Milk ,Kit Kat<li>"
				 		+ "<li>Maggi Noodles ,Ice Cream  etc.<li>"
				 		+ "<ol>","D:\\Image of Project ANUD.jpg",null);
				 
				 ProductLine productLine3 = new ProductLine(3L,"Nivea is a skin & body care brand owned by a German company Beiersdorf."
						 +"Its products include Nivea Face Care, Nivea Deo ,Nivea Body ,Nivea Sun ,Nivea Men etc...",
						   "<ol>"
						 + "<li>Nivea is a skin & body care brand owned by a German company Beiersdorf.<li>"
						 + "<li>Its products include Nivea Face Care, Nivea Deo ,Nivea Body ,Nivea Sun ,Nivea Men etc....<li>"
						 + "<ol>","D:\\Image of Project ANUD.jpg",null);
				
				 
				 //add in list
				 List<ProductLine> productLinelist = new ArrayList<>();
					
				 productLinelist.add(productLine1);
				 productLinelist.add(productLine2);
				 productLinelist.add(productLine3);
				 
		return  productLinelist;
		
			}
		
	//********************************************* Order Class *******************************************************
	
	public List<Order> createOrder(){
			
		//Create Object
			Order order1 = new Order(new Date(2022, 11, 10),new Date(2022, 11, 22),new Date(2022, 11, 15),true,"Out for Delivery",null,null); 
			Order order2 = new Order(new Date(2022, 11, 15), new Date(2022, 11, 22),new Date(2022, 11, 18) ,false,"Return Order",null,null); 
			Order order3 = new Order(new Date(2022, 11, 20), new Date(2022, 11, 27), new Date(2022, 11, 25), true, "Received",null, null);
			Order order4 = new Order(new Date(2022, 11, 28), new Date(2022, 12, 10), new Date(2022, 11, 30), false, "Cancelled",null, null);
			
			List<Order> orderlist = new ArrayList<>();
			
			//add in list
			orderlist .add(order1);
			orderlist .add(order2);
			orderlist .add(order3);
			orderlist .add(order4);

			return orderlist;
		
			}
		
	//********************************************* OrderDetail Class *******************************************************
	
	public List<OrderDetail> createOrderDetail(){
			
			
			//Create object
			OrderDetail ordetail1 = new OrderDetail(2,550.70,1,null); 
			OrderDetail ordetail2 = new OrderDetail(2,526.34,2,null); 
			OrderDetail ordetail3 = new OrderDetail(2,600.34,3,null); 
			OrderDetail ordetail4 = new OrderDetail(2,900.34,3,null); 
			
			List<OrderDetail> orderDetaillist = new ArrayList<>();

			//add in list
		    orderDetaillist.add(ordetail1);
			orderDetaillist.add(ordetail2);
			orderDetaillist.add(ordetail3);
			orderDetaillist.add(ordetail4);
			
			
			return  orderDetaillist;

			}
		
	//********************************************* Customer Class *******************************************************
	
	public List<Customer> createCustomer(){
			
			//Customer Object
			
			Customer customer1 = new Customer(1L,"Nikita Singh","Singh","Nikita", "79797979708","Kalinagar, Namkum", "Kalinagar ,Namkum",
		 			 "Ranchi","Jharkhand", 834010,"India", 12L, 50L, null, null,null);	 
			Customer customer2 = new Customer(2L,"Cherry Thakur","Thakur","Cherry","9800994509","Ranchi,Jharkhand","Namkum,Ranchi","Ranchi"
					 ,"Jharkhand", 834010,"India",12L,10L,null,null,null);
			Customer customer3 = new Customer(3L,"Anamika Kumari","Kumari","Anamika","8989899357","Ranchi,Jharkhand","Namkum,Ranchi","Ranchi"
				 			 ,"Jharkhand", 834010,"India",12L,10L,null,null,null);
			Customer customer4 = new Customer(4L,"Md Ragib Zafar","Zafar","Md Ragib","9857677620","Khunti,Jharkhand","Khunti,Ranchi","Ranchi"
		 			 ,"Jharkhand", 834010,"India",12L,10L,null,null,null);

		
			//add in list
			List<Customer> customerList = new ArrayList<>();
			 customerList.add(customer1);
			 customerList.add(customer2);
			 customerList.add(customer3);
			 customerList.add(customer4);
				

			
			return  customerList;
			
			}
		
	//********************************************* Payment Class *******************************************************
	
	public List<Payment>  createPayment(){
			
			
			//Create object
			Payment pay1 = new Payment(1L,new Date(2022, 11, 10) ,550.70,null); 
			Payment pay2 = new Payment(2L,new Date(2022, 11, 15) ,526.34,null); 
			Payment pay3 = new Payment(3L,new Date(2022, 11, 25) ,1200.34,null); 
		
			
			List<Payment> paymentlist = new ArrayList<>();
			//add in list
			paymentlist.add(pay1);
			paymentlist.add(pay2);
			paymentlist.add(pay3);
		
			
			return paymentlist;
		
			}
	
	//********************************************* Employee Class *******************************************************
	
	public List<Employee> createEmployee(){
			
			
			//Employee Object
			Employee employee1 = new Employee(1L,"Jonas", "Priyanka", "Work From Home", "priyanka06@gmail.com", 
					"COMTECH21", "Madho Pasupuleti", "Cloud server", null, null,null);
			
			Employee employee2 = new Employee(2L,"Kumar","Sunil","Full-time","kumarsunil9876@gmail.com",
					"Amazon Development Centre","Julia Nayer","IT_PROG",null,null,null);

			Employee employee3 = new Employee(3L,"Das","Tina","Full-time","dastina675@gmail.com",
				  			"Amazon Development Centre","Julia Nayer","IT_PROG",null,null,null);
		
			
			
			List<Employee> employeelist = new ArrayList<>();
			
			//add in list
			employeelist.add(employee1);
			employeelist.add(employee2);
			employeelist.add(employee3);
		
		
			return employeelist;
		
		}
		
	//********************************************* Office Class *******************************************************
	
	public List<Office> createOffice(){
			
			//Create object
			Office office1 = new Office(1L,"Punjab","9800900811","Chandigarh Road","Sector 1","Punjab","India",560040,"Chandigarh",null);
			Office office2 = new Office(2L,"Bengalore","9876543211","Ferns City Road","Mahadevapura","Bengalore","India",560048,"Hyderabad",null);
			Office office3 = new Office(3l,"Ranchi", "9992344910", "Kanke Road Ranchi","Hinoo Doranda Ranchi","Jharkhand", "India", 834012, "Pvt Area", null); 	 
			
			List<Office> officelist = new ArrayList<>();
			
			//add in list	
			officelist.add(office1);
			officelist.add(office2);
			officelist.add(office3);
		
			return officelist;
		
		}

}
