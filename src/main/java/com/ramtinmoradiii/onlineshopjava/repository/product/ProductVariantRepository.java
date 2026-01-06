package com.ramtinmoradiii.onlineshopjava.repository.product;

import com.ramtinmoradiii.onlineshopjava.entity.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant,Long> {
    List<ProductVariant> findAllByProductId(Long productId);
}
