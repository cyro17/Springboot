package com.cyro.demo_2.excepttions;

import lombok.Getter;

import java.util.Date;

public class ErrorResponse {
    @Getter
    private Date timestamp;
    private String msg;
    @Getter
    private int status;

    public ErrorResponse(Date timestamp, String msg, int status){
        this.timestamp = timestamp;
        this.msg = msg;
        this.status = status;
    }

    public String getMessage(){
        return this.msg;
    }

}
