package com.ditryx.hangover.repos;

import com.ditryx.hangover.entities.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPositionRepository extends JpaRepository<OrderPosition, Long> {

    OrderPosition findOrderPositionById(long id);
    void deleteOrderPositionById(long id);

}
