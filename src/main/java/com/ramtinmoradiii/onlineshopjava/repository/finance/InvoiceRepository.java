package com.ramtinmoradiii.onlineshopjava.repository.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByNumber(String number);

    List<Invoice> findAllByCustomerId(Long customerId);
}
