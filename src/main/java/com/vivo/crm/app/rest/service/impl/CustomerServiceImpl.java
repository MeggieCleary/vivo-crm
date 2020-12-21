package com.vivo.crm.app.rest.service.impl;

import com.vivo.crm.app.entity.CustomerEntity;
import com.vivo.crm.app.repository.CustomerRepository;
import com.vivo.crm.app.rest.model.request.CustomerRequest;
import com.vivo.crm.app.rest.model.response.CustomerResponse;
import com.vivo.crm.app.rest.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CustomerEntity entity = modelMapper.map(customerRequest, CustomerEntity.class);
        entity.setUserId(UUID.randomUUID().toString());

        repository.save(entity);
        return modelMapper.map(entity, CustomerResponse.class);
    }

    @Override
    public void updateCustomer(String userId, String email) {
        CustomerEntity entity = repository.findByUserId(userId);
        if (entity == null)
            return;

        entity.setEmail(email);
        repository.save(entity);
    }

    @Override
    public CustomerResponse getCustomer(String userId) {
        CustomerEntity entity = repository.findByUserId(userId);
        if (entity == null)
            return null;

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(entity, CustomerResponse.class);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CustomerEntity> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);

        return customers.stream()
                .map(entity -> mapper.map(entity, CustomerResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(String userId) {
        CustomerEntity entity = repository.findByUserId(userId);
        if (entity != null) {
            repository.delete(entity);
        }
    }

    @Autowired
    public void setRepository (CustomerRepository repository) {
        this.repository = repository;
    }
}
