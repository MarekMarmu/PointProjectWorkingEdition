package com.point.app.moneytransactions.order.dto;

import com.point.app.moneytransactions.order.Order32;
import com.point.app.moneytransactions.gateway.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {

    private Payment payment;

    private Order32 order;
}
