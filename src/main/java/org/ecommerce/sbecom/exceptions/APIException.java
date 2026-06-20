package org.ecommerce.sbecom.exceptions;

public class APIException extends RuntimeException {
    String message;
    public APIException(String message) {
        super(message);
    }
    public APIException() {
    }
}
