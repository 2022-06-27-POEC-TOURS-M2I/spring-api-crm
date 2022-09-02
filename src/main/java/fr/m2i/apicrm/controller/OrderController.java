package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.OrderDTO;
import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.response.ErrorResponseEntity;
import fr.m2i.apicrm.service.IOrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllOrder() {

        List<Order> orders = orderService.findAll();
        List<OrderDTO> dtos = new ArrayList();

        for (Order order : orders) {
            OrderDTO dto = OrderMapper.buildOrderDTO(order);
            dtos.add(dto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrderById(@PathVariable("id") String id) {
        return null;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO dto) {
        try {
            Order toCreate = OrderMapper.buildOrder(dto);
            Order created = orderService.save(toCreate);
            OrderDTO createdDTO = OrderMapper.buildOrderDTO(created);

            return ResponseEntity.status(HttpStatus.OK).body(createdDTO);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("An error occured", 500, "/v1/orders", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateOrder(@PathVariable("id") String id,
            @RequestBody OrderDTO dto) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") String id) {
        return null;
    }
}
