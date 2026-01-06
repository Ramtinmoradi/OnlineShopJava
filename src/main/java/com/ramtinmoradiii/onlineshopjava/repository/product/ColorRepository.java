package com.ramtinmoradiii.onlineshopjava.repository.product;

import com.ramtinmoradiii.onlineshopjava.entity.product.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
