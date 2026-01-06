package com.ramtinmoradiii.onlineshopjava.entity.finance;

import com.ramtinmoradiii.onlineshopjava.entity.product.Color;
import com.ramtinmoradiii.onlineshopjava.entity.product.Product;
import com.ramtinmoradiii.onlineshopjava.entity.product.Size;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(nullable = false)
    private Long unitPrice;

    @Column(nullable = false)
    private Integer quantity;

    public Long getTotalItemPrice() {
        if (unitPrice == null || quantity == null) return 0L;
        return unitPrice * quantity;
    }
}