package com.ditryx.hangover.DAO;

import com.ditryx.hangover.entities.OrderPosition;

import java.util.List;

public interface OrderPositionService {
    List<OrderPosition> findAll();
    OrderPosition findById (long id);
    void save(OrderPosition orderPosition);
    void delete(long id);
}
