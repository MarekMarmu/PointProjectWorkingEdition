package com.point.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NotMatchingPriceException extends Exception {
    String message;
}
