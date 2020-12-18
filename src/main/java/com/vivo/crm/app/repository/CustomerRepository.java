package com.vivo.crm.app.repository;

import com.vivo.crm.app.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    CustomerEntity findByUserId (String userId);
}
