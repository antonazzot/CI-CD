package com.tsyrkunou.kubernetec.exceptionhandlers;

public class MyAppException extends RuntimeException {
    public MyAppException() {
        super();
    }

    public MyAppException(String message) {
        super(message);
    }

    public MyAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
