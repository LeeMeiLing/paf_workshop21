package sg.edu.nus.iss.paf_workshop21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_workshop21.models.Customer;
import sg.edu.nus.iss.paf_workshop21.models.Order;
import sg.edu.nus.iss.paf_workshop21.repositories.CustomerRepo;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepo custRepo;

    public List<Customer> getAllCustomers(int limit, int offset){
        return custRepo.getAllCustomers(limit, offset);
    }

    public Optional<Customer> getCustomerById(int id){

        return custRepo.getCustomerById(id);

    }

    public Optional<List<Order>> getOrdersByCustomerId(int id){
        return custRepo.getOrdersByCustomerId(id);
    }
}
