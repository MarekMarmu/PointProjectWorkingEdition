package com.point.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductDoesNotExistException extends RuntimeException{
    String message;

    }

