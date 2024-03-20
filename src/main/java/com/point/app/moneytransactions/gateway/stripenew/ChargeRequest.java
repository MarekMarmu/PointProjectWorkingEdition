package com.point.app.moneytransactions.gateway.stripenew;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR, USD;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
}