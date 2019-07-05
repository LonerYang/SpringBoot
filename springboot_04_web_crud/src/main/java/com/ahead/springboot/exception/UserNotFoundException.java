package com.ahead.springboot.exception;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/13
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
