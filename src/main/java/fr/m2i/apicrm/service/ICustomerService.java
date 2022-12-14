package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);
}
