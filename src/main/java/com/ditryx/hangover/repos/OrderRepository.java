package com.ditryx.hangover.repos;

import com.ditryx.hangover.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(long id);
    void deleteOrderById(long id);
}
