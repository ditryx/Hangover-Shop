package com.ditryx.hangover.DAO;

import com.ditryx.hangover.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById (long id);
    void save(Order order);
    void delete(long id);
}
