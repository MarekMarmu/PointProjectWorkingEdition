package com.point.app.moneytransactions.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Size {
    XS(50),
    S(60),
    M(70),
    L(80),
    XL(90),
    XXL(100),
    XXXL(110);

    final int numberOfPieces;
}
