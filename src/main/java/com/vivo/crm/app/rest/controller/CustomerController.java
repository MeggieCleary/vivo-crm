package com.vivo.crm.app.rest.controller;

import com.vivo.crm.app.rest.model.request.CustomerRequest;
import com.vivo.crm.app.rest.model.response.CustomerResponse;
import com.vivo.crm.app.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService (CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> createCustomer (@RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerService.createCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerResponse> getAllCustomers () {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> getCustomer (@PathVariable String userId) {
        CustomerResponse customerResponse = customerService.getCustomer(userId);
        if (customerResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateCustomer (@PathVariable String userId, @RequestBody String email) {
        customerService.updateCustomer(userId, email);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{userId}")
    public HttpStatus deleteCustomer (@PathVariable String userId) {
        customerService.deleteCustomer(userId);
        return HttpStatus.NO_CONTENT;
    }
}
