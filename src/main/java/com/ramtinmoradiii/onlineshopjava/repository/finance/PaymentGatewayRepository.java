package com.ramtinmoradiii.onlineshopjava.repository.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.PaymentGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentGatewayRepository extends JpaRepository<PaymentGateway, Long> {
    Optional<PaymentGateway> findByCode(String code);

    List<PaymentGateway> findAllByEnableTrueOrderByOrderItemAsc();
}
