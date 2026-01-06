package com.ramtinmoradiii.onlineshopjava.repository.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
