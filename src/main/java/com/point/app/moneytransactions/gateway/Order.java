package com.point.app.moneytransactions.gateway;
public record Order(double price, String currency, String method, String intent, String description) {}