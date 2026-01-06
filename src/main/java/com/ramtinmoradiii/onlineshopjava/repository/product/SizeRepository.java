package com.ramtinmoradiii.onlineshopjava.repository.product;

import com.ramtinmoradiii.onlineshopjava.entity.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}
