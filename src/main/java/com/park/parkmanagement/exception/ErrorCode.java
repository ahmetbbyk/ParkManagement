package com.park.parkmanagement.exception;

public enum ErrorCode {

	PROCESSING_ERROR("Processing Error "), INVALID_REQUEST("Invalid Request");

    private String message = "";

    private ErrorCode(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
