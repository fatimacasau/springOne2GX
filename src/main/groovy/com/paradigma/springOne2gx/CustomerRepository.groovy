package com.paradigma.springOne2gx;

import com.paradigma.springOne2gx.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by fcasau on 1/28/15.
 */
@RepositoryRestResource(collectionResourceRel = "customers", path = "customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
