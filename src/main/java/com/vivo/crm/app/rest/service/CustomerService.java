package com.vivo.crm.app.rest.service;

import com.vivo.crm.app.rest.model.request.CustomerRequest;
import com.vivo.crm.app.rest.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);

    void updateCustomer(String userId, String email);

    CustomerResponse getCustomer(String userId);

    List<CustomerResponse> getAllCustomers();

    void deleteCustomer(String userId);
}
