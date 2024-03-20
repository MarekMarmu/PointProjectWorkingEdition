package com.point.app.moneytransactions.order.dto;

import com.point.app.moneytransactions.gateway.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class OrderAck {

    private String status;

    private double totalAmount;

    private Payment payment;
}
