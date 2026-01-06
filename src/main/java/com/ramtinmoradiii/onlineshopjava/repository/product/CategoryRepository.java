package com.ramtinmoradiii.onlineshopjava.repository.product;

import com.ramtinmoradiii.onlineshopjava.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
