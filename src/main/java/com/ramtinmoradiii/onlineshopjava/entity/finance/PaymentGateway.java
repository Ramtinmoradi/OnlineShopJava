package com.ramtinmoradiii.onlineshopjava.entity.finance;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentGateway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Builder.Default
    private boolean enable = true;

    private String merchantId;
    private String apiKey;

    @Column(name = "sort_order")
    private Integer orderItem;
}
