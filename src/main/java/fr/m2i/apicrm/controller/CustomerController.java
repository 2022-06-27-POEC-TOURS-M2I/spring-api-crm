package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.service.ICustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCustomer() {

        List<Customer> customers = customerService.findAll();
        List<CustomerDTO> dtos = new ArrayList();

        for (Customer customer : customers) {
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(customer);
            dtos.add(dto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
