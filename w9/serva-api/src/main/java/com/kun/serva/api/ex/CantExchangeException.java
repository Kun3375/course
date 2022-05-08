package com.kun.serva.api.ex;

/**
 * @author kun
 * @date 2022/5/8
 */
public class CantExchangeException extends RuntimeException {
    private static final long serialVersionUID = 4836248551997519624L;

    public CantExchangeException() {
    }

    public CantExchangeException(String message) {
        super(message);
    }

    public CantExchangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantExchangeException(Throwable cause) {
        super(cause);
    }

    public CantExchangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
