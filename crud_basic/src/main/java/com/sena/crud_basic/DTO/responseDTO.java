package com.sena.crud_basic.DTO;
import org.springframework.http.HttpStatus;
public class responseDTO {
    private String message;
    private HttpStatus status;

    public responseDTO( HttpStatus status,String message) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }   
}
