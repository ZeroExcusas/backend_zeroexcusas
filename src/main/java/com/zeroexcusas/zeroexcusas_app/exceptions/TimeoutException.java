package com.zeroexcusas.zeroexcusas_app.exceptions;

import org.springframework.http.HttpStatus;

public class TimeoutException extends BaseException{
    @Override
    public void define() {
        super.define();
        status = HttpStatus.BAD_REQUEST;
        keyMessage = "message.home";
    }
}
