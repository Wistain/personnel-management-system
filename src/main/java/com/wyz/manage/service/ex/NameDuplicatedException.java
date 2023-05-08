package com.wyz.manage.service.ex;

public class NameDuplicatedException extends ServiceException{
    public NameDuplicatedException() {
        super();
    }

    public NameDuplicatedException(String message) {
        super(message);
    }

    public NameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected NameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
