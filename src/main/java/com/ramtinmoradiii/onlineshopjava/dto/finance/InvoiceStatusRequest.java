package com.ramtinmoradiii.onlineshopjava.dto.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.enums.InvoiceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InvoiceStatusRequest {
    @NotNull(message = "وضعیت جدید باید مشخص باشد")
    private InvoiceStatus status;
}