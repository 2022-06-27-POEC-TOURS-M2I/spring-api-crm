package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repo;

    @Autowired
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

}
