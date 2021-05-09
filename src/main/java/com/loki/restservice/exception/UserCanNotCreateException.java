package com.loki.restservice.exception;

public class UserCanNotCreateException extends RuntimeException {
    public UserCanNotCreateException(String user_can_not_be_created) {
        super(user_can_not_be_created);
    }
}
