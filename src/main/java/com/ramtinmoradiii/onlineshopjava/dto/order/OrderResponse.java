package com.ramtinmoradiii.onlineshopjava.dto.order;

import com.ramtinmoradiii.onlineshopjava.entity.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Long id;
    private String trackingCode;
    private OrderStatus status;
    private String placedAt;

    private Long totalAmount;
    private boolean isPaid;

    private String fullAddress;
    private String postalCode;
    private String receiverName;

    private List<OrderItemResponse> items;
}