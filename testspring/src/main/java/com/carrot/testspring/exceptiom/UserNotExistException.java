package com.carrot.testspring.exceptiom;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在啦");
    }
}
