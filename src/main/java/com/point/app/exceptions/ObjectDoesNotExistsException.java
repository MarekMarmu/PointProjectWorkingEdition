package com.point.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ObjectDoesNotExistsException extends Exception{
    private String message;

}
