package com.ramtinmoradiii.onlineshopjava.entity.order;

import com.ramtinmoradiii.onlineshopjava.entity.product.ProductVariant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Column(nullable = false)
    private Integer quantity;

    public Long getRowTotalPrice() {
        if (productVariant == null) return 0L;
        long price = (productVariant.getPriceOverride() != null)
                ? productVariant.getPriceOverride()
                : productVariant.getProduct().getPrice();
        return price * quantity;
    }
}