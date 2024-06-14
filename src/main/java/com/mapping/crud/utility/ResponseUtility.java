package com.mapping.crud.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class ResponseUtility<T> {
	// Fields to hold status code, message, and data
    private String statusCode;
    private String message;
    private T data;

    // Constructor to initialize the fields
    public ResponseUtility(String statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


   

    // Method to create a response entity with HTTP status code for not acceptable
    public static <T> ResponseEntity<ResponseUtility<T>> notAcceptable(String message) {
        // Create a ResponseUtility object with NOT_ACCEPTABLE status code and the provided message
        ResponseUtility<T> responseBody = new ResponseUtility<>("NOT_ACCEPTABLE", message, null);
        // Create and return a ResponseEntity with NOT_ACCEPTABLE status and the ResponseUtility object as body
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
    }

    // Method to create a response entity with HTTP status code for successful creation
    public static <T> ResponseEntity<ResponseUtility<T>> successCreated(String message, T data) {
        // Create a ResponseUtility object with CREATED status code, the provided message, and data
        ResponseUtility<T> responseBody = new ResponseUtility<>("CREATED", message, data);
        // Create and return a ResponseEntity with CREATED status and the ResponseUtility object as body
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }



    // Add more utility methods as needed for different HTTP status codes
    
    // Getters and setters for statusCode, message, and data

    public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	


	
}
