package com.ditryx.hangover.DAO.Implementation;

import com.ditryx.hangover.DAO.OrderPositionService;
import com.ditryx.hangover.entities.OrderPosition;
import com.ditryx.hangover.repos.OrderPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderPositionService")
public class OrderPositionServiceImpl implements OrderPositionService {

    private final OrderPositionRepository orderPositionRepository;

    @Autowired
    public OrderPositionServiceImpl(OrderPositionRepository orderPositionRepository) {
        this.orderPositionRepository = orderPositionRepository;
    }

    @Override
    public List<OrderPosition> findAll() {
        return orderPositionRepository.findAll();
    }

    @Override
    public OrderPosition findById(long id) {
        return orderPositionRepository.findOrderPositionById(id);
    }

    @Override
    public void save(OrderPosition orderPosition) {
        orderPositionRepository.save(orderPosition);
    }

    @Override
    public void delete(long id) {
        orderPositionRepository.deleteOrderPositionById(id);
    }
}
