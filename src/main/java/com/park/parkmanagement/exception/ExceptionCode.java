package com.park.parkmanagement.exception;


public enum ExceptionCode {

	PRARKING_ERROR(1,"Parking Error "), LEAVING_ERROR(2,"Leaving Error "), LISTING_ERROR(3,"Listing Error "),
	VEHICLE_EMPTY(4,"Vehicle is empty! You must enter vehicle information."),INVALID_REQUEST(5,"Invalid Request"),
	VEHICLE_ID_CANNOT_BE_GRATER_TEN(6,"Vehicle no cannot be greater than ten."),VEHICLE_CANNOT_BE_FOUND(7,"Vehicle cannot be found."),
	VEHICLE_ALLREADY_EXIST(8,"Vehicle allready exist");

    String message = "";
    int excCode ;

    private ExceptionCode(String message)
    {
        this.message = message;
    }

    ExceptionCode(int ex, String message) {
    	this.message = message;
    	this.excCode = ex;
	}

	public String getMessage()
    {
        return message;
    }
	public int getExcCode()
    {
        return excCode;
    }
}
