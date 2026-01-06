package com.ramtinmoradiii.onlineshopjava.repository.order;

import com.ramtinmoradiii.onlineshopjava.entity.order.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void deleteAllByCartId(Long cartId);
}
