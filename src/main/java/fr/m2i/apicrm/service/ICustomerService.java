package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}