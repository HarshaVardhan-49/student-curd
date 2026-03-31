package com.harsha.student_curd.model;

public class ErrorResponse {
    private String message;
    private int status;
    private String timestamp;

public ErrorResponse(){}
    public ErrorResponse(String message, int status, String timestamp){
    this.message=message;
    this.status=status;
    this.timestamp=timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
