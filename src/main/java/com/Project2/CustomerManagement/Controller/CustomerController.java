package com.Project2.CustomerManagement.Controller;

import com.Project2.CustomerManagement.exception.ResourceNotFoundException;
import com.Project2.CustomerManagement.model.Customers;
import com.Project2.CustomerManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Get All Customers
    @GetMapping("/customers")
    public List<Customers> getAllCustomers()
    {

        return this.customerRepository.findAll();
    }

    // Get Customers by ID
    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable(value = "customerID") UUID customerID)
    {
        Customers customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + customerID));
        return ResponseEntity.ok(customer);
    }

    // Create Customer
    @PostMapping("/customers")
    public Customers createEmployee(@RequestBody Customers customer) {
        return customerRepository.save(customer);
    }

    // Multiple Create at once
    @PostMapping("/customers/MultipleCreate")
    public ResponseEntity<?> createCustomersBatch(@RequestBody List<Customers> customers) {
        try {
            List<Customers> savedCustomers = customerRepository.saveAll(customers);
            return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating customers: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Customers by ID
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customers> updateEmployee(@PathVariable UUID ID, @RequestBody Customers customerDetails){
        Customers customer = customerRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + ID));

        customer.setfName(customerDetails.getfName());
        customer.setlName(customerDetails.getlName());
        customer.setAge(customerDetails.getAge());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setGender(customerDetails.getGender());


        Customers updatedEmployee = customerRepository.save(customer);
        return ResponseEntity.ok(updatedEmployee);
    }
    // Delete Customers by ID
    @DeleteMapping("/customers/{ID}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable UUID ID){
        Customers employee = customerRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + ID));

        customerRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // Delete All Customers
    @DeleteMapping("/customers/DeleteAll")
    public ResponseEntity<Map<String, Boolean>> deleteAllCustomers() {
        List<Customers> allCustomers = customerRepository.findAll();

        for (Customers customer : allCustomers) {
            customerRepository.delete(customer);
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("deletedAll", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
