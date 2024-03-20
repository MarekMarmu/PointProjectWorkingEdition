package com.point.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyExistException extends Exception {

    private String message;


}
