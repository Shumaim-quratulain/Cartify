package org.ecommerce.sbecom.payload;

public class APIResponse {
    public String message;
    public Boolean status;

    public APIResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
