package com.ramtinmoradiii.onlineshopjava.entity.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.enums.InvoiceStatus;
import com.ramtinmoradiii.onlineshopjava.entity.user.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private Set<InvoiceItem> items;

    @Column(nullable = false)
    private Long totalAmount;

    private Long shippingCost;


    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String fullAddress;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverPhone;


    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime issuedAt;

    private LocalDateTime paidAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status;
}