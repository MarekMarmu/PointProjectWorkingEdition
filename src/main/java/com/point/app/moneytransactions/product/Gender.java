package com.point.app.moneytransactions.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    M("Male"),
    F("Female");

    private String inString;
}
