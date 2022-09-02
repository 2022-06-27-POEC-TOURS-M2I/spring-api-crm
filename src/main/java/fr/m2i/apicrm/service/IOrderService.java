package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Order;
import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    Order update(Long id, Order content);

    void delete(Long id);
}
