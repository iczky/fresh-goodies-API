package com.freshGoodies.userstories.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Setter
@Getter
public class Response<T> {
    private int statusCode;
    private boolean success = false;
    private String message;
    private T data;

    public Response(int statusCode, String message, T data){
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;

        if(statusCode == HttpStatus.OK.value()){
            this.success = true;
        }
    }
    public static <T> ResponseEntity<Response<T>> failedResponse(int statusCode, String message, T data){
        Response<T> response = new Response<>(statusCode, message, data);
        response.setSuccess(false);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static <T> ResponseEntity<Response<T>> failedResponse(String message, T data){
        return failedResponse(HttpStatus.BAD_REQUEST.value(), message, data);
    }

    public static <T> ResponseEntity<Response<T>> failedResponse(T data){
        return failedResponse(HttpStatus.BAD_REQUEST.value(), "Bad Request", data);
    }

    public static <T> ResponseEntity<Response<Object>> failedResponse(String message){
        return failedResponse(HttpStatus.BAD_REQUEST.value(), message, null);
    }

    public static <T> ResponseEntity<Response<T>> successResponse(int statusCode, String message, T data){
        Response<T> response = new Response<>(statusCode, message, data);
        response.setSuccess(true);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static <T> ResponseEntity<Response<T>> successResponse(String message, T data){
        return successResponse(HttpStatus.OK.value(), message, data);
    }


    public static <T> ResponseEntity<Response<T>> successResponse(T data){
        return failedResponse(HttpStatus.OK.value(), "Request Successfull", data);
    }

    public static <T> ResponseEntity<Response<Object>> successResponse(String message){
        return failedResponse(HttpStatus.OK.value(), message, null);
    }
}
