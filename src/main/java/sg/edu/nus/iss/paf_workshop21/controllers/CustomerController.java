package sg.edu.nus.iss.paf_workshop21.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_workshop21.models.Customer;
import sg.edu.nus.iss.paf_workshop21.models.ErrorObject;
import sg.edu.nus.iss.paf_workshop21.models.Order;
import sg.edu.nus.iss.paf_workshop21.services.CustomerService;

@RestController
@RequestMapping(path= {"/api"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    
    @Autowired
    CustomerService custSvc;

    // @RestController converts List<Customer> to JSON array of JSON 'customer' object
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(@RequestParam(defaultValue = "5") int limit, @RequestParam(defaultValue = "0") int offset){
        return custSvc.getAllCustomers(limit, offset);
    }

    // // @RestController auto converts Customer to JSON format
    // // return Customer object as JSON object
    // @GetMapping("/{id}")
    // public Customer getCustomerById(@PathVariable int id){

    //     Optional<Customer> customer = custSvc.getCustomerById(id);

    //     return customer.get();

    // }


    // ResponseEntity<Object> can still auto converts Customer object to JSON format
    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int id){

        Optional<Customer> customer = custSvc.getCustomerById(id);

        if (customer.isPresent()){
            return ResponseEntity.ok().body(customer.get());   // this will auto converts customer object to a JSON format

        }else{

            // return ResponseEntity.notFound().build();    // this is used if method return type is ResponseEntity<Customer>, no response body
            // return ResponseEntity.status(404).body("Customer ID Not Found");    // response body is just a string

            return ResponseEntity.status(404).body(new ErrorObject("Customer ID Not Found")); // response body is an Error object in JSON format

        }

    }


    @GetMapping("/customer/{customer_id}/orders")
    // @RestController converts List<Order> to JSON array of JSON 'order' object
    // public List<Order> getOrdersByCustomerId(@PathVariable int customer_id){
    public ResponseEntity<Object> getOrdersByCustomerId(@PathVariable int customer_id){

        Optional<List<Order>> result = custSvc.getOrdersByCustomerId(customer_id);

        // return 404 with error object if customer not found
        if(result.isEmpty()){

            return ResponseEntity.status(404).body(new ErrorObject("No order due to Customer ID Not Found")); // response body is an Error object in JSON format
        
        }else{

            // return the list, can be empty list if the customer does not have any order
            return ResponseEntity.ok().body(result.get()); 

        }

        // // use the following code to customise response for empty list
        // List<Order> orderList = result.get();

        // // If List is empty, return empty array
        // if(orderList.isEmpty()){    // cannot use if(null == orderList), an empty List is not a null

        //     return ResponseEntity.ok().body(orderList); 
        

        // // If List contains elements, return the List of Order
        // }else{

        //     return ResponseEntity.ok().body(orderList);

        // }
        
    }

}