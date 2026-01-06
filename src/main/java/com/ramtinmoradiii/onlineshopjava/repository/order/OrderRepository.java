package com.ramtinmoradiii.onlineshopjava.repository.order;

import com.ramtinmoradiii.onlineshopjava.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByTrackingCode(String trackingCode);

    List<Order> findAllByCustomerId(Long customerId);
}
